/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.pojo;

import java.sql.*;

/**
 *
 * @author Papa
 */
public class Conexion {
    Connection miconexion = null ;
        public Conexion(){
        
        }
    public Connection getConnection() {
        
        
          try {
              String cadenaConexion="jdbc:mysql://localhost:3306/pruebasjava";
              miconexion = DriverManager.getConnection(cadenaConexion, "java2018", "2018");
           
        } catch ( SQLException e) {

    }
return miconexion;
    }   
    
    public static void close(Connection conect) throws SQLException {
        conect.close();
        
    }
}
