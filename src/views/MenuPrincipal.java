package views;

import models.Jugador;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private Jugador jugador;

    public MenuPrincipal(Jugador jugador){

        this.jugador = jugador;

        setTitle("ULTIMATUM");

        setSize(900,700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(5,5,20));

        inicializar();

        setVisible(true);
    }

    private void inicializar(){

        JLabel titulo =
                new JLabel("ULTIMATUM");

        titulo.setBounds(240,50,500,70);

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        54));

        titulo.setForeground(Color.CYAN);

        add(titulo);

        JLabel jugadorLabel =
                new JLabel(
                        "Jugador: " +
                                jugador.getNombre());

        jugadorLabel.setBounds(
                30,
                20,
                300,
                40);

        jugadorLabel.setForeground(
                Color.WHITE);

        jugadorLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20));

        add(jugadorLabel);

        JButton jugar =
                crearBoton(
                        "JUGAR",
                        180,
                        Color.GREEN);

        JButton multi =
                crearBoton(
                        "MULTIJUGADOR",
                        280,
                        Color.MAGENTA);

        JButton agregar =
                crearBoton(
                        "AGREGAR PREGUNTA",
                        380,
                        Color.ORANGE);

        JButton ranking =
                crearBoton(
                        "CLASIFICACION",
                        480,
                        Color.CYAN);

        JButton salir =
                crearBoton(
                        "SALIR",
                        580,
                        Color.RED);

        add(jugar);
        add(multi);
        add(agregar);
        add(ranking);
        add(salir);

        jugar.addActionListener(e -> {

            new SeleccionDificultadView(
                    jugador);

            dispose();
        });

        multi.addActionListener(e -> {

            ConfiguracionMultijugador
                    .iniciar();

            dispose();
        });

        agregar.addActionListener(e -> {

            new AgregarPreguntaView(
                    jugador);

            dispose();
        });

        ranking.addActionListener(e -> {

            new RankingView(jugador);

            dispose();
        });

        salir.addActionListener(e -> {

            System.exit(0);
        });
    }

    private JButton crearBoton(
            String texto,
            int y,
            Color color){

        JButton btn =
                new JButton(texto);

        btn.setBounds(
                250,
                y,
                350,
                60);

        btn.setBackground(Color.BLACK);

        btn.setForeground(color);

        btn.setFocusPainted(false);

        btn.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        return btn;
    }
}