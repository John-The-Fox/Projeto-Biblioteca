import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco_de_dados_Livros {
    private List<Livro> livros = new ArrayList<Livro>();

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
    Livro obterLivroPorAutor(String livroAutor) {
        for (Livro livro : livros) {
            if (Objects.equals(livro.getAutor(), livroAutor)) {
                return livro;
            }
        }
        return null;
    }
    Livro obterLivroPorGenero(String livroGenero) {
        for (Livro livro : livros) {
            if (Objects.equals(livro.getGenero(), livroGenero)) {
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
}
