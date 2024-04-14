import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editar_Tela  extends JFrame implements ActionListener {
    private JLabel nameLabel, autorLabel, anoLabel, generoLabel, ISBNLabel;
    private JTextField nameField, autorField, anoField, generoField, ISBNField;
    private JButton saveButton, cancelButton, delButton;

    private Banco_de_dados_Livros baseDeDados;

    public Editar_Tela(String nome, String autor, int ano, String genero, String ISBN) {
        super("Dados do livro");

        baseDeDados = new Banco_de_dados_Livros();

        nameLabel = new JLabel("Nome:");
        autorLabel = new JLabel("Autor:");
        anoLabel = new JLabel("Ano:");
        generoLabel = new JLabel("categoria:");
        ISBNLabel = new JLabel("ISBN:");

        nameField = new JTextField(20);
        autorField = new JTextField(20);
        anoField = new JTextField(20);
        generoField = new JTextField(20);
        ISBNField = new JTextField(20);

        saveButton = new JButton("Salvar");
        saveButton.setActionCommand("salvar");
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("cancelar");
        cancelButton.addActionListener(this);

        delButton = new JButton("EXCLUIR");
        delButton.setActionCommand("excluir");
        delButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // 6 rows, 2 columns

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(autorLabel);
        panel.add(autorField);
        panel.add(anoLabel);
        panel.add(anoField);
        panel.add(generoLabel);
        panel.add(generoField);
        panel.add(ISBNLabel);
        panel.add(ISBNField);
        panel.add(cancelButton);
        panel.add(saveButton);

        add(panel);

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        nameField.setText(nome);
        autorField.setText(autor);
        anoField.setText(String.valueOf(ano));
        generoField.setText(genero);
        ISBNField.setText(ISBN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("salvar")) {
            String ISBN = ISBNField.getText();
            String nome = nameField.getText();
            String autor = autorField.getText();
            int ano = Integer.parseInt(anoField.getText());
            String genero = generoField.getText();
            Livro livroExistente = baseDeDados.obterLivroPorISBN(ISBN);
            if (livroExistente != null) {
                livroExistente.setNome(nome);
                livroExistente.setAutor(autor);
                livroExistente.setAno(ano);
                livroExistente.setGenero(genero);
                System.out.println("Livro atualizado com sucesso!");
                dispose();
            } else {
                Livro novoLivro = new Livro(nome, autor, ano, genero, ISBN);
                baseDeDados.adicionarLivro(novoLivro);
                Livro livroCadastrado = baseDeDados.obterLivroPorTitulo(nome);
                System.out.println("Livro Cadastrado: " + livroCadastrado.getTitulo());
            }

            nameField.setText("");
            autorField.setText("");
            anoField.setText("");
            generoField.setText("");
            ISBNField.setText("");

        } else if (e.getActionCommand().equals("cancelar")) {
            dispose();
        }
    }
}
