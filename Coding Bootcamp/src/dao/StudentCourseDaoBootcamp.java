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
import schoolmodel.Assignment;
import schoolmodel.Course;
import schoolmodel.User;
import schoolutils.DBschoolutils;

/**
 *
 * @author christy
 */
public class StudentCourseDaoBootcamp {
    
    public List <User> getAllStudentsByCourseId(Course course){
        List <User> list=new ArrayList<>();
        Connection con= DBschoolutils.getconnection();
        String sql="SELECT * FROM( users u inner join user_course uc ON u.userid=uc.userid AND u.roleid=3)  INNER JOIN courses c ON c.courseid=uc.courseid AND c.courseid=?;";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,course.getId());
            ResultSet resultset=pst.executeQuery();
            if(resultset.next()){
             User user=new User();
             user.setId(resultset.getInt(1));
             user.setUsername(resultset.getString(2));
             user.setPassword(resultset.getString(3));
             list.add(user);
             return list;
            }else{
              return null;  
            }} catch (SQLException ex) {
            Logger.getLogger(StudentDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }
    
    } 
    
    
    
    public boolean insertstudentIntoACourse(Course course,User user){
        Connection con= DBschoolutils.getconnection();
        String sql= "INSERT INTO user_course (courseid,userid) VALUES (?,?)";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,course.getId());
            pst.setInt(2,user.getId());
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
    
     public boolean deleteStudentFromACourse(Course course,User user){
     Connection con= DBschoolutils.getconnection();
     String sql="DELETE FROM users_course where courseid=? AND userid=?";
     PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, course.getId());
            pst.setInt(2, user.getId());
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
    
        
    
    
}
