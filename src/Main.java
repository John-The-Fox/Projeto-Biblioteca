//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco_de_dados_Livros baseDeDados;
        baseDeDados = new Banco_de_dados_Livros();
        new Pesquisa_Tela(baseDeDados).setVisible(true);

    }
}