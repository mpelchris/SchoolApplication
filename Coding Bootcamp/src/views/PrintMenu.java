    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author christy
 */
public class PrintMenu {
    
    public static void printMastersMainMenu(){
        System.out.println("What do you want to do?");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: EXIT");
        System.out.println("1: CRUD on students");   
        System.out.println("2: CRUD on teachers");
        System.out.println("3: CRUD on courses");
        System.out.println("4: CRUD on assignments");
        System.out.println("5: CRUD on Students per Courses");
        System.out.println("6: CRUD on Trainers per Courses");
        System.out.println("7: CRUD on Assignments per Courses per Assignment");
        
    }
           
    
    public static void printTeachersAppUserMainMenu(){
        System.out.println("What do you want to do?");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: EXIT");
        System.out.println("1: View the courses that i enrole");   
        System.out.println("2: View the other choices i have");
      }
    
    public static void printTeachersMainMenu(){
        System.out.println("What do you want to do?");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: EXIT");
        System.out.println("1: View all the students per course");
//        System.out.println("2: View all the assignments per student per course");
//        System.out.println("3: Mark all the assignments per student per course");
    
    }
    
    
    public static void printStudentsAppUserMainMenu(){
        
    
         
    }
     
    public static void printCourseCRUDMenu(){
        System.out.println("What do you want to do with courses;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: CREATE a course");  
        System.out.println("2: GET all the courses");
        System.out.println("3: CHANGE topics of a course");
        System.out.println("4: DELETE a course");
      } 
    
     public static void printAssignmentCRUDMenu(){
        System.out.println("What do you want to do with Assignmments;");
        System.out.println("Press the number of your choice and then press enter.");
        System.out.println("0: Go to main menu.");
        System.out.println("1: CREATE an assignment for a course.");  
        System.out.println("2: GET all the assignments of the courses.");
        System.out.println("3: CHANGE topics of an assignment.");
        System.out.println("4: Put a student into an assignment");
        System.out.println("5: GET all students per course per assignment");
                
      } 
     
      
    public static void printTrainersCRUDMenu(){
        System.out.println("What do you want to do with users;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: CREATE a trainer");   
        System.out.println("2: GET all the trainers");
        System.out.println("3: CHANGE topics of a trainer");
        System.out.println("4: DELETE a trainer");
    } 
    
    public static void printStudentCRUDMenu(){
        System.out.println("What do you want to do with users;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: CREATE a student");   
        System.out.println("2: GET all the students");
        System.out.println("3: CHANGE topics of a student");
        System.out.println("4: DELETE a student");
        
    }
     
    public static void printUserTopicsMenuForUpdate(){
        System.out.println("What do you want to change about the User?");
        System.out.println("Press the number of your choice.");
        System.out.println("1: Change Firstname");
        System.out.println("2: Change Lastname");   
        System.out.println("3: Change username");
        System.out.println("4: Change password");
    }
    
     public static void printCoursesTopicsMenuForUpdate(){
        System.out.println("What do you want to change about the User?");
        System.out.println("Press the number of your choice.");
        System.out.println("1: Change Title");
        System.out.println("2: Change Stream");   
        System.out.println("3: Change Start_Date");
        System.out.println("4: Change End_Date");
    }
    
     public static void printAssignmentsTopicsMenuForUpdate(){
        System.out.println("What do you want to change about the Assignment?");
        System.out.println("Press the number of your choice.");
        System.out.println("1: Change Title");
        System.out.println("2: Change Description");   
        System.out.println("3: Change Submission_Date and Time");
       }
     
    public static void printStudentCourseCRUDMenu(){
        System.out.println("What do you want to do with the students per course;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: Create a student for a course");  
        System.out.println("2: Put a student that already exists in a course");
        System.out.println("3: GET the students per courses");
        System.out.println("4: DELETE a student from course");
    }

    public static void printTrainersCourseCRUDMenu() {
        System.out.println("What do you want to do with the trainers per course;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: Create a trainer for a course");  
        System.out.println("2: Put a trainer that already exists in a course");
        System.out.println("3: GET the trainers per courses");
        System.out.println("4: DELETE a trainer from course");
    }

    public static void printAssignmentCourseCRUDMenu() {
        System.out.println("What do you want to do with the assignments per course;");
        System.out.println("Press the number of your choice and then press enter");
        System.out.println("0: Go to main menu");
        System.out.println("1: Create an assignement for a course");  
        System.out.println("2: Put an assignment that already exists in a course");
        System.out.println("3: GET the assignments per courses");
        System.out.println("4: DELETE an assignment from course");
    }
     
 }
