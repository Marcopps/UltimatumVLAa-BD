package views;

import models.Jugador;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private Jugador jugador;

    JButton jugar;
    JButton ranking;
    JButton agregar;

    public MenuPrincipal(Jugador jugador) {

        this.jugador = jugador;

        setTitle("ULTIMATUM GAME");

        setSize(700, 500);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(15, 15, 40));

        JLabel titulo =
                new JLabel("ULTIMATUM");

        titulo.setBounds(220, 40, 400, 60);

        titulo.setFont(
                new Font("Arial", Font.BOLD, 40));

        titulo.setForeground(Color.CYAN);

        add(titulo);

        JLabel usuario =
                new JLabel(
                        "Jugador: " +
                        jugador.getNombre());

        usuario.setBounds(220,100,300,40);

        usuario.setForeground(Color.WHITE);

        usuario.setFont(
                new Font("Arial", Font.BOLD, 20));

        add(usuario);

        jugar = crearBoton(
                "JUGAR",
                200);

        ranking = crearBoton(
                "RANKING",
                280);

        agregar = crearBoton(
                "AGREGAR PREGUNTA",
                360);

        add(jugar);
        add(ranking);
        add(agregar);

        jugar.addActionListener(e -> {

            new VentanaJuego(jugador);

        });

        ranking.addActionListener(e -> {

            new RankingView();

        });

        agregar.addActionListener(e -> {

            new AgregarPreguntaView();

        });

        setVisible(true);
    }

    private JButton crearBoton(
            String texto,
            int y) {

        JButton btn =
                new JButton(texto);

        btn.setBounds(220, y, 250, 50);

        btn.setFont(
                new Font("Arial", Font.BOLD, 18));

        btn.setBackground(Color.BLACK);

        btn.setForeground(Color.GREEN);

        return btn;
    }
}