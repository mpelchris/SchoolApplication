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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import schoolmodel.User;
import schoolutils.DBschoolutils;

/**
 *
 * @author christy
 */
public class StudentDaoBootcamp {
    
   
    
    public List <User> getAllStudents(){
      List <User> list=new ArrayList<>();
      Connection con= DBschoolutils.getconnection();
      String sql="Select * From users WHERE roleid=3;";
      PreparedStatement pst=null;
        try {
//              pst.setInt(1, this.getStudentRoleid());
            pst=con.prepareStatement(sql);
            ResultSet resultset=pst.executeQuery();
            while(resultset.next()){
            User user=new User();
            user.setId(resultset.getInt(1));
            user.setUsername(resultset.getString(2));
            user.setPassword(resultset.getString(3));
            list.add(user);
            }

      } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
      } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }

      return list;
  }

    public User getStudentById(int id) {
          User user = new User();
          String sql="SELECT * FROM users WHERE userid=? and roleid=?";
          Connection con= DBschoolutils.getconnection();
          PreparedStatement pst=null;
          try {
          pst=con.prepareStatement(sql);
          pst.setInt(1,id);
          pst.setInt(2,this.getStudentRoleid());
          ResultSet resultset=pst.executeQuery();
          resultset.next();
          user.setId(resultset.getInt("userid"));
          user.setUsername(resultset.getString("username"));  
          user.setPassword(resultset.getString("user_password"));   
          user.setFirstname(resultset.getString("firstname"));
          user.setLastname(resultset.getString("lastname"));

    } catch (SQLException ex) {
          Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally {
          DBschoolutils.closeStatement(pst);
          DBschoolutils.closeConnection(con);
      }
      return user;
    }  

    public int getStudentRoleid(){
      Connection con= DBschoolutils.getconnection();
      String sql="SELECT roleid FROM roles WHERE role_name='student';";
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
        }
         finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }

    }

    public boolean insertStudent(User user){
    Connection con= DBschoolutils.getconnection();
     String sql= "INSERT INTO users(username,user_password,roleid) VALUES (?,?,?)";
     PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            pst.setInt(3, this.getStudentRoleid());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
          finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }
    }

    public boolean deleteStudent(int id){
     Connection con= DBschoolutils.getconnection();
     String sql="DELETE FROM users where userid=? ";
     PreparedStatement pst=null;

        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();              
            return true; 
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally {
          DBschoolutils.closeStatement(pst);
          DBschoolutils.closeConnection(con);
      }
       }

    public void updateStudent(User user){
    Connection con= DBschoolutils.getconnection();
    String sql="Update users SET username=?,user_password=?,firstname=?,lastname=? WHERE userid=?;";
    PreparedStatement pst= null;
        try {
            pst=con.prepareStatement(sql);
           pst.setString(1,user.getUsername());
           pst.setString(2,user.getPassword());
           pst.setString(3,user.getUsername());
           pst.setString(4,user.getUsername());
           pst.setInt(5,user.getId());
           pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }

    }

    
      
      
      
}

