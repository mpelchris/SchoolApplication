/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christy
 */
public class DBschoolutils {
    private static final String USERNAME =  "root";
    private static final String PASS     =  "123456789";
    private static final String MYSQLURL =  "jdbc:mysql://localhost:3306/bootcamp?zeroDateTimeBehavior=CONVERT_TO_NULL" +
                                            "&useUnicode=true" +
                                            "&useJDBCCompliantTimezoneShift=true" +
                                            "&useLegacyDatetimeCode=false" +
                                            "&serverTimezone=UTC" +
                                            "&allowPublicKeyRetrieval=true" +
                                            "&useSSL=false";

     
    public static Connection getconnection() {
        Connection con=null;
         
        try {
            con=  DriverManager.getConnection(MYSQLURL, USERNAME ,PASS );
           
        }catch (SQLException ex) {
            Logger.getLogger(DBschoolutils.class.getName()).log(Level.SEVERE, null, ex);
        }
         return con;
     }                  
        
    

        
        public static void closeStatement (PreparedStatement pst){
        try {
            if(pst!=null) {
            pst.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBschoolutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public static void closeConnection (Connection con) {
        try {
            if(con!=null) {
            con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBschoolutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
     
     
     
    
}

    

