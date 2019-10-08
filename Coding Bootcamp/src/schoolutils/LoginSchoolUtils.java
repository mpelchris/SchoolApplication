/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolutils;

import appuser.MasterAppUser;
import appuser.StudentAppUser;
import appuser.TeacherAppUser;
import com.sun.xml.internal.bind.v2.TODO;
import dao.UserDaoBootcamp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import schoolmodel.User;

/**
 *
 * @author christy
 */
public class LoginSchoolUtils {
    
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    public void giveUsernameAndPassword() {
       
       LoginSchoolUtils lsu=new LoginSchoolUtils();
       System.out.println("Pleese give your username to log in");
       Scanner sc=new Scanner(System.in);
       String username= sc.next();
       User user=lsu.compareUsernameWithDataBase(username);
       lsu.comparePasswordWithDataBase(user);
       lsu.selectAppUserByRoleId(user);
        }
    
    //Take the roleid from the user   //check out whitch AppUser is Loging!
    public void selectAppUserByRoleId(User user){ 
        int roleid= user.getRoleid();
        switch(roleid) {
            case 1:
               MasterAppUser master=new MasterAppUser();
               master.callMastersMethods();
                break;
            case 2:
                TeacherAppUser teacher=new TeacherAppUser();
                teacher.callTeachersMainMethods(user);
                break;
            case 3: 
                StudentAppUser student=new StudentAppUser();
                student.callStudentsMethods(user);
        }
    }
    
    public User compareUsernameWithDataBase(String username){
    UserDaoBootcamp udb=new UserDaoBootcamp();
    LoginSchoolUtils lsu=new LoginSchoolUtils();
    User user= udb.getUserByUsername(username);
    if(user==null){
        System.out.println("Wrong username");
        lsu.giveUsernameAndPassword();
        return null;
      } else{
            System.out.println("Username ok!");
            return user;
        }
    }
    
    public void comparePasswordWithDataBase(User user){
       LoginSchoolUtils lsu=new LoginSchoolUtils(); 
       String algorithm="SHA-256";
       System.out.println("Pleese give your password");
       String password= Utilities.getString();
       String hashed_password=generateHash(password,algorithm);
       if(user.getPassword().equals(hashed_password)){
            System.out.println("log in ok");
      } else {   //na min uparxei to user name
            System.out.println("no log in");
            lsu.comparePasswordWithDataBase(user);
        }
    }
    
    public static String generateHash(String password,String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.reset();
            byte[] hash= digest.digest(password.getBytes());
            return bytesToStringHex(hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginSchoolUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
     }    
    
}
