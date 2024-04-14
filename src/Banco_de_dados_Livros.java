import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco_de_dados_Livros {
    private final List<Livro> livros = new ArrayList<>();

    void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    Livro obterLivroPorTitulo(String livroTitulo) {
        for (Livro livro : livros) {
            if (Objects.equals(livro.getTitulo(), livroTitulo)) {
                return livro;
            }
        }
        return null;
    }

    Livro obterLivroPorISBN(String livroISBN) {
        for (Livro livro : livros) {
            if (Objects.equals(livro.getISBN(), livroISBN)) {
                return livro;
            }
        }
        return null;
    }
    void removerLivroPorISBN(String livroISBN) {
        livros.removeIf(livro -> Objects.equals(livro.getISBN(), livroISBN));
    }
    public List<Livro> obterLivros() {
        return livros;
    }
    public List<Livro> pesquisarLivros(String nome, String autor, String genero, String ISBN) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : livros) {
            if ((nome.isEmpty() || livro.getTitulo().contains(nome)) &&
                    (autor.isEmpty() || livro.getAutor().contains(autor)) &&
                    (genero.isEmpty() || livro.getGenero().contains(genero)) &&
                    (ISBN.isEmpty() || livro.getISBN().equals(ISBN))) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

}
