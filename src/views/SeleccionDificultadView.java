package views;

import models.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeleccionDificultadView extends JFrame {

    private Jugador jugador;

    public SeleccionDificultadView(
            Jugador jugador){

        this.jugador = jugador;

        setTitle("Seleccionar Dificultad");

        setSize(700,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(10,10,25));

        JLabel titulo =
                new JLabel(
                        "SELECCIONA DIFICULTAD");

        titulo.setBounds(
                110,
                60,
                500,
                50);

        titulo.setForeground(
                Color.CYAN);

        titulo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        34));

        add(titulo);

        JButton facil =
                crearBoton(
                        "FACIL",
                        180,
                        Color.GREEN);

        JButton media =
                crearBoton(
                        "MEDIA",
                        280,
                        Color.ORANGE);

        JButton dificil =
                crearBoton(
                        "DIFICIL",
                        380,
                        Color.RED);

        add(facil);
        add(media);
        add(dificil);

        facil.addActionListener(e -> {

            iniciarJuego("FACIL");
        });

        media.addActionListener(e -> {

            iniciarJuego("MEDIA");
        });

        dificil.addActionListener(e -> {

            iniciarJuego("DIFICIL");
        });

        setVisible(true);
    }

    private void iniciarJuego(
            String dificultad){

        ArrayList<Jugador> lista =
                new ArrayList<>();

        jugador.setVidas(3);

        lista.add(jugador);

        new VentanaJuego(
                lista,
                dificultad);

        dispose();
    }

    private JButton crearBoton(
            String texto,
            int y,
            Color color){

        JButton btn =
                new JButton(texto);

        btn.setBounds(
                220,
                y,
                250,
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