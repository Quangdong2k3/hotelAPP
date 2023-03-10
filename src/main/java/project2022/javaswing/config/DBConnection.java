/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2022.javaswing.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ching
 */
public class DBConnection {
    private static Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    
    
    public static Connection getConnection () {
        try {
            conn = DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
