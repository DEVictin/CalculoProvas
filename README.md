# 📚 Sistema de Consulta de Resultados Acadêmicos

Este projeto é um sistema em Java para **consulta de resultados de provas de alunos**, com leitura de dados a partir de arquivos `.txt` e geração automática de relatórios. Ideal para controle acadêmico por aluno ou por disciplina.

---

## 🚀 Funcionalidades

- 📥 Leitura de dados de **3 arquivos de entrada**:
  - `Alunos.txt`
  - `Disciplinas.txt`
  - `Cursos.txt`
  - 
- 📊 Armazenamento das informações em **objetos e vetores**.
- 🧭 Interface por menu no terminal com as opções:
  - **Buscar resultados**
    - Por **Aluno** (nome ou matrícula)
    - Por **Disciplina** (nome ou código)
  - **Sair**
  - 
- 📑 Exibição e geração de relatório:
  - Mostra **notas**, **média** e status: ✅ **Aprovado** ou ❌ **Reprovado**
  - Gera um arquivo `.txt` com os resultados:
    - Por aluno: `matricula.txt`
    - Por disciplina: `codigodisciplina.txt`

---

## 🧮 Regras de aprovação

- **Aprovado**: média maior ou igual à nota mínima da disciplina
- **Reprovado**: média menor que a nota mínima

---

## 💻 Como usar

1. Clone o repositório:
 ```bash
 git clone https://github.com/seu-usuario/nome-do-repo.git

2. Compile o projeto:
javac Main.java

3. Execute o programa:
java Main

4. Siga o menu exibido no terminal.

---

## 📂 Exemplo de arquivos de entrada

- Alunos.txt:   20231001;Victor Vertuani;Sistemas de informaçao

- Disciplinas.txt: INF101;Algoritmos I;6.0

- Cursos.txt: Sistemas de informaçao;INF101;20231001;7.5;8.0;6.5

---

## 👨‍💻 Autor
Desenvolvido por Victor Vertuani – sinta-se à vontade para contribuir, sugerir melhorias ou relatar problemas.
