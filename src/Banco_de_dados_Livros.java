import java.util.ArrayList;
import java.util.List;

public class Banco_de_dados_Livros {
    private List<Livro> livros = new ArrayList<Livro>();

    void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    Livro obterLivroPorTitulo(String livroTitulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo() == livroTitulo) {
                return livro;
            }
        }
        return null;
    }
}
