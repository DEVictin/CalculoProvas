package exercises;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Listas para armazenar os dados dos arquivos
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();

        // Leitura de Alunos.txt e criação dos objetos Aluno
        carregar("Alunos.txt", linha -> {
            String[] dados = linha.split(";");
            int matricula = Integer.parseInt(dados[0]);
            String nome = dados[1];
            int idade = Integer.parseInt(dados[2]);
            alunos.add(new Aluno(matricula, nome, idade));
        });

        // Leitura de Disciplinas.txt e criação dos objetos Disciplina
        carregar("Disciplinas.txt", linha -> {
            String[] dados = linha.split(";");
            int codigo = Integer.parseInt(dados[0]);
            String nome = dados[1];
            float notaMinima = Float.parseFloat(dados[2]);
            disciplinas.add(new Disciplina(codigo, nome, notaMinima));
        });

        // Leitura de Cursos.txt e criação dos objetos Curso
        carregar("Cursos.txt", linha -> {
            String[] dados = linha.split(";");
            int matricula = Integer.parseInt(dados[0]);
            int codDisc = Integer.parseInt(dados[1]);
            float nota1 = Float.parseFloat(dados[2]);
            float nota2 = Float.parseFloat(dados[3]);
            cursos.add(new Curso(matricula, codDisc, nota1, nota2));
        });

        Scanner input = new Scanner(System.in);

        // Menu principal do sistema
        while (true) {
            System.out.println("\n1 - Buscar resultados\n2 - Sair");
            System.out.print("Escolha: ");
            String opcao = input.nextLine();

            // Encerrar programa se usuário digitar 2
            if (opcao.equals("2")) break;

            System.out.println("\n1 - Por Aluno\n2 - Por Disciplina");
            System.out.print("Escolha: ");
            String tipo = input.nextLine();

            System.out.print("Digite nome ou código: ");
            String chave = input.nextLine();

            // Busca por aluno
            if (tipo.equals("1")) {
                buscarPorAluno(chave, alunos, disciplinas, cursos);
            }
            // Busca por disciplina
            else if (tipo.equals("2")) {
                buscarPorDisciplina(chave, alunos, disciplinas, cursos);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        input.close();
        System.out.println("Fim do programa.");
    }

    // Função genérica que carrega qualquer arquivo e aplica uma ação para cada linha
    public static void carregar(String caminho, java.util.function.Consumer<String> acao) {
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextLine()) acao.accept(sc.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler arquivo: " + caminho);
        }
    }

    // Realiza a busca de resultados por aluno (nome ou matrícula)
    public static void buscarPorAluno(String chave, List<Aluno> alunos, List<Disciplina> disciplinas, List<Curso> cursos) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(chave) || String.valueOf(aluno.getMatricula()).equals(chave)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Aluno: ").append(aluno.getNome())
                  .append(" | Matrícula: ").append(aluno.getMatricula()).append("\n");

                // Busca as disciplinas associadas ao aluno pela matrícula
                for (Curso c : cursos) {
                    if (c.getMatricula() == aluno.getMatricula()) {
                        // Encontra o nome e nota mínima da disciplina
                        Disciplina d = disciplinas.stream()
                            .filter(di -> di.getCodigoDisciplina() == c.getCodigoDisciplina())
                            .findFirst().orElse(null);

                        if (d != null) {
                            float media = (c.getNota1() + c.getNota2()) / 2;
                            String status = media >= d.getNotaMinima() ? "Aprovado" : "Reprovado";

                            sb.append("Disciplina: ").append(d.getNome())
                              .append(" | Notas: ").append(c.getNota1()).append(", ").append(c.getNota2())
                              .append(" | Média: ").append(String.format("%.2f", media))
                              .append(" | ").append(status).append("\n");
                        }
                    }
                }

                System.out.println(sb); // Exibe no terminal
                salvar(sb.toString(), aluno.getMatricula() + ".txt"); // Salva o resultado em arquivo
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    // Realiza a busca de resultados por disciplina (nome ou código)
    public static void buscarPorDisciplina(String chave, List<Aluno> alunos, List<Disciplina> disciplinas, List<Curso> cursos) {
        for (Disciplina disc : disciplinas) {
            if (disc.getNome().equalsIgnoreCase(chave) || String.valueOf(disc.getCodigoDisciplina()).equals(chave)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Disciplina: ").append(disc.getNome())
                  .append(" | Código: ").append(disc.getCodigoDisciplina()).append("\n");

                // Busca todos os alunos vinculados à disciplina
                for (Curso c : cursos) {
                    if (c.getCodigoDisciplina() == disc.getCodigoDisciplina()) {
                        Aluno aluno = alunos.stream()
                            .filter(a -> a.getMatricula() == c.getMatricula())
                            .findFirst().orElse(null);

                        if (aluno != null) {
                            float media = (c.getNota1() + c.getNota2()) / 2;
                            String status = media >= disc.getNotaMinima() ? "Aprovado" : "Reprovado";

                            sb.append("Aluno: ").append(aluno.getNome())
                              .append(" | Matrícula: ").append(aluno.getMatricula())
                              .append(" | Notas: ").append(c.getNota1()).append(", ").append(c.getNota2())
                              .append(" | Média: ").append(String.format("%.2f", media))
                              .append(" | ").append(status).append("\n");
                        }
                    }
                }

                System.out.println(sb); // Exibe no terminal
                salvar(sb.toString(), disc.getCodigoDisciplina() + ".txt"); // Salva o resultado em arquivo
                return;
            }
        }

        System.out.println("Disciplina não encontrada.");
    }

    // Salva o conteúdo formatado em um arquivo de texto
    public static void salvar(String conteudo, String nomeArquivo) {
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(conteudo);
            System.out.println("Arquivo salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + nomeArquivo);
        }
    }
}
