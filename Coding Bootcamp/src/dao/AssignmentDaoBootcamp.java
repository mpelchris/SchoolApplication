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
public class AssignmentDaoBootcamp {
    
     public List <Assignment> getAllAssignments(){
      List <Assignment> list=new ArrayList<>();
      Connection con= DBschoolutils.getconnection();
      String sql="Select * FROM assignments;";
      PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            ResultSet resultset=pst.executeQuery();
            while(resultset.next()){
                Assignment ass=new Assignment();
                ass.setAssignmetid(resultset.getInt(1));
                ass.setCourseid(resultset.getInt(2));
                ass.setTitle(resultset.getString(3));
                ass.setDescription(resultset.getString(4));
                ass.setSubmission_date(resultset.getTimestamp(5).toLocalDateTime());
                list.add(ass);
                 }return list;
           } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
      } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
        }
}
     
     public List <Assignment> getAssignmentsByCourse(Course course){
      List <Assignment> list=new ArrayList<>();
      Connection con= DBschoolutils.getconnection();
      String sql="Select * FROM assignments;";
      PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            ResultSet resultset=pst.executeQuery();
            while(resultset.next()){
                Assignment ass=new Assignment();
                ass.setAssignmetid(resultset.getInt(1));
                ass.setCourseid(resultset.getInt(2));
                ass.setTitle(resultset.getString(3));
                ass.setDescription(resultset.getString(4));
                ass.setSubmission_date(resultset.getTimestamp(5).toLocalDateTime());
                list.add(ass);
                 }return list;
           } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
      } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);
        }
}
     
   

     
     
      public Assignment getAssignmentById(int assignmentid,int courseid) {
          Assignment ass=new Assignment();
          String sql="SELECT * FROM assignments WHERE courseid=? and assignmentid=?";
          Connection con= DBschoolutils.getconnection();
          PreparedStatement pst=null;
          try {
          pst=con.prepareStatement(sql);
          pst.setInt(1,courseid);
          pst.setInt(2,assignmentid);
          ResultSet resultset=pst.executeQuery();
          if(resultset.next()){
            ass.setAssignmetid(resultset.getInt(1));
            ass.setCourseid(resultset.getInt(2));
            ass.setTitle(resultset.getString(3));
            ass.setDescription(resultset.getString(4));
            ass.setSubmission_date(resultset.getTimestamp(5).toLocalDateTime());
            return ass;
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
     
    public boolean insertAssignment(Course course,Assignment assignment){
        Connection con= DBschoolutils.getconnection();
        String sql= "INSERT INTO assignments (courseid,title,descrition,submission_date) VALUES (?,?,?,?)";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,course.getId());
            pst.setString(2,assignment.getTitle());
            pst.setString(3,assignment.getDescription());
            pst.setObject(4,assignment.getSubmission_date());
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
    
     public void updateAssignment(Assignment ass){
        Connection con= DBschoolutils.getconnection();
        String sql= "UPDATE assignments SET title=?,descrition=?,submission_date=? WHERE courseid=? and assignmentid=?";
        PreparedStatement pst= null;
        try {
            pst=con.prepareStatement(sql);
           pst.setString(1,ass.getTitle());
           pst.setString(2,ass.getDescription());
           pst.setObject(3,ass.getSubmission_date());
           pst.setInt(4,ass.getCourseid());
           pst.setInt(5,ass.getAssignmetid());
           pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoBootcamp.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBschoolutils.closeStatement(pst);
            DBschoolutils.closeConnection(con);

        }

    }
    
}


