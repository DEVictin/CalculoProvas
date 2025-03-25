package exercises;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;

    // ConstrutorMain
    public Aluno(int matricula, String nome, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
//Quando inserir no txt: matricula;nome;idade
