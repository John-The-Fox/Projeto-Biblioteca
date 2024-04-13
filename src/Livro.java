public class Livro {
    Livro(String nome, String autor, int ano, String genero, String editorial) {
        this.nome = nome;
        this.autor =autor;
        this.ano = ano;
        this.genero = genero;
        this.editorial = editorial;
    }
    private String nome;
    private String autor;
    private int ano;
    private String genero;
    private String editorial;

    public String getTitulo() {
        return nome;
    }
}
