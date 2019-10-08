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
public class MasterDaoBootcamp {
    
    
    public int getMasterRoleid(){
        Connection con= DBschoolutils.getconnection();
        String sql="SELECT roleid FROM roles WHERE role_name='headmaster';";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            ResultSet resultset=pst.executeQuery();
            resultset.next();
            int roleid=resultset.getInt(1);
            System.out.println(roleid);
            return roleid;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
         }
       }
    
     public boolean insertMaster(User user){
    Connection con= DBschoolutils.getconnection();
     String sql= "INSERT INTO users(username,user_password,roleid) VALUES (?,?,?)";
     PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            pst.setInt(3, this.getMasterRoleid());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
        }
    }
}
