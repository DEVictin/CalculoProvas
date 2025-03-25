package exercises;

public class Curso {
    private int matricula;
    private int codigoDisciplina;
    private float nota1;
    private float nota2;

    // ConstrutorMain
    public Curso(int matricula, int codigoDisciplina, float nota1, float nota2) {
        this.matricula = matricula;
        this.codigoDisciplina = codigoDisciplina;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }
}
//Quando inserir no txt: matricula;codigoDaDisciplina;nota1;nota2
