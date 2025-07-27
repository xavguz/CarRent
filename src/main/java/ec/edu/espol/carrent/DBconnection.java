/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

/**
 *
 * @author Nueva
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection instance;  
    private Connection connection;
    
    private final String URL = "jdbc:mysql://bzvflrgdea9swtwgzv3k-mysql.services.clever-cloud.com:3306/bzvflrgdea9swtwgzv3k";
    private final String USER = "ujmg66g1k1lrer5c";
    private final String PASSWORD = "z5aOI2qMLnCvDj6GU7Lh";

    private DBconnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la BD");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver no encontrado: " + e.getMessage());
        }
    }

    public static DBconnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DBconnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
