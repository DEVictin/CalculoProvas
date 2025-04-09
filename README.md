# 📚 Sistema de Consulta de Resultados Acadêmicos

Sistema em Java que permite consultar resultados de alunos ou disciplinas a partir da leitura de arquivos `.txt`, com geração automática de relatórios. Ideal para controle acadêmico simples por terminal.

---

## 🚀 Funcionalidades

- 📥 Leitura de dados de três arquivos:
  - `Alunos.txt`
  - `Disciplinas.txt`
  - `Cursos.txt`
- 📊 Armazenamento em vetores de objetos
- 🧭 Menu interativo com as opções:
  - Buscar resultados
    - Por aluno (nome ou matrícula)
    - Por disciplina (nome ou código)
  - Sair do programa
- ✅ Verificação de aprovação:
  - Aprovado: média ≥ nota mínima da disciplina
  - Reprovado: média < nota mínima
- 📄 Geração de relatórios:
  - Por aluno → `matricula.txt`
  - Por disciplina → `codigo.txt`

---

## 💻 Como usar

1. Clone o repositório:

```bash
git clone https://github.com/DEVictin/CalculoProvas.git
```

2. Compile o projeto:

```bash
javac Main.java
```

3. Execute o programa:

```bash
java Main
```

4. Siga o menu exibido no terminal.

---

## 🗂 Exemplo de arquivos de entrada

### 📄 Alunos.txt

```
20231001;Victor Vertuani;Sistemas de informação
```

### 📄 Disciplinas.txt

```
INF101;Algoritmos I;6.0
```

### 📄 Cursos.txt

```
Sistemas de informação;INF101;20231001;7.5;8.0;6.5
```

---

## 📎 Estrutura do Projeto

- `Main.java`: Classe principal com menu e lógica de execução
- `Aluno.java`: Objeto com dados de aluno (matrícula, nome, curso)
- `Disciplina.java`: Objeto com dados da disciplina (código, nome, nota mínima)
- `Curso.java`: Associação entre alunos, disciplinas e notas
- `Utils.java`: Métodos auxiliares (leitura, escrita e cálculos)

---


## 👨‍💻 Autor

Desenvolvido por **Victor Vertuani** – sinta-se à vontade para contribuir, sugerir melhorias ou relatar problemas.
