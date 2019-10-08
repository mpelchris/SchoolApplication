/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolutils;

import appuser.MasterAppUser;
import dao.AssignmentDaoBootcamp;
import dao.CourseDaoBootcamp;
import dao.StudentAssignmentDaoBootcamp;
import dao.StudentCourseDaoBootcamp;
import dao.StudentDaoBootcamp;
import dao.TeacherCourseDaoBootcamp;
import dao.TeacherDaoBootcamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import schoolmodel.Assignment;
import schoolmodel.Course;
import schoolmodel.User;
import schoolmodel.UserAssignment;
import views.PrintMenu;

/**
 *
 * @author christy
 */
public class CRUDSchoolUtils {
    
    public static User createAUser(){
        String algorithm="SHA-256";
        User user=new User();
        System.out.println("Give the firstname of the user");
        String firstname=Utilities.getString();
        user.setFirstname(firstname);
        System.out.println("Give the lastname of the user");
        String lastname=Utilities.getString();
        user.setLastname(lastname);
        System.out.println("Give the users username");
        String username=Utilities.getString();
        user.setUsername(username);
        System.out.println("Give the users password");
        String password=Utilities.getString();
        String hashed_password =LoginSchoolUtils.generateHash(password, algorithm);
        user.setPassword(hashed_password);
        return user;
    }
    
    public static Course createACourse(){
        Course course=new Course();
        System.out.println("Give the title of the course");
        String title=Utilities.getString();
        course.setTitle(title);
        System.out.println("Give the stream of the course");
        String stream=Utilities.getString();
        course.setStream(stream);
        System.out.println("Give the start_date of the course");
        String start_date=Utilities.getString();
        LocalDate startdate = LocalDate.parse(start_date);
        course.setStart_date(startdate);
        System.out.println("Give the start_date of the course");
        String end_date=Utilities.getString();
        LocalDate enddate = LocalDate.parse(end_date);
        course.setStart_date(enddate);
        return course;
    }
    
    public static Assignment createAnAssignment(Course course){
        Assignment ass=new Assignment();
        ass.setCourseid(course.getId());
        System.out.println("Give the title of the Assignmnt");
        String title=Utilities.getString();
        ass.setTitle(title);
        System.out.println("Give the description of the Assignment");
        String description=Utilities.getString();
        ass.setDescription(description);
        System.out.println("Give the submission_date of the  . (yyyy-mm-dd");
        String submission_date=Utilities.getString();
        System.out.println("Give the submission_time of the Assignment. (hh:mm:ss)  ");
        String submission_time=Utilities.getString();
        String submission_Date_Time= submission_date+"T"+submission_time;
        LocalDateTime submissiondatetime = LocalDateTime.parse(submission_Date_Time);
        ass.setSubmission_date(submissiondatetime);
        return ass;
    }
     
    public static void changeFirstnameOfUser(User user){
        System.out.println("Firstname:   " + user.getFirstname());
        System.out.println("Give new Firstname:");
        String new_firstname=Utilities.getString();
        user.setFirstname(new_firstname);
      }
    
    public static void changeLastnameOfUser(User user){
        System.out.println("Lastname:   " + user.getLastname());
        System.out.println("Give new Firstname:");
        String new_lastname=Utilities.getString();
        user.setFirstname(new_lastname);
    
    }
    
    public static void changePasswordOfUser(User user){
        System.out.println("Username:   " + user.getPassword());
        System.out.println("Give new Password:");
        String new_password =Utilities.getString();
        user.setFirstname(new_password);
     }
     
    public static void changeUsernameOfUser(User user){
        System.out.println("Username:   " + user.getUsername());
        System.out.println("Give new Username:");
        String new_Username =Utilities.getString();
        user.setFirstname(new_Username);
     }
    
