/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appuser;

import dao.AssignmentDaoBootcamp;
import dao.CourseDaoBootcamp;
import dao.StudentAssignmentDaoBootcamp;
import dao.StudentCourseDaoBootcamp;
import views.PrintMenu;

import java.util.Scanner;
import schoolutils.Utilities;
import dao.StudentDaoBootcamp;
import dao.TeacherDaoBootcamp;
import schoolmodel.Assignment;
import schoolmodel.Course;
import schoolmodel.User;
import schoolutils.CRUDSchoolUtils;
import schoolutils.LoginSchoolUtils;

/**
 *
 * @author christy
 */
public class MasterAppUser {

    

    
    
    public static void callMastersMethods(){
        PrintMenu.printMastersMainMenu();
        //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
       boolean exit=false;
        while(!exit){
        int context=Utilities.getInt();
         switch (context) {
            case 0:
                exit=true;   
                break;
            case 1:
                MasterAppUser.cRUDOnStudents();
                break;
            case 2:
                MasterAppUser.cRUDOnTeachers();
              break;
            case 3:
                MasterAppUser.cRUDOnCourses();
                break;
            case 4:
                MasterAppUser.cRUDOnAssignments();
               break;
            case 5:
                MasterAppUser.cRUDOnStudentCourses();
                break;
            case 6:
                MasterAppUser.cRUDOnTrainersCourses(); 
                break;
            case 7:
                MasterAppUser.cRUDOnAssignments();
                break;
         
        default:
        System.out.println("You didn't pressed something from your choices.Try again!");
        MasterAppUser.callMastersMethods();   
            
        
         }           
       }
     }
    
    public static void cRUDOnAssignments(){
       PrintMenu.printAssignmentCRUDMenu();
       AssignmentDaoBootcamp adb=new AssignmentDaoBootcamp();
       StudentCourseDaoBootcamp uca=new StudentCourseDaoBootcamp();
       StudentAssignmentDaoBootcamp sadb= new StudentAssignmentDaoBootcamp();
       MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
               master.callMastersMethods();
               break;
            case 1:
                Course course=CRUDSchoolUtils.selectCourseByIdToPutAssignemnt();
                Assignment assingnment=CRUDSchoolUtils.createAnAssignment(course);
                adb.insertAssignment(course, assingnment);
                break;
            case 2:
                System.out.println(adb.getAllAssignments());
                break;
            case 3:
                CRUDSchoolUtils.updateAssignment();        
                break;
            case 4:
                CRUDSchoolUtils.selectStudenttoPutIntoUserAssignment();
                break;
            case 5:
                TeacherAppUser tau=new TeacherAppUser();
                tau.viewAllAssignmentPerStudentPerCourse();
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnAssignments();    
            }
            MasterAppUser.cRUDOnAssignments();  
        }
         }
    
    public static void cRUDOnCourses(){
        PrintMenu.printCourseCRUDMenu();
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
         MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
               master.callMastersMethods();
               break;
            case 1:
                Course course=CRUDSchoolUtils.createACourse();
                cdb.insertCourse(course);                  
                break;
            case 2:
                System.out.println(cdb.getAllCourses());
                break;
            case 3:
                CRUDSchoolUtils.updateCourse();        
                break;
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnCourses();    
            }
            MasterAppUser.cRUDOnCourses();   
        }
       
    
    
    }
    
    public static void cRUDOnTeachers(){
        PrintMenu.printTrainersCRUDMenu();
        TeacherDaoBootcamp tdb= new TeacherDaoBootcamp();
        MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
               master.callMastersMethods();
               break;
            case 1:
                User user=CRUDSchoolUtils.createAUser();
                tdb.insertTeacher(user); 
                break;
            case 2:
                System.out.println(tdb.getAllTeachers());
                break;
            case 3:
                CRUDSchoolUtils.updateTeacher();
                break;
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnTeachers();
            }
            MasterAppUser.cRUDOnTeachers();
        }
     }  
    
    
     
    public static void cRUDOnStudents(){
        PrintMenu.printStudentCRUDMenu();
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
               //exit=true;
               master.callMastersMethods();
               break;
            case 1:
                User user=CRUDSchoolUtils.createAUser();
                sdb.insertStudent(user);
                break;
            case 2:
                System.out.println(sdb.getAllStudents());
                break;
            case 3:
                CRUDSchoolUtils.updateStudent();
                break;
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnStudents(); 
            }
            MasterAppUser.cRUDOnStudents();
        }
     }  
    
    public static void cRUDOnStudentCourses(){
    PrintMenu.printStudentCourseCRUDMenu();
        StudentDaoBootcamp sdb=new StudentDaoBootcamp();
        MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
                master.callMastersMethods();
               break;
            case 1:
                User user=CRUDSchoolUtils.createAUser(); ;
                sdb.insertStudent(user);
                CRUDSchoolUtils.putStudentToCourseById(user);
                break;
            case 2:
                CRUDSchoolUtils.selectStudenttoPutIntoCourse();
                break;
            case 3:
                //vale methodooo!!! na pairneis olous tou mathites ana mathima
                break;
            case 4:
                CRUDSchoolUtils.selectToDeleteStudentFromACourse();
                break;
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnStudentCourses(); 
            }
            MasterAppUser.cRUDOnStudentCourses();
        }
    }
        
        
    public static void cRUDOnTrainersCourses(){
        PrintMenu.printTrainersCourseCRUDMenu();
        TeacherDaoBootcamp tdb=new TeacherDaoBootcamp();
        MasterAppUser master=new MasterAppUser();
        boolean exit=false;
        while(!exit) {
        int context=Utilities.getInt(); //ox ristis dinei tin epilogo tou. i getint elegxei an einai akaireos arithmos autos     
        switch (context) {
            case 0:
                master.callMastersMethods();
               break;
            case 1:
                User user=CRUDSchoolUtils.createAUser(); ;
                tdb.insertTeacher(user);
                CRUDSchoolUtils.putTeacherToCourseById(user);
                break;
            case 2:
                CRUDSchoolUtils.selectTeachertoPutIntoCourse();
                break;
            case 3:
                //val ti methodo!!
                break;
            case 4:
                CRUDSchoolUtils.selectToDeleteTeacherFromACourse();
                break;
            default:
                System.out.println("You didn't pressed something from your choices.Try again!");
                MasterAppUser.cRUDOnTrainersCourses(); 
            }
            MasterAppUser.cRUDOnTrainersCourses();
        }
     }
    
    
        
    
    
   }