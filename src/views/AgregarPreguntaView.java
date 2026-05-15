package views;

import controllers.PreguntaController;
import models.Pregunta;

import javax.swing.*;

public class AgregarPreguntaView extends JFrame {

    JTextField pregunta;
    JTextField op1;
    JTextField op2;
    JTextField op3;
    JTextField op4;
    JTextField correcta;

    JButton guardar;

    public AgregarPreguntaView() {

        setTitle("Agregar Pregunta");

        setSize(500, 500);

        setLayout(null);

        setLocationRelativeTo(null);

        pregunta = crearCampo(30);
        op1 = crearCampo(80);
        op2 = crearCampo(130);
        op3 = crearCampo(180);
        op4 = crearCampo(230);
        correcta = crearCampo(280);

        guardar =
                new JButton("Guardar");

        guardar.setBounds(150, 350, 180, 50);

        add(guardar);

        guardar.addActionListener(e -> {

            Pregunta p =
                    new Pregunta();

            p.setPregunta(pregunta.getText());
            p.setOpcion1(op1.getText());
            p.setOpcion2(op2.getText());
            p.setOpcion3(op3.getText());
            p.setOpcion4(op4.getText());
            p.setCorrecta(correcta.getText());

            p.setDificultad("MEDIA");

            new PreguntaController()
                    .guardarPregunta(p);

            JOptionPane.showMessageDialog(
                    this,
                    "Pregunta guardada");
        });

        setVisible(true);
    }

    private JTextField crearCampo(int y) {

        JTextField txt =
                new JTextField();

        txt.setBounds(50, y, 350, 35);

        add(txt);

        return txt;
    }
}