/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author evilnapsis
 */
public class Db {

    public static Connection connection;

    public static Connection connect() {
//    String url = "jdbc:mysql://192.168.250.22/gestionnovus";
//    String user = "prueba";
//    String pass = "Novus2019*";
        String url = "jdbc:mysql://localhost/chatinterno";
        String user = "root";
        String pass = "";

        //System.out.println("Conectando..");
        //JOptionPane.showMessageDialog(null, "conexion exitosa");
        try {
            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
