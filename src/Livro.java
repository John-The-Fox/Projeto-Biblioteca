public class Livro {
    Livro(String nome, String autor, int ano, String genero, String ISBN) {
        this.nome = nome;
        this.autor =autor;
        this.ano = ano;
        this.genero = genero;
        this.ISBN = ISBN;
    }
    private String nome;
    private String autor;
    private int ano;
    private String genero;
    private String ISBN;

    public String getTitulo() {
        return nome;
    }
}
