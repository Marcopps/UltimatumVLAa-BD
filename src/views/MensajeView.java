package views;

import javax.swing.*;
import java.awt.*;

public class MensajeView extends JDialog {

    public MensajeView(
            JFrame parent,
            String titulo,
            String mensaje,
            Color color){

        super(parent, true);

        setSize(500,300);

        setLocationRelativeTo(parent);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(15,15,30));

        JLabel title =
                new JLabel(titulo);

        title.setHorizontalAlignment(
                SwingConstants.CENTER);

        title.setForeground(color);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        36));

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,20,20));

        JLabel msg =
                new JLabel(
                        "<html><center>" +
                                mensaje +
                                "</center></html>");

        msg.setHorizontalAlignment(
                SwingConstants.CENTER);

        msg.setForeground(Color.WHITE);

        msg.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        JButton cerrar =
                new JButton("CONTINUAR");

        cerrar.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20));

        cerrar.setBackground(Color.BLACK);

        cerrar.setForeground(color);

        cerrar.setFocusPainted(false);

        cerrar.addActionListener(e -> dispose());

        JPanel abajo =
                new JPanel();

        abajo.setBackground(
                new Color(15,15,30));

        abajo.add(cerrar);

        add(title, BorderLayout.NORTH);

        add(msg, BorderLayout.CENTER);

        add(abajo, BorderLayout.SOUTH);

        setVisible(true);
    }
}