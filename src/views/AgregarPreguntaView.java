package views;

import controllers.PreguntaController;
import models.Jugador;
import models.Pregunta;

import javax.swing.*;
import java.awt.*;

public class AgregarPreguntaView extends JFrame {

    JTextField pregunta;
    JTextField correcta;

    JComboBox<String> dificultad;

    JButton guardar;

    private Jugador jugador;

    public AgregarPreguntaView(Jugador jugador){

        this.jugador = jugador;

        setTitle("Agregar Pregunta");

        setSize(700,550);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(
                new Color(10,10,25));

        JLabel titulo =
                new JLabel("NUEVA PREGUNTA");

        titulo.setBounds(170,30,400,50);

        titulo.setFont(
                new Font("Arial", Font.BOLD,34));

        titulo.setForeground(Color.CYAN);

        add(titulo);

        pregunta =
                crearCampo(
                        "Pregunta:",
                        120);

        correcta =
                crearCampo(
                        "Respuesta correcta:",
                        250);

        JLabel diff =
                new JLabel("Dificultad:");

        diff.setBounds(80,360,200,35);

        diff.setForeground(Color.WHITE);

        diff.setFont(
                new Font("Arial", Font.BOLD,20));

        add(diff);

        dificultad =
                new JComboBox<>();

        dificultad.addItem("FACIL");
        dificultad.addItem("MEDIA");
        dificultad.addItem("DIFICIL");

        dificultad.setBounds(80,400,250,40);

        dificultad.setFont(
                new Font("Arial", Font.BOLD,18));

        add(dificultad);

        guardar =
                new JButton("GUARDAR");

        guardar.setBounds(390,390,180,50);

        guardar.setBackground(Color.BLACK);

        guardar.setForeground(Color.GREEN);

        guardar.setFont(
                new Font("Arial", Font.BOLD,20));

        add(guardar);

        JButton regresar =
                new JButton("REGRESAR");

        regresar.setBounds(390,450,180,40);

        regresar.setBackground(Color.BLACK);

        regresar.setForeground(Color.CYAN);

        regresar.setFont(
                new Font("Arial", Font.BOLD,18));

        add(regresar);

        guardar.addActionListener(e -> {

            guardarPregunta();
        });

        regresar.addActionListener(e -> {

            new MenuPrincipal(jugador);

            dispose();
        });

        setVisible(true);
    }

    private JTextField crearCampo(
            String texto,
            int y){

        JLabel label =
                new JLabel(texto);

        label.setBounds(80,y,250,35);

        label.setForeground(Color.WHITE);

        label.setFont(
                new Font("Arial", Font.BOLD,20));

        add(label);

        JTextField txt =
                new JTextField();

        txt.setBounds(80,y+45,500,40);

        txt.setFont(
                new Font("Arial", Font.PLAIN,20));

        add(txt);

        return txt;
    }

    private void guardarPregunta(){

        Pregunta p =
                new Pregunta();

        p.setPregunta(
                pregunta.getText());

        p.setCorrecta(
                correcta.getText());

        p.setOpcion1("");
        p.setOpcion2("");
        p.setOpcion3("");
        p.setOpcion4("");

        p.setDificultad(
                dificultad.getSelectedItem().toString());

        new PreguntaController()
                .guardarPregunta(p);

        JOptionPane.showMessageDialog(
                this,
                "✅ Pregunta guardada");

        pregunta.setText("");
        correcta.setText("");
    }
}