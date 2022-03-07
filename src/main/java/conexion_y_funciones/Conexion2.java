/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_y_funciones;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esteban
 */
public class Conexion2 {
    private static Connection con=null;
     public Connection getConnection() throws URISyntaxException, SQLException {
        if( con == null ){ 
            URI dbUri = new URI("postgres://zaivkdulhmynrz:45c97998daf7b9b34ecec550b2e042246805f5979b265603a7526dbce2c1a5b1@ec2-18-213-12-212.compute-1.amazonaws.com:5432/d6rscf2q3bo3a4");

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
        
            con=DriverManager.getConnection(dbUrl, username, password);
        }
        return con;
    }
}
