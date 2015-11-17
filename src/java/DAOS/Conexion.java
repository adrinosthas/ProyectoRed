/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import properties.Property;

/**
 *
 * @author Adri
 */
public class Conexion {
     public static Connection cnx() throws ClassNotFoundException, SQLException {
        Properties prop = Property.getProp();
        String url = "jdbc:mysql://" + prop.getProperty("dbHost")
                + ":" + prop.getProperty("dbPort") + "/" + prop.getProperty("dbName");
        String driver = "com.mysql.jdbc.Driver";
        String user = prop.getProperty("dbUser");
        String pass = prop.getProperty("dbPass");
        Class.forName(driver);
        Connection cnx = DriverManager.getConnection(url, user, pass);
        return cnx;
    }
}
