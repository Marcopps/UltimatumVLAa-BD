package views;

import controllers.JugadorController;
import controllers.PreguntaController;
import models.Jugador;
import models.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class VentanaJuego extends JFrame {

    private ArrayList<Jugador> jugadores;

    private ArrayList<Pregunta> preguntas;

    private int turnoActual = 0;

    private Pregunta preguntaActual;

    private JLabel jugadorLabel;
    private JLabel vidasLabel;
    private JLabel puntosLabel;
    private JLabel dificultadLabel;
    private JLabel timerLabel;
    private JLabel preguntaLabel;
    private JLabel tiempoPartidaLabel;

    private JTextField respuestaField;

    private JProgressBar barraTiempo;

    private Timer timer;

    private Timer timerPartida;

    private int tiempo = 10;

    private int tiempoPartida = 600;

    private boolean multijugador;

    private String dificultad;

    public VentanaJuego(
            ArrayList<Jugador> jugadores,
            String dificultad){

        this.jugadores = jugadores;

        this.dificultad = dificultad;

        this.multijugador =
                jugadores.size() > 1;

        setTitle("ULTIMATUM");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(10,10,25));

        PreguntaController pc =
                new PreguntaController();

        preguntas =
                pc.obtenerPreguntasPorDificultad(
                        dificultad);

        crearInterfaz();

        iniciarTimerPartida();

        cargarPregunta();

        setVisible(true);
    }

    private void crearInterfaz(){

        JPanel top =
                new JPanel(
                        new GridLayout(1,6));

        top.setBackground(
                new Color(5,5,20));

        top.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20));

        jugadorLabel = crearLabel("");
        vidasLabel = crearLabel("");
        puntosLabel = crearLabel("");
        dificultadLabel = crearLabel("");
        timerLabel = crearLabel("10");
        tiempoPartidaLabel =
                crearLabel("10:00");

        top.add(jugadorLabel);
        top.add(vidasLabel);
        top.add(puntosLabel);
        top.add(dificultadLabel);
        top.add(timerLabel);
        top.add(tiempoPartidaLabel);

        add(top, BorderLayout.NORTH);

        JPanel center =
                new JPanel();

        center.setLayout(
                new BorderLayout());

        center.setBackground(
                new Color(10,10,25));

        JPanel contenido =
                new JPanel();

        contenido.setLayout(
                new GridLayout(4,1,20,20));

        contenido.setBackground(
                new Color(10,10,25));

        contenido.setBorder(
                BorderFactory.createEmptyBorder(
                        100,
                        200,
                        100,
                        200));

        preguntaLabel =
                new JLabel();

        preguntaLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        preguntaLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        42));

        preguntaLabel.setForeground(
                Color.WHITE);

        barraTiempo =
                new JProgressBar(0,10);

        barraTiempo.setValue(10);

        barraTiempo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22));

        barraTiempo.setStringPainted(true);

        respuestaField =
                new JTextField();

        respuestaField.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        36));

        respuestaField.setHorizontalAlignment(
                JTextField.CENTER);

        JButton responder =
                new JButton("RESPONDER");

        responder.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32));

        responder.setBackground(Color.BLACK);

        responder.setForeground(Color.CYAN);

        responder.setFocusPainted(false);

        responder.addActionListener(
                this::verificarRespuesta);

        contenido.add(preguntaLabel);

        contenido.add(barraTiempo);

        contenido.add(respuestaField);

        contenido.add(responder);

        center.add(
                contenido,
                BorderLayout.CENTER);

        add(center, BorderLayout.CENTER);
    }

    private JLabel crearLabel(String txt){

        JLabel l =
                new JLabel(txt);

        l.setHorizontalAlignment(
                SwingConstants.CENTER);

        l.setForeground(Color.CYAN);

        l.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20));

        return l;
    }

    private void cargarPregunta(){

        if(multijugador &&
                jugadores.size() == 1){

            terminarJuego();

            return;
        }

        Jugador jugador =
                jugadores.get(turnoActual);

        jugadorLabel.setText(
                "Jugador: " +
                        jugador.getNombre());

        vidasLabel.setText(
                "Vidas: " +
                        jugador.getVidas());

        puntosLabel.setText(
                "Puntos: " +
                        jugador.getPuntuacion());

        dificultadLabel.setText(
                multijugador
                        ? "Turno " +
                        (turnoActual+1)
                        : dificultad);

        Random r =
                new Random();

        preguntaActual =
                preguntas.get(
                        r.nextInt(
                                preguntas.size()));

        preguntaLabel.setText(
                "<html><center>" +
                        preguntaActual.getPregunta() +
                        "</center></html>");

        respuestaField.setText("");

        iniciarTimer();
    }

    private void iniciarTimer(){

        tiempo = 10;

        barraTiempo.setValue(10);

        timerLabel.setText("10");

        if(timer != null){

            timer.stop();
        }

        timer =
                new Timer(1000, e -> {

                    tiempo--;

                    timerLabel.setText(
                            String.valueOf(tiempo));

                    barraTiempo.setValue(tiempo);

                    if(tiempo <= 0){

                        timer.stop();

                        perderVida();
                    }
                });

        timer.start();
    }

    private void iniciarTimerPartida(){

        if(!multijugador){

            return;
        }

        timerPartida =
                new Timer(1000, e -> {

                    tiempoPartida--;

                    int minutos =
                            tiempoPartida / 60;

                    int segundos =
                            tiempoPartida % 60;

                    tiempoPartidaLabel.setText(
                            String.format(
                                    "%02d:%02d",
                                    minutos,
                                    segundos));

                    if(tiempoPartida <= 0){

                        timerPartida.stop();

                        finalizarPorTiempo();
                    }
                });

        timerPartida.start();
    }

    private void verificarRespuesta(
            ActionEvent e){

        timer.stop();

        Jugador jugador =
                jugadores.get(turnoActual);

        String respuesta =
                respuestaField.getText().trim();

        if(respuesta.equalsIgnoreCase(
                preguntaActual.getCorrecta())){

            jugador.setPuntuacion(
                    jugador.getPuntuacion()+10);

            jugador.setAciertos(
                    jugador.getAciertos()+1);

            new MensajeView(
                    this,
                    "CORRECTO",
                    "Respuesta correcta 🔥",
                    Color.GREEN);

        } else {

            perderVida();

            return;
        }

        siguienteTurno();
    }

    private void perderVida(){

        Jugador jugador =
                jugadores.get(turnoActual);

        jugador.setErrores(
                jugador.getErrores()+1);

        jugador.setVidas(
                jugador.getVidas()-1);

        new MensajeView(
                this,
                "INCORRECTO",
                "Perdiste una vida 💀",
                Color.RED);

        if(jugador.getVidas() <= 0){

            new MensajeView(
                    this,
                    "ELIMINADO",
                    jugador.getNombre() +
                            " ha sido eliminado",
                    Color.ORANGE);

            if(multijugador){

                jugadores.remove(turnoActual);

                if(turnoActual >= jugadores.size()){

                    turnoActual = 0;
                }

            } else {

                terminarJuegoIndividual();

                return;
            }
        }

        siguienteTurno();
    }

    private void siguienteTurno(){

        turnoActual++;

        if(turnoActual >= jugadores.size()){

            turnoActual = 0;
        }

        cargarPregunta();
    }

    private void finalizarPorTiempo(){

        if(timer != null){

            timer.stop();
        }

        Jugador ganador =
                jugadores.stream()

                        .max(
                                Comparator
                                        .comparingInt(Jugador::getVidas)
                                        .thenComparingInt(
                                                Jugador::getAciertos)
                        )

                        .orElse(jugadores.get(0));

        new JugadorController()
                .actualizarJugador(ganador);

        new MensajeView(
                this,
                "⏰ TIEMPO TERMINADO",
                "🏆 Ganador: " +
                        ganador.getNombre() +
                        "<br>❤️ Vidas: " +
                        ganador.getVidas() +
                        "<br>✅ Aciertos: " +
                        ganador.getAciertos(),
                Color.YELLOW);

        new MenuPrincipal(ganador);

        dispose();
    }

    private void terminarJuegoIndividual(){

        if(timerPartida != null){

            timerPartida.stop();
        }

        Jugador jugador =
                jugadores.get(0);

        new JugadorController()
                .actualizarJugador(jugador);

        new MensajeView(
                this,
                "GAME OVER",
                "Puntos: " +
                        jugador.getPuntuacion(),
                Color.RED);

        new MenuPrincipal(jugador);

        dispose();
    }

    private void terminarJuego(){

        if(timerPartida != null){

            timerPartida.stop();
        }

        Jugador ganador =
                jugadores.get(0);

        new JugadorController()
                .actualizarJugador(
                        ganador);

        new MensajeView(
                this,
                "🏆 GANADOR 🏆",
                ganador.getNombre() +
                        "<br>Puntos: " +
                        ganador.getPuntuacion(),
                Color.YELLOW);

        new MenuPrincipal(ganador);

        dispose();
    }
}