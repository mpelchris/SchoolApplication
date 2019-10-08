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
import dao.TeacherCourseDaoBootcamp;
import dao.TeacherDaoBootcamp;
import java.util.List;
import schoolmodel.Assignment;
import schoolmodel.Course;
import schoolmodel.User;
import schoolutils.Utilities;
import views.PrintMenu;

/**
 *
 * @author christy
 */
public class TeacherAppUser {

    
    
    public static void callTeachersMainMethods(User user){
        PrintMenu.printTeachersAppUserMainMenu();
        boolean exit=false;
        while(!exit){
        int context=Utilities.getInt();
         switch (context) {
            case 0:
                exit=true;   
                break;
            case 1:
                TeacherAppUser.viewTheTeachersCourses(user);
                break;
            case 2:
                TeacherAppUser.callTeachersMethods();
              break;
            default:
                System.out.println("You didn't pressed something.Plesse try again");
                PrintMenu.printTeachersAppUserMainMenu();
           }}
       } 
    
     public static void callTeachersMethods(){
        PrintMenu.printTeachersMainMenu();
        boolean exit=false;
        while(!exit){
        int context=Utilities.getInt();
         switch (context) {
            case 0:
                exit=true;   
                break;
            case 1:
                TeacherAppUser.viewAllStudentsPerCourse();
              break;
//            case 2:
//                 TeacherAppUser tau=new TeacherAppUser();
//                tau.viewAllAssignmentPerStudentPerCourse();
//                break;
//            case 3:
//                TeacherAppUser.MarkAllAssignmentPerStudentPerCourse();
//               break;
               default:
                System.out.println("You didn't pressed something.Plesse try again");
                PrintMenu.printTeachersMainMenu();
               
         }}
       } 
    
        
    private static void viewTheTeachersCourses(User user) {
        int teacherid=user.getId();
        TeacherCourseDaoBootcamp tcdb= new TeacherCourseDaoBootcamp();
       List <Course> courselist=tcdb.getCoursesByTeachersId(teacherid);
       if(courselist==null){
           System.out.println("You do not enrole to any course ");
       }else{
       System.out.println("The course that you enrole are the:");
        System.out.println(tcdb.getCoursesByTeachersId(teacherid));
       }
        
        TeacherAppUser.callTeachersMainMethods(user); 
                
   
    }

    private static void viewAllStudentsPerCourse() {
        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
        StudentCourseDaoBootcamp scdb=new StudentCourseDaoBootcamp();
        System.out.println("The students per course are:");
        List <Course> courselist= cdb.getAllCourses();
        if (cdb.getAllCourses()==null){
            System.out.println("There are no courses");
       }else{
        for(int i=0;i<courselist.size();i++){
            System.out.println((i+1)+") The student "+scdb.getAllStudentsByCourseId(courselist.get(i))+", has the course "+courselist.get(i)); 
        } }
    }

    
//    public void viewAllAssignmentPerStudentPerCourse() {
//        CourseDaoBootcamp cdb=new CourseDaoBootcamp();
//        StudentCourseDaoBootcamp scdb=new StudentCourseDaoBootcamp();
//        StudentAssignmentDaoBootcamp sadb=new  StudentAssignmentDaoBootcamp();
//        System.out.println("The assignments per course per student are:");
//        List <Course> courselist= cdb.getAllCourses();
//        if (cdb.getAllCourses()==null){
//            System.out.println("There are no courses");
//       }else{
//            for(int i=0;i<courselist.size();i++){
//            List <User> usersofcourselist=  scdb.getAllStudentsByCourseId(courselist.get(i));
//                if(usersofcourselist==null){
//                System.out.println("There are no students that enrole to any course");
//                }else{
//                    for(int j=0;j<usersofcourselist.size();j++){
//                        if(usersofcourselist.get(j)==null){
//                        System.out.println("This student has no assignment.Select Other thing to do.");
//                        TeacherAppUser.callTeachersMethods(); 
//                     
//                  }else if(sadb.getAllAssignmentsByuserid(usersofcourselist.get(j))==null){
//                   System.out.println("This student has no assignment.Select Other thing to do.");
//                        TeacherAppUser.callTeachersMethods(); 
//                  }
//                  else{   
//                            System.out.println("ela");
//                System.out.println((i+1)+") The student "+scdb.getAllStudentsByCourseId(courselist.get(i))+", has the course "+courselist.get(i)+"and the assignments of the student are"+sadb.getAllAssignmentsByuserid(usersofcourselist.get(j)));
//                  }
//                       
//                } TeacherAppUser.callTeachersMethods(); 
//        }}}
//        
//        
//    }
//
//    private static void MarkAllAssignmentPerStudentPerCourse() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
        
        
    
}
