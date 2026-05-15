package views;

import controllers.JugadorController;
import models.Jugador;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    JTextField nombreField;
    JButton entrar;

    public LoginView() {

        setTitle("LOGIN");

        setSize(500, 350);

        setLayout(null);

        setLocationRelativeTo(null);

        getContentPane().setBackground(
                new Color(15,15,40));

        JLabel titulo =
                new JLabel("ULTIMATUM");

        titulo.setBounds(130,40,300,50);

        titulo.setFont(
                new Font("Arial", Font.BOLD, 34));

        titulo.setForeground(Color.CYAN);

        add(titulo);

        JLabel nombre =
                new JLabel("Nombre:");

        nombre.setBounds(70,130,100,30);

        nombre.setForeground(Color.WHITE);

        nombre.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(nombre);

        nombreField =
                new JTextField();

        nombreField.setBounds(170,130,200,35);

        add(nombreField);

        entrar =
                new JButton("ENTRAR");

        entrar.setBounds(150,220,180,50);

        entrar.setBackground(Color.BLACK);

        entrar.setForeground(Color.GREEN);

        entrar.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(entrar);

        entrar.addActionListener(e -> {

            String nombreJugador =
                    nombreField.getText();

            if(nombreJugador.isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "Escribe un nombre");

                return;
            }

            JugadorController jc =
                    new JugadorController();

            Jugador jugador =
                    jc.loginJugador(nombreJugador);

            new MenuPrincipal(jugador);

            dispose();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {

        new LoginView();
    }
}