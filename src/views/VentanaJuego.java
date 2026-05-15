package views;

import controllers.JugadorController;
import controllers.PreguntaController;
import models.Jugador;
import models.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class VentanaJuego extends JFrame {

    private JLabel titulo;
    private JLabel jugadorLabel;
    private JLabel vidasLabel;
    private JLabel puntosLabel;
    private JLabel preguntaLabel;
    private JLabel instrucciones;

    private JTextField respuestaField;

    private JPanel panelPrincipal;

    private Jugador jugador;

    private ArrayList<Pregunta> preguntas;

    private Pregunta actual;

    private int errores = 0;

    public VentanaJuego(Jugador jugador) {

        this.jugador = jugador;

        setTitle("ULTIMATUM GAME");

        setSize(1000, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        panelPrincipal = new JPanel();

        panelPrincipal.setLayout(null);

        panelPrincipal.setBackground(
                new Color(8, 8, 25));

        panelPrincipal.setBounds(0,0,1000,650);

        add(panelPrincipal);

        crearComponentes();

        PreguntaController pc =
                new PreguntaController();

        preguntas =
                pc.obtenerPreguntas();

        if(preguntas.isEmpty()){

            JOptionPane.showMessageDialog(
                    this,
                    "No hay preguntas");

            dispose();

            return;
        }

        cargarPregunta();

        setVisible(true);
    }

    private void crearComponentes(){

        titulo =
                new JLabel("ULTIMATUM");

        titulo.setBounds(330,20,400,60);

        titulo.setFont(
                new Font("Arial", Font.BOLD, 42));

        titulo.setForeground(
                new Color(0,255,255));

        panelPrincipal.add(titulo);

        jugadorLabel =
                new JLabel(
                        "Jugador: " +
                        jugador.getNombre());

        jugadorLabel.setBounds(40,30,300,40);

        jugadorLabel.setFont(
                new Font("Arial", Font.BOLD, 20));

        jugadorLabel.setForeground(Color.WHITE);

        panelPrincipal.add(jugadorLabel);

        vidasLabel =
                new JLabel("VIDAS: ❤️❤️❤️");

        vidasLabel.setBounds(760,30,200,40);

        vidasLabel.setFont(
                new Font("Arial", Font.BOLD, 22));

        vidasLabel.setForeground(Color.RED);

        panelPrincipal.add(vidasLabel);

        puntosLabel =
                new JLabel(
                        "PUNTOS: " +
                        jugador.getPuntuacion());

        puntosLabel.setBounds(420,80,250,40);

        puntosLabel.setFont(
                new Font("Arial", Font.BOLD, 24));

        puntosLabel.setForeground(Color.GREEN);

        panelPrincipal.add(puntosLabel);

        preguntaLabel =
                new JLabel();

        preguntaLabel.setBounds(90,170,820,80);

        preguntaLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        preguntaLabel.setFont(
                new Font("Arial", Font.BOLD, 28));

        preguntaLabel.setForeground(Color.WHITE);

        panelPrincipal.add(preguntaLabel);

        instrucciones =
                new JLabel(
                        "<html>" +
                        "<center>" +
                        "ESCRIBE LA RESPUESTA EXACTA Y PRESIONA ENTER<br>" +
                        "TIENES 3 VIDAS" +
                        "</center>" +
                        "</html>");

        instrucciones.setBounds(250,260,500,60);

        instrucciones.setHorizontalAlignment(
                SwingConstants.CENTER);

        instrucciones.setFont(
                new Font("Arial", Font.PLAIN, 20));

        instrucciones.setForeground(Color.LIGHT_GRAY);

        panelPrincipal.add(instrucciones);

        respuestaField =
                new JTextField();

        respuestaField.setBounds(
                250,
                370,
                500,
                60);

        respuestaField.setFont(
                new Font("Arial", Font.BOLD, 24));

        respuestaField.setHorizontalAlignment(
                JTextField.CENTER);

        respuestaField.setBackground(
                new Color(20,20,40));

        respuestaField.setForeground(Color.CYAN);

        respuestaField.setCaretColor(Color.WHITE);

        respuestaField.setBorder(
                BorderFactory.createLineBorder(
                        Color.CYAN,
                        3));

        panelPrincipal.add(respuestaField);

        respuestaField.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER){

                    verificarRespuesta();
                }
            }
        });

        JLabel footer =
                new JLabel(
                        "ULTIMATUM GAME ©");

        footer.setBounds(390,560,300,30);

        footer.setForeground(Color.GRAY);

        footer.setFont(
                new Font("Arial", Font.BOLD, 16));

        panelPrincipal.add(footer);
    }

    private void cargarPregunta(){

        Random r =
                new Random();

        actual =
                preguntas.get(
                        r.nextInt(
                                preguntas.size()));

        preguntaLabel.setText(
                "<html><center>" +
                actual.getPregunta() +
                "</center></html>");

        respuestaField.setText("");

        respuestaField.requestFocus();
    }

    private void verificarRespuesta(){

        String respuestaUsuario =
                respuestaField.getText().trim();

        String correcta =
                actual.getCorrecta().trim();

        if(respuestaUsuario.equalsIgnoreCase(correcta)){

            jugador.setAciertos(
                    jugador.getAciertos() + 1);

            jugador.setPuntuacion(
                    jugador.getPuntuacion() + 10);

            puntosLabel.setText(
                    "PUNTOS: " +
                    jugador.getPuntuacion());

            JOptionPane.showMessageDialog(
                    this,
                    "✅ RESPUESTA CORRECTA");

        } else {

            errores++;

            jugador.setErrores(
                    jugador.getErrores() + 1);

            actualizarVidas();

            JOptionPane.showMessageDialog(
                    this,
                    "❌ INCORRECTO\n" +
                    "Respuesta correcta: " +
                    correcta);
        }

        if(errores >= 3){

            jugador.setVidas(0);

            new JugadorController()
                    .actualizarJugador(jugador);

            JOptionPane.showMessageDialog(
                    this,
                    "☠ GAME OVER\n" +
                    "PUNTOS FINALES: " +
                    jugador.getPuntuacion());

            dispose();

        } else {

            jugador.setVidas(
                    3 - errores);

            new JugadorController()
                    .actualizarJugador(jugador);

            cargarPregunta();
        }
    }

    private void actualizarVidas(){

        if(errores == 0){

            vidasLabel.setText(
                    "VIDAS: ❤️❤️❤️");

        } else if(errores == 1){

            vidasLabel.setText(
                    "VIDAS: ❤️❤️");

        } else if(errores == 2){

            vidasLabel.setText(
                    "VIDAS: ❤️");

        } else {

            vidasLabel.setText(
                    "VIDAS: X");
        }
    }
}