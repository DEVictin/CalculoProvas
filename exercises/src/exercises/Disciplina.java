package exercises;

public class Disciplina {
    private int codigoDisciplina;
    private String nome;
    private float notaMinima;

    // ConstrutorMain
    public Disciplina(int codigoDisciplina, String nome, float notaMinima) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.notaMinima = notaMinima;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public float getNotaMinima() {
        return notaMinima;
    }
}
// Quando inserir no txt: codigoDisciplina;nome;notaMinima
