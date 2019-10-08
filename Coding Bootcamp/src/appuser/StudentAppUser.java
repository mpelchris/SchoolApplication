/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appuser;

import schoolmodel.User;
import views.PrintMenu;

/**
 *
 * @author christy
 */
public class StudentAppUser {
   
    public void callStudentsMethods(User user){
        System.out.println("You are a student");
        PrintMenu.printStudentsAppUserMainMenu();
        
    }
    
}
