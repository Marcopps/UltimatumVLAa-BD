package views;

import controllers.JugadorController;
import models.Jugador;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField nombreField;

    private JButton entrar;

    public LoginView() {

        setTitle("ULTIMATUM GAME");

        setSize(800,550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(5,5,20));

        inicializarComponentes();

        setVisible(true);
    }

    private void inicializarComponentes(){

        JLabel titulo =
                new JLabel("ULTIMATUM");

        titulo.setBounds(230,60,400,70);

        titulo.setFont(
                new Font("Arial", Font.BOLD,52));

        titulo.setForeground(Color.CYAN);

        add(titulo);

        JLabel subtitulo =
                new JLabel(
                        "Juego de preguntas y supervivencia");

        subtitulo.setBounds(220,130,400,30);

        subtitulo.setForeground(Color.LIGHT_GRAY);

        subtitulo.setFont(
                new Font("Arial", Font.PLAIN,20));

        add(subtitulo);

        JPanel panelLogin =
                new JPanel();

        panelLogin.setLayout(null);

        panelLogin.setBounds(170,200,450,220);

        panelLogin.setBackground(
                new Color(15,15,40));

        panelLogin.setBorder(
                BorderFactory.createLineBorder(
                        Color.CYAN,
                        2));

        add(panelLogin);

        JLabel nombreLabel =
                new JLabel("Nombre del jugador");

        nombreLabel.setBounds(110,25,250,30);

        nombreLabel.setForeground(Color.WHITE);

        nombreLabel.setFont(
                new Font("Arial", Font.BOLD,22));

        panelLogin.add(nombreLabel);

        nombreField =
                new JTextField();

        nombreField.setBounds(70,80,300,50);

        nombreField.setFont(
                new Font("Arial", Font.BOLD,24));

        nombreField.setHorizontalAlignment(
                JTextField.CENTER);

        nombreField.setBackground(
                new Color(20,20,50));

        nombreField.setForeground(Color.CYAN);

        nombreField.setCaretColor(Color.WHITE);

        nombreField.setBorder(
                BorderFactory.createLineBorder(
                        Color.CYAN,
                        3));

        panelLogin.add(nombreField);

        entrar =
                new JButton("ENTRAR");

        entrar.setBounds(125,155,180,45);

        entrar.setBackground(Color.BLACK);

        entrar.setForeground(Color.GREEN);

        entrar.setFocusPainted(false);

        entrar.setFont(
                new Font("Arial", Font.BOLD,22));

        panelLogin.add(entrar);

        entrar.addActionListener(e -> iniciarSesion());

        JLabel footer =
                new JLabel(
                        "ULTIMATUM GAME © 2026");

        footer.setBounds(285,470,300,30);

        footer.setForeground(Color.GRAY);

        footer.setFont(
                new Font("Arial", Font.PLAIN,16));

        add(footer);
    }

    private void iniciarSesion(){

        String nombreJugador =
                nombreField.getText().trim();

        if(nombreJugador.isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "⚠ Escribe un nombre");

            return;
        }

        JugadorController jc =
                new JugadorController();

        Jugador jugador =
                jc.loginJugador(nombreJugador);

        JOptionPane.showMessageDialog(
                this,
                "✅ Bienvenido " +
                jugador.getNombre());

        new MenuPrincipal(jugador);

        dispose();
    }

    public static void main(String[] args) {

        new LoginView();
    }
}