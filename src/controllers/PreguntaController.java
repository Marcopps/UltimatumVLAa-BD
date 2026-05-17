package controllers;

import database.ConexionBD;
import models.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PreguntaController {

    public void guardarPregunta(Pregunta p) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "INSERT INTO preguntas " +
                    "(pregunta, opcion1, opcion2, opcion3, opcion4, respuesta_correcta, dificultad, creada_por) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, p.getPregunta());
            ps.setString(2, p.getOpcion1());
            ps.setString(3, p.getOpcion2());
            ps.setString(4, p.getOpcion3());
            ps.setString(5, p.getOpcion4());
            ps.setString(6, p.getCorrecta());
            ps.setString(7, p.getDificultad());
            ps.setString(8, "Jugador");

            ps.executeUpdate();

            System.out.println(
                    "Pregunta guardada");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public ArrayList<Pregunta> obtenerPreguntas() {

        ArrayList<Pregunta> lista =
                new ArrayList<>();

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT * FROM preguntas";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Pregunta p =
                        new Pregunta();

                p.setPregunta(
                        rs.getString("pregunta"));

                p.setOpcion1(
                        rs.getString("opcion1"));

                p.setOpcion2(
                        rs.getString("opcion2"));

                p.setOpcion3(
                        rs.getString("opcion3"));

                p.setOpcion4(
                        rs.getString("opcion4"));

                p.setCorrecta(
                        rs.getString("respuesta_correcta"));

                p.setDificultad(
                        rs.getString("dificultad"));

                lista.add(p);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return lista;
    }

    public ArrayList<Pregunta> obtenerPreguntasPorDificultad(
            String dificultad) {

        ArrayList<Pregunta> lista =
                new ArrayList<>();

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT * FROM preguntas WHERE dificultad = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, dificultad);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                Pregunta p =
                        new Pregunta();

                p.setPregunta(
                        rs.getString("pregunta"));

                p.setCorrecta(
                        rs.getString("respuesta_correcta"));

                p.setDificultad(
                        rs.getString("dificultad"));

                p.setOpcion1(
                        rs.getString("opcion1"));

                p.setOpcion2(
                        rs.getString("opcion2"));

                p.setOpcion3(
                        rs.getString("opcion3"));

                p.setOpcion4(
                        rs.getString("opcion4"));

                lista.add(p);
            }

        } catch(Exception e){

            System.out.println(e);
        }

        return lista;
    }
}