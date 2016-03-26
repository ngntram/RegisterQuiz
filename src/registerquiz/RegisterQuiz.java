/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerquiz;

/**
 *
 * @author Tram
 */
import java.util.Scanner;
public class RegisterQuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to LinkedIn page");
        String choice ="";
        while(!choice.equals("x"))
        {
            System.out.println("Please select your choice");
            System.out.println("1-Register");
            System.out.println("2-Login");
            System.out.println("x-Exit");
            choice=input.next();
            
            if(choice.equals("1"))
            {
                AccountCreator.register();
            }
            else if(choice.equals("2"))
            {
                AccountCreator.login();
            }
        }
        
    }
    
}
