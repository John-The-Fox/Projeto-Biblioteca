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
    public String getAutor() {
        return autor;
    }
    public String getGenero() {
        return genero;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getAno() {
        return ano;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}
