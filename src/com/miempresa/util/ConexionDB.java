package com.miempresa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión a la base de datos.
 */
public class ConexionDB {
    // URL de conexión, nombre de usuario y contraseña de la base de datos.
    private static final String URL = "jdbc:mysql://localhost:3306/minimizingsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Método para obtener la conexión a la base de datos.
     * @return Objeto Connection.
     * @throws SQLException si ocurre un error al conectarse.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
