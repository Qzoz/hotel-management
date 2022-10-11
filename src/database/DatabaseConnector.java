/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quraishi
 */
public class DatabaseConnector {

        private Connection conn;
        
        public DatabaseConnector () {
                try{
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection("jdbc:sqlite:HotelManagement.db");
                } catch (Exception e) {
                        
                }
        }
        
        public Connection getConn(){
                return this.conn;
        }
        
        public void terminateConnection(){
                if(conn != null){
                        try {
                                conn.close();
                        } catch (SQLException ex) {
                                
                        }
                }
        }
        
        
        
        
}
