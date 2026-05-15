package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ultimatum_game";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexion exitosa");

            return con;

        } catch (Exception e) {

            System.out.println("Error: " + e);

            return null;
        }
    }
}