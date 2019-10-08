/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import schoolmodel.User;
import schoolutils.DBschoolutils;

/**
 *
 * @author christy
 */
public class UserDaoBootcamp {
    
     public int getUserRoleidByUserID(int id){
        Connection con= DBschoolutils.getconnection();
        String sql="Select roleid from users where userid=?;";
        PreparedStatement pst=null;

        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultset=pst.executeQuery();
            resultset.next();
            int roleid=resultset.getInt(1);
            System.out.println(roleid);
            return roleid;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return 0 ;
        }
         finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
           }
  }

     public User getUserByUsername(String username){
        User user = new User();
        String sql="SELECT * FROM users WHERE username=?;";
        Connection con= DBschoolutils.getconnection();
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,username);
            ResultSet resultset=pst.executeQuery();
             if(resultset.next()) {
                user.setId(resultset.getInt("userid"));
                user.setUsername(resultset.getString("username"));  
                user.setPassword(resultset.getString("user_password"));   
                user.setFirstname(resultset.getString("firstname"));
                user.setLastname(resultset.getString("lastname"));
                user.setRoleid(resultset.getInt("roleid"));
                return user;
            } else{
                return null; 
            }
        } catch (SQLException ex) {
           Logger.getLogger(UserDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
        
      }
     
     }
