/*
    



 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.bootcamp;

import dao.AssignmentDaoBootcamp;
import dao.CourseDaoBootcamp;
import dao.MasterDaoBootcamp;
import dao.StudentAssignmentDaoBootcamp;
import dao.StudentCourseDaoBootcamp;
import dao.StudentDaoBootcamp;
import dao.TeacherDaoBootcamp;
import dao.UserDaoBootcamp;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import schoolmodel.Assignment;
import schoolmodel.Course;
import schoolmodel.User;
import schoolutils.CRUDSchoolUtils;
import schoolutils.DBschoolutils;
import schoolutils.LoginSchoolUtils;
import schoolutils.Utilities;


/**
 *
 * @author christy
 */
public class CodingBootcamp {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LoginSchoolUtils lsu=new LoginSchoolUtils();
        lsu.giveUsernameAndPassword();
       
      
       
//        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
//        StudentCourseDaoBootcamp scdb=new StudentCourseDaoBootcamp();
//        System.out.println("The students per course are:");
//        List <Course> courselist= cdb.getAllCourses();
//        for(int i=0;i<courselist.size();i++){
//            System.out.println((i+1)+") The student "+scdb.getAllStudentsByCourseId(courselist.get(i))+", has the course "+courselist.get(i)); 
//        }
  //          AssignmentDaoBootcamp asb=new AssignmentDaoBootcamp();
    //       System.out.println(asb.getAssignmentById(1,2));
           
//            Assignment ass=new Assignment();
             //CourseDaoBootcamp cdb=new CourseDaoBootcamp();
//           Course course= cdb.getCourseById(2);
//           ass.setTitle("assignment1");
//           ass.setDescription("one good assignment");
            
            

           
            //asb.insertAssignment(course, ass);

   // CourseDaoBootcamp cdb=new CourseDaoBootcamp();
//    
//        System.out.println(cdb.getAllCourses());
//        Connection con=DBschoolutils.getconnection();
//        User user2=new User();
////        user2.getId();
//        user2.setUsername("student1");
//        user2.setPassword("11125");
//      
//       StudentDaoBootcamp sdb=new StudentDaoBootcamp();
//       UserDaoBootcamp udb=new UserDaoBootcamp();
//       User user=udb.getUserByUsernameAndPassword("student1","11125");
//       udb.getUserRoleidByUserID( user.getId());
////       sdb.updateStudent(user);
//         sdb.insertStudent(user2);
////        sdb.deleteStudent(1);
//        sdb.getAllStudents();
//        System.out.println( sdb.getStudentById(3));
//    User user7= new User();
//    user7.setUsername("teacher4");
//    user7.setPassword("teacher4");
//
//     String algorithm="SHA-256";
//      StudentDaoBootcamp sdb=new StudentDaoBootcamp();
//      User user=new User();
//      user.setUsername("student2");
//      String password="student2";
//      LoginSchoolUtils lsu=new LoginSchoolUtils();
//      String hashed_password=LoginSchoolUtils.generateHash(password,algorithm);
//      user.setPassword(hashed_password);
//      user.setRoleid(3);
//      sdb.insertStudent(user);
//      TeacherDaoBootcamp tdb= new TeacherDaoBootcamp();
//////      tdb.deleteTeacher(6);
////       
//       System.out.println(tdb.getTeacherById(7));
//////
//        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
////        System.out.println(cdb.getAllCourses());
////          System.out.println(cdb.getCourseById(1));
//      Course course= cdb.getCourseById(5);
//        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
//      Course course=  cdb.getCourseById(7);
//      course.setEnd_date(LocalDate.parse("2019-10-08"));
//      cdb.updateCourse(course);
//            Course course=new Course();
//            course.setTitle("Java8");
//            course.setStream("part2");
//            course.setStart_date(LocalDate.parse("2019-09-08"));
//            cdb.insertCourse(course);
////           
////           cdb.insertCourse(course);
//
//        System.out.println(cdb.getCourseById(6)); 


//cdb.updateCourse(course);
//      
//         String algorithm="SHA-256";
//        User user=new User();
//         user.setUsername("master1");
//        String password="master1";
//         String hashed_password=LoginSchoolUtils.generateHash(password,algorithm);
//        user.setPassword(hashed_password);
//      user.setRoleid(1);
//      MasterDaoBootcamp mdb=new  MasterDaoBootcamp();
//        mdb.insertMaster(user);
//        
        
//public String toString()
//    {
//        String message ="The course: " + course.getTitle() + " " + course.getStream() + " " + course.getType() + " Has the following trainers: \n";
//         for(Trainer trainer : trainers)
//        {
//            message += trainer.getFirstName() + " " + trainer.getLastName() + "\n";
//        }
//         return message;
//    }
//        
        
        
    }
    
}
