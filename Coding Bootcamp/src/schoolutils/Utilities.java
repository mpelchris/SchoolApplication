/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolutils;

import java.util.Scanner;

/**
 *
 * @author christy
 */
public class Utilities {
       //Method that gets String from input. Returns the String trimmed
    public static String getString() {
        Scanner scanner= new Scanner(System.in);
        return scanner.next().trim();
    }
   //Method that gets an input from the console. This method tests if the input is
   //an Int. If it is not it asks for an other input.
    public static int getInt() {
        Scanner scanner= new Scanner(System.in);
        Integer x  = TryParseInt(scanner.next().trim());
        if(x == null){
            System.out.println("mi eguros akeraios arithmos. Dokimaswe xana.");
            return getInt();
        }
        else
            return x;
    }
    
    public static int getInt(String errorMessage) {
        Scanner scanner= new Scanner(System.in);
        Integer x  = TryParseInt(scanner.next().trim());
        if(x == null){
            System.out.println(errorMessage);
            return getInt(errorMessage);
        }
        else
            return x;
    }
    
    private static Integer TryParseInt(String someText) {
        try {
           return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
           return null;
        }
    }
    
    
}
