package views;

import models.Jugador;

import javax.swing.*;
import java.util.ArrayList;

public class ConfiguracionMultijugador {

    public static void iniciar(){

        try{

            int cantidad =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Cantidad de jugadores (2-7)",
                                    "Multijugador",
                                    JOptionPane.QUESTION_MESSAGE));

            if(cantidad < 2 || cantidad > 7){

                JOptionPane.showMessageDialog(
                        null,
                        "Solo entre 2 y 7 jugadores");

                return;
            }

            String[] dificultades = {
                    "FACIL",
                    "MEDIA",
                    "DIFICIL"
            };

            String dificultad =
                    (String) JOptionPane.showInputDialog(
                            null,
                            "Selecciona dificultad",
                            "Dificultad",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            dificultades,
                            dificultades[0]);

            if(dificultad == null){

                return;
            }

            ArrayList<Jugador> jugadores =
                    new ArrayList<>();

            for(int i=1; i<=cantidad; i++){

                String nombre =
                        JOptionPane.showInputDialog(
                                null,
                                "Nombre del jugador " + i);

                if(nombre == null ||
                        nombre.trim().isEmpty()){

                    nombre = "Jugador" + i;
                }

                Jugador j =
                        new Jugador();

                j.setNombre(nombre);

                j.setVidas(3);

                j.setPuntuacion(0);

                j.setAciertos(0);

                j.setErrores(0);

                jugadores.add(j);
            }

            new VentanaJuego(
                    jugadores,
                    dificultad);

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    null,
                    "Dato inválido");
        }
    }
}