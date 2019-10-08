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
import schoolmodel.UserAssignment;
import schoolutils.DBschoolutils;

/**
 *
 * @author christy
 */
public class StudentAssignmentDaoBootcamp {
    
     public List <Assignment> getAllAssignmentsByuserid(User user){
        List <Assignment> list=new ArrayList<>();
        Connection con= DBschoolutils.getconnection();
        String sql="SELECT a.assignmentid,a.title,a.descrition,a.submission_date  FROM( ((users u inner join user_course uc ON u.userid=uc.userid AND u.roleid=3 AND  AND u.userid=?) INNER JOIN courses c ON c.courseid=uc.courseid ) INNER JOIN user_assignment ua ON ua.courseid=c.courseid) INNER JOIN assignments a ON ua.courseid=c.courseid;";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,user.getId());
            ResultSet resultset=pst.executeQuery();
            if(resultset.next()){
                Assignment ass=new Assignment();
                ass.setAssignmetid(resultset.getInt(1));
                ass.setTitle(resultset.getString(2));
                ass.setDescription(resultset.getString(3));
                ass.setSubmission_date(resultset.getTimestamp(4).toLocalDateTime());
                list.add(ass);
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

     
     public boolean insertStudentAssignment(UserAssignment uass){
        Connection con= DBschoolutils.getconnection();
        String sql= "INSERT INTO user_assignment (userid,assignmentid,courseid) VALUES (?,?,?)";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,uass.getUserid());
            pst.setInt(2,uass.getAssignmetid());
            pst.setInt(3,uass.getCourseid());
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
     
     
      public boolean insertStudentAssignmentWithMarks(UserAssignment uass){
        Connection con= DBschoolutils.getconnection();
        String sql= "INSERT INTO user_assignment (userid,assignmentid,courseid,oralmark,totalmark) VALUES (?,?,?,?,?)";
        PreparedStatement pst=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,uass.getUserid());
            pst.setInt(2,uass.getAssignmetid());
            pst.setInt(3,uass.getCourseid());
            pst.setInt(4,uass.getOral_mark());
            pst.setInt(5,uass.getTotal_mark());
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
      
      
     
}
