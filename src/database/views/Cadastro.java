package database.views;

import javax.swing.*;

public class Cadastro extends JFrame {
    private JPanel cadastroPanel;
    private JTextField txtNome;
    private JTextField txtRegiao;

    public Cadastro(String titulo){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cadastroPanel);
        this.pack();
    }
    public static void main(String[]args){
        Cadastro cadastro = new Cadastro("Pokedex");
        cadastro.setVisible(true);
    }
}
