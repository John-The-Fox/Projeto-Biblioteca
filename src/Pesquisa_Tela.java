import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Pesquisa_Tela  extends JFrame implements ActionListener {
    private JLabel nameLabel, autorLabel, generoLabel, ISBNLabel;
    private JTextField nameField, autorField, generoField, ISBNField;
    private JButton addButton, editButton, delButton, SrcButton;
    private JList<String> listaLivros;
    private DefaultListModel<String> livroLista;

    private Banco_de_dados_Livros baseDeDados;

    public Pesquisa_Tela(Banco_de_dados_Livros baseDeDados) {
        super("Lista de Livros");
        this.baseDeDados = baseDeDados;
        nameLabel = new JLabel("Nome");
        autorLabel = new JLabel("Autor");
        generoLabel = new JLabel("categoria");
        ISBNLabel = new JLabel("ISBN");

        nameField = new JTextField(20);
        autorField = new JTextField(20);
        generoField = new JTextField(20);
        ISBNField = new JTextField(20);

        SrcButton = new JButton("Pesquisar");
        SrcButton.setActionCommand("pesquisar");
        SrcButton.addActionListener(this);

        editButton = new JButton("Editar");
        editButton.setActionCommand("editar");
        editButton.addActionListener(this);

        delButton = new JButton("EXCLUIR");
        delButton.setActionCommand("excluir");
        delButton.addActionListener(this);

        addButton = new JButton("Novo");
        addButton.setActionCommand("novo");
        addButton.addActionListener(this);

        livroLista = new DefaultListModel<>();
        List<Livro> livros = baseDeDados.obterLivros();
        for (Livro livro : livros) {
            livroLista.addElement("nome: " + livro.getTitulo() + " - autor: " + livro.getAutor() +" - categoria: " + livro.getGenero() + " - ano: " + livro.getAno() + " - ISBN: " + livro.getISBN());
        }
        listaLivros = new JList<>(livroLista);
        listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        scrollPane.setPreferredSize(new Dimension(200, 150));

        JPanel panelButtons = new JPanel();
        panelButtons.add(addButton);
        panelButtons.add(editButton);
        panelButtons.add(delButton);
        panelButtons.add(SrcButton);

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(2, 4, 10, 10)); // 6 rows, 4 columns
        panelLabel.add(nameLabel);
        panelLabel.add(autorLabel);
        panelLabel.add(generoLabel);
        panelLabel.add(ISBNLabel);
        panelLabel.add(nameField);
        panelLabel.add(autorField);
        panelLabel.add(generoField);
        panelLabel.add(ISBNField);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelLabel, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelButtons, BorderLayout.SOUTH);

        getContentPane().add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("novo")) {
            dispose();
            // passa valores "vazio" para Editar_Tela
            new Editar_Tela("","",0,"","",baseDeDados).setVisible(true);
        }
        if (e.getActionCommand().equals("pesquisar")) {
            String nome = nameField.getText();
            String autor = autorField.getText();
            String genero = generoField.getText();
            String ISBN = ISBNField.getText();

            livroLista.clear();

            List<Livro> livrosEncontrados = baseDeDados.pesquisarLivros(nome, autor, genero, ISBN);

            for (Livro livro : livrosEncontrados) {
                livroLista.addElement("nome: " + livro.getTitulo() + " - autor: " + livro.getAutor() +" - categoria: " + livro.getGenero() + " - ano: " + livro.getAno() + " - ISBN: " + livro.getISBN());
            }
        }
        if (e.getActionCommand().equals("editar")) {
            // Obtém o livro selecionado na lista
            String livroSelecionado = listaLivros.getSelectedValue();
            // Verifica se algum livro foi selecionado
            if (livroSelecionado != null) {
                // Extrai o ISBN do livro selecionado
                String ISBN = livroSelecionado.split(" - ")[4].split(": ")[1];
                // Obtém o livro correspondente ao ISBN
                Livro livro = baseDeDados.obterLivroPorISBN(ISBN);
                // Verifica se o livro foi encontrado
                if (livro != null) {
                    // Abre a janela de edição com as informações do livro
                    dispose();
                    new Editar_Tela(livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getGenero(), livro.getISBN(), baseDeDados).setVisible(true);
                }
            }
        }
        if (e.getActionCommand().equals("excluir")) {
            // Obtém o livro selecionado na lista
            String livroSelecionado = listaLivros.getSelectedValue();
            // Verifica se algum livro foi selecionado
            if (livroSelecionado != null) {
                // Extrai o ISBN do livro selecionado
                String ISBN = livroSelecionado.split(" - ")[4].split(": ")[1];
                // Remove o livro correspondente ao ISBN do banco de dados
                baseDeDados.removerLivroPorISBN(ISBN);
                // Atualiza a lista de livros na JList
                livroLista.clear();
                List<Livro> livros = baseDeDados.obterLivros();
                for (Livro livro : livros) {
                    livroLista.addElement("nome: " + livro.getTitulo() + " - autor: " + livro.getAutor() +" - categoria: " + livro.getGenero() + " - ano: " + livro.getAno() + " - ISBN: " + livro.getISBN());
                }
            }
        }
    }
}