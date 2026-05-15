package controllers;

import database.ConexionBD;
import models.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JugadorController {

    public Jugador loginJugador(String nombre) {

        Jugador jugador = null;

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT * FROM jugadores WHERE nombre = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, nombre);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                jugador = new Jugador();

                jugador.setId(rs.getInt("id"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setVidas(rs.getInt("vidas"));
                jugador.setAciertos(rs.getInt("aciertos"));
                jugador.setErrores(rs.getInt("errores"));
                jugador.setPuntuacion(rs.getInt("puntuacion"));

            } else {

                String insert =
                        "INSERT INTO jugadores(nombre) VALUES(?)";

                PreparedStatement ps2 =
                        con.prepareStatement(insert);

                ps2.setString(1, nombre);

                ps2.executeUpdate();

                jugador = loginJugador(nombre);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return jugador;
    }

    public void actualizarJugador(Jugador j) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "UPDATE jugadores " +
                    "SET vidas=?, aciertos=?, errores=?, puntuacion=? " +
                    "WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, j.getVidas());
            ps.setInt(2, j.getAciertos());
            ps.setInt(3, j.getErrores());
            ps.setInt(4, j.getPuntuacion());
            ps.setInt(5, j.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}