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
import schoolmodel.Course;
import schoolmodel.User;
import schoolutils.DBschoolutils;

/**
 *
 * @author christy
 */
public class CourseDaoBootcamp {
    
     public List <Course> getAllCourses(){
      List <Course> list=new ArrayList<>();
      Connection con= DBschoolutils.getconnection();
      String sql="Select * FROM courses;";
      PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            ResultSet resultset=pst.executeQuery();
            while(resultset.next()){
                Course course=new Course();
                course.setId(resultset.getInt(1));
                course.setTitle(resultset.getString(2));
                course.setStream(resultset.getString(3));
                course.setStart_date(resultset.getTimestamp(4).toLocalDateTime().toLocalDate());
                course.setEnd_date(resultset.getTimestamp(5).toLocalDateTime().toLocalDate());
                list.add(course);
                }return list;
           
            } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
      } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
        }
     }
     
     public Course getCourseById(int id) {
          Course course= new Course();
          String sql="SELECT * FROM courses WHERE courseid=?";
          Connection con= DBschoolutils.getconnection();
          PreparedStatement pst=null;
          try {
          pst=con.prepareStatement(sql);
          pst.setInt(1,id);
          ResultSet resultset=pst.executeQuery();
          if(resultset.next()){
            course.setId(resultset.getInt(1));
            course.setTitle(resultset.getString(2));
            course.setStream(resultset.getString(3));
            course.setStart_date(resultset.getTimestamp(4).toLocalDateTime().toLocalDate());
            course.setEnd_date(resultset.getTimestamp(5).toLocalDateTime().toLocalDate());
            return course;
          }else {
                return null;
       } } catch (SQLException ex) {
              Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
           return null;
      }
      finally {
          DBschoolutils.closeStatement(pst);
          DBschoolutils.closeConnection(con);
      }
     }  
     
     public boolean insertCourse(Course course){
    Connection con= DBschoolutils.getconnection();
//     String sql= "INSERT INTO courses (title,stream,type_time,start_Date,end_Date) VALUES (?,?)";
      String sql= "INSERT INTO courses (title,stream,startDate,endDate) VALUES (?,?,?,?)";
     PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,course.getTitle());
            pst.setString(2,course.getStream()) ;
            pst.setObject(3, course.getStart_date());
            pst.setObject(3, course.getEnd_date());
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
    } /// aporia
     
     public boolean deleteCourse(int id){
     Connection con= DBschoolutils.getconnection();
     String sql="DELETE FROM courses where courseid=? ";
     PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();              
            return true; 
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally {
          DBschoolutils.closeStatement(pst);
          DBschoolutils.closeConnection(con);
      }
       }
      
      
    public void updateCourse(Course course){
        Connection con= DBschoolutils.getconnection();
   
        String sql= "UPDATE courses SET title=?,stream=?,startDate=?,endDate=? WHERE courseid=?;";
        PreparedStatement pst= null;
        try {
            pst=con.prepareStatement(sql);
           pst.setString(1,course.getTitle());
           pst.setString(2,course.getStream());
           pst.setObject(3,course.getStart_date());
           pst.setObject(4,course.getEnd_date());
           pst.setInt(5,course.getId());
           pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }

    }
}