    public static void updateUsersTopics(User user){
        boolean exit=false;
        PrintMenu.printUserTopicsMenuForUpdate();
        System.out.println(user);
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
                exit=true;
            case 1:
               CRUDSchoolUtils.changeFirstnameOfUser(user);
            break;
            case 2:
                CRUDSchoolUtils.changeLastnameOfUser(user);
            break;
            case 3:
                CRUDSchoolUtils.changeUsernameOfUser(user);
            break;
            case 4:
               CRUDSchoolUtils.changePasswordOfUser(user);
            break;
              }    
        }
             
    public static void updateTeacher(){
        TeacherDaoBootcamp tdb=new TeacherDaoBootcamp();
        System.out.println("The teachers of the school are :");
        System.out.println(tdb.getAllTeachers());
        System.out.println("Press the number of the id of the student you want to update,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=tdb.getTeacherById(id);
            CRUDSchoolUtils.updateUsersTopics(user);
        }  
          MasterAppUser.cRUDOnTeachers();
        }
     }     
    
    public static void updateStudent(){
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        System.out.println("The students of the school are :");
        System.out.println(sdb.getAllStudents());
        System.out.println("Press the number of the id of the student you want to update,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=sdb.getStudentById(id);
            CRUDSchoolUtils.updateUsersTopics(user);
        }  
          MasterAppUser.cRUDOnStudents();
        }
    }   
    
    public static void changeTitleOfCourse(Course course){
        System.out.println("Title: " + course.getTitle());
        System.out.println("Give new Title:");
        String new_title=Utilities.getString();
        course.setTitle(new_title);
      }
    
    
    public static void changeStreamOfCourse(Course course){
        System.out.println("Stream: " + course.getStream());
        System.out.println("Give new Stream:");
        String new_stream=Utilities.getString();
        course.setTitle(new_stream);
      }
    
     public static void changeStartDateOfCourse(Course course){
        System.out.println("Start_date: " + course.getTitle());
        System.out.println("Give new :");
        String start_date=Utilities.getString();
        LocalDate startdate = LocalDate.parse(start_date);
        course.setStart_date(startdate);
     }
     
     
    public static void changeEndDateOfCourse(Course course){
        System.out.println("End_date: " + course.getTitle());
        System.out.println("Give new :");
        String end_date=Utilities.getString();
        LocalDate enddate = LocalDate.parse(end_date);
        course.setStart_date(enddate);
    }
            
    
    
    public static void updateCourse(){
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        System.out.println("The courses of the school are :");
        System.out.println(cdb.getAllCourses());
        System.out.println("Press the number of the id of the course you want to update,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            Course course=cdb.getCourseById(id); 
            CRUDSchoolUtils.updateCoursesTopics(course);
        }  
          MasterAppUser.cRUDOnCourses();
        }
    }   
    
     public static void updateAssignment(){
        AssignmentDaoBootcamp adb=new AssignmentDaoBootcamp();
        System.out.println("The assignments of the school are :");
        System.out.println(adb.getAllAssignments());
        System.out.println("Press the number of the id of the assignmentyou want to update and the id of the course in which it belongs you want to update,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
            System.out.println("Courseid:");
         int courseid=Utilities.getInt();
            System.out.println("Assignmentid:");
         int assid=Utilities.getInt();
        switch (courseid) {
        case 0:
            exit=true;
            break;
        default: 
            Assignment ass=adb.getAssignmentById(assid,courseid);
            if( ass==null){
                System.out.println("This Assignment does not exist.Try again!");
                 CRUDSchoolUtils.updateAssignment();
            } else{
           ass= CRUDSchoolUtils.updateAssignmentsTopics(ass);
            adb.updateAssignment(ass);
            }
            }  
          MasterAppUser.cRUDOnAssignments();
        }
    }   
     
      public static void updateCoursesTopics(Course course){
        boolean exit=false;
        PrintMenu.printCoursesTopicsMenuForUpdate();
        System.out.println(course);
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
                exit=true;
            case 1:
               CRUDSchoolUtils.changeTitleOfCourse(course);
            break;
            case 2:
                CRUDSchoolUtils.changeStreamOfCourse(course);
            break;
            case 3:
                CRUDSchoolUtils.changeStartDateOfCourse(course);
            break;
            case 4:
               CRUDSchoolUtils.changeEndDateOfCourse(course);
            break;
              }    
        }
    
    public static Course  selectCourseByIdToPutAssignemnt(){
        CourseDaoBootcamp tdb=new CourseDaoBootcamp();
        System.out.println("The courses of the school are :");
        System.out.println(tdb.getAllCourses());
        System.out.println("Press the number of the id of the course you want to put the Assignment,else press 0 to exit ");
        int id=Utilities.getInt();
        Course course=tdb.getCourseById(id); 
        return course;
    }
    
    public static Assignment updateAssignmentsTopics(Assignment ass){
        boolean exit=false;
        PrintMenu.printAssignmentsTopicsMenuForUpdate();
        System.out.println(ass);
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
                exit=true;
            case 1:
               CRUDSchoolUtils.changeTitleOfAssignment(ass);
            break;
            case 2:
                CRUDSchoolUtils.changeDescriptionOfAssignment(ass);
            break;
            case 3:
                CRUDSchoolUtils.changeSubmissionDateTimeOfAssignment(ass);
            break;
            }   
        return ass;
        }
    
    
    
    
     public static void changeTitleOfAssignment(Assignment ass){
        System.out.println("Title: " + ass.getTitle());
        System.out.println("Give new Title for the Assignment:");
        String new_title=Utilities.getString();
        ass.setTitle(new_title);
      }
     
      public static void changeDescriptionOfAssignment(Assignment ass){
        System.out.println("Description: " + ass.getDescription());
        System.out.println("Give new Description for the Assignment:");
        String new_description=Utilities.getString();
        ass.setDescription(new_description);
        }
    
    public static void changeSubmissionDateTimeOfAssignment(Assignment ass){
        System.out.println("Submission_date (): " + ass.getSubmission_date());
        System.out.println("Give the new submission_date of the Assignment  . (yyyy-mm-dd");
        String submission_date=Utilities.getString();
        System.out.println("Give the new submission_time of the Assignment. (hh:mm:ss)  ");
        String submission_time=Utilities.getString();
        String submission_Date_Time= submission_date+"T"+submission_time;
        LocalDateTime submissiondatetime = LocalDateTime.parse(submission_Date_Time);
        ass.setSubmission_date(submissiondatetime);
    }
       
        
       
               
      
    public static Course selectCourseByIdToPutAssignment(){
        CourseDaoBootcamp tdb=new CourseDaoBootcamp();
        System.out.println("The courses of the school are :");
        System.out.println(tdb.getAllCourses());
        System.out.println("Press the number of the id of the course you want to put the Assignment,else press 0 to exit ");
        int id=Utilities.getInt();
        Course course=tdb.getCourseById(id); 
        
        return course;
    }
    
    public static void putStudentToCourseById(User user){
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        StudentCourseDaoBootcamp scdb=new StudentCourseDaoBootcamp();
        System.out.println("Select the Course you want to put the Student by pressing it's id, else press 0 to exit.");
        System.out.println(cdb.getAllCourses());
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            Course course=cdb.getCourseById(id);
            scdb.insertstudentIntoACourse(course, user);
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
      }
    
    public static void selectStudenttoPutIntoCourse(){
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        System.out.println("The students of the school are :");
        System.out.println(sdb.getAllStudents());
        System.out.println("Press the number of the id of the student you want to put into a course,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=sdb.getStudentById(id);
            CRUDSchoolUtils.putStudentToCourseById(user);
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
    }   
    
    public static void selectStudenttoPutIntoUserAssignment(){
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        System.out.println("The students of the school are :");
        System.out.println(sdb.getAllStudents());
        System.out.println("Press the number of the id of the student you want to put into a course,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=sdb.getStudentById(id);
            CRUDSchoolUtils.putStudentToAssignmentById(user);
        }  
          MasterAppUser.cRUDOnAssignments();
        }
    }   
    
    public static void selectToDeleteStudentFromACourse(){
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        System.out.println("The students of the school are :");
        System.out.println(sdb.getAllStudents());
        System.out.println("Press the number of the id of the student you want to delete from a course,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=sdb.getStudentById(id);
            CRUDSchoolUtils.deleteStudentFromACourseById(user);
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
    
    }
    
    public static void deleteStudentFromACourseById(User user){
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        StudentCourseDaoBootcamp scdb=new StudentCourseDaoBootcamp();
        System.out.println("Select the Course you want to put the Student by pressing it's id, else press 0 to exit.");
        System.out.println(cdb.getAllCourses());
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            Course course=cdb.getCourseById(id);
            scdb.deleteStudentFromACourse(course, user);
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
      }

    public static void putTeacherToCourseById(User user) {
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        TeacherCourseDaoBootcamp tcdb=new TeacherCourseDaoBootcamp();
        System.out.println("Select the Course you want to put the Teacher by pressing it's id, else press 0 to exit.");
        System.out.println(cdb.getAllCourses());
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            Course course=cdb.getCourseById(id);
            tcdb.insertTeacherIntoACourse(course, user);
        }  
          MasterAppUser.cRUDOnTrainersCourses();
        }
    }

    public static void selectTeachertoPutIntoCourse() {
        TeacherDaoBootcamp tdb=new TeacherDaoBootcamp();
        System.out.println("The students of the school are :");
        System.out.println(tdb.getAllTeachers());
        System.out.println("Press the number of the id of the teacher you want to put into a course,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=tdb.getTeacherById(id);
            CRUDSchoolUtils.putTeacherToCourseById(user);
        }  
          MasterAppUser.cRUDOnTrainersCourses();
        }
    }

    public static void deleteTeacherFromCourseById(User user) {
       CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        TeacherCourseDaoBootcamp tcdb=new TeacherCourseDaoBootcamp();
        System.out.println("Select the Course from which you want to delete the Teacher by pressing it's id, else press 0 to exit.");
        System.out.println(cdb.getAllCourses());
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            Course course=cdb.getCourseById(id);
            tcdb.deleteTeacherFromACourse(course, user);   
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
    }
    
     public static void selectToDeleteTeacherFromACourse(){
        TeacherDaoBootcamp tdb=new TeacherDaoBootcamp();
        System.out.println("The teachers of the school are :");
        System.out.println(tdb.getAllTeachers());
        System.out.println("Press the number of the id of the teacher you want to delete from a course,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
         int id=Utilities.getInt();
        switch (id) {
        case 0:
            exit=true;
            break;
        default: 
            User user=tdb.getTeacherById(id);
            CRUDSchoolUtils.deleteTeacherFromCourseById(user);
        }  
          MasterAppUser.cRUDOnStudentCourses();
        }
    
    }

    private static void putStudentToAssignmentById(User user) {
       StudentAssignmentDaoBootcamp sadb=new StudentAssignmentDaoBootcamp();
      AssignmentDaoBootcamp adb=new AssignmentDaoBootcamp();
      UserAssignment uass=new UserAssignment();
        System.out.println("The assignments of the school are :");
        System.out.println(adb.getAllAssignments());
        System.out.println("Press the number of the id of the assignment you want to update and the id of the course in which it belongs you want to update,else press 0 to exit ");
        boolean exit=false;
        while(!exit) {
            System.out.println("Courseid:");
         int courseid=Utilities.getInt();
            System.out.println("Assignmentid:");
         int assid=Utilities.getInt();
        switch (courseid) {
        case 0:
            exit=true;
            break;
        default: 
            Assignment ass=adb.getAssignmentById(assid,courseid);
            if( ass==null){
                System.out.println("This Assignment does not exist.Try again!");
                 CRUDSchoolUtils.putStudentToAssignmentById(user);
            } else{
            uass.setAssignmetid(assid);
            uass.setUserid(user.getId());
            uass.setCourseid(courseid);
            sadb.insertStudentAssignment(uass);
            }  
            MasterAppUser.cRUDOnAssignments();
    }
        }}
    
    
}













