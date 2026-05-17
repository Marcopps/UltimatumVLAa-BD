package views;

import database.ConexionBD;
import models.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RankingView extends JFrame {

    JTable tabla;

    private Jugador jugador;

    public RankingView(Jugador jugador){

        this.jugador = jugador;

        setTitle("CLASIFICACION");

        setSize(900,600);

        setLocationRelativeTo(null);

        getContentPane().setBackground(
                new Color(10,10,25));

        setLayout(new BorderLayout());

        JLabel titulo =
                new JLabel(
                        "🏆 CLASIFICACION GENERAL");

        titulo.setHorizontalAlignment(
                SwingConstants.CENTER);

        titulo.setFont(
                new Font("Arial", Font.BOLD,32));

        titulo.setForeground(Color.CYAN);

        add(titulo, BorderLayout.NORTH);

        String columnas[] = {

                "Jugador",
                "Aciertos",
                "Errores",
                "Puntuacion"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(
                        columnas,
                        0);

        tabla =
                new JTable(modelo);

        tabla.setRowHeight(35);

        tabla.setFont(
                new Font("Arial", Font.PLAIN,18));

        tabla.getTableHeader().setFont(
                new Font("Arial", Font.BOLD,20));

        tabla.getTableHeader().setBackground(
                Color.BLACK);

        tabla.getTableHeader().setForeground(
                Color.CYAN);

        tabla.setBackground(
                new Color(25,25,45));

        tabla.setForeground(Color.WHITE);

        try{

            Connection con =
                    ConexionBD.conectar();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM jugadores ORDER BY puntuacion DESC");

            while(rs.next()){

                modelo.addRow(new Object[]{

                        rs.getString("nombre"),
                        rs.getInt("aciertos"),
                        rs.getInt("errores"),
                        rs.getInt("puntuacion")
                });
            }

        } catch(Exception e){

            System.out.println(e);
        }

        JScrollPane scroll =
                new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);

        JButton regresar =
                new JButton("REGRESAR");

        regresar.setFont(
                new Font("Arial", Font.BOLD,18));

        regresar.setBackground(Color.BLACK);

        regresar.setForeground(Color.CYAN);

        add(regresar, BorderLayout.SOUTH);

        regresar.addActionListener(e -> {

            new MenuPrincipal(jugador);

            dispose();
        });

        setVisible(true);
    }
}