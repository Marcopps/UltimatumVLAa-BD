package views;

import database.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RankingView extends JFrame {

    JTable tabla;

    public RankingView() {

        setTitle("Ranking");

        setSize(700, 500);

        setLocationRelativeTo(null);

        String[] columnas = {
                "Jugador",
                "Aciertos",
                "Errores",
                "Puntuacion"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(
                        columnas,
                        0);

        tabla = new JTable(modelo);

        try {

            Connection con =
                    ConexionBD.conectar();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM jugadores");

            while (rs.next()) {

                modelo.addRow(new Object[]{

                        rs.getString("nombre"),
                        rs.getInt("aciertos"),
                        rs.getInt("errores"),
                        rs.getInt("puntuacion")
                });
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        add(new JScrollPane(tabla));

        setVisible(true);
    }
}