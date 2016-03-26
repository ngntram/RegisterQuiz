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
import java.sql.*;
public class AccountCreator {
    
    public static void register()
    {
        Scanner input = new Scanner(System.in);
        //check id requirement
        String id = "";
        boolean validId = false;
        while(validId==false)
        {
            System.out.println("Please enter you id");
            id = input.next();
            if(id.length()>2 && id.length()<11)
            {
                if(checkIdString(id))
                {
                    validId = true;
                    break;
                }
                else
                {
                    System.out.println("id must contain 1 letter, 1 digit and 1 special char: ! or * or $ or # ");
                }
            }
            else
            {
                System.out.println("id must have 3 to 10 characters ");
            }
        }
        
        //password
        String passOne = "";
        String passTwo = "";
        boolean match = false;
        while(match==false)
        {
            System.out.println("please enter your password");
            passOne = input.next();
            System.out.println("Please re-enter the password");
            passTwo = input.next();
            if(passOne.equals(passTwo))
            {
                match = true;
                break;
            }
            else
            {
                System.out.println("the password does not match");
            }
        }
        
        //gender
        String gender = "";
        while(!(gender.equals("f") || gender.equals("m")))
        {
            System.out.println("Please enter your gender");
            System.out.println("f: for female");
            System.out.println("m: for male");
            gender = input.next().toLowerCase();
        }
        //type
        
        System.out.println("Are you an Employer? Enter y for yes, any key for no");
        String isEmployer = input.next().toLowerCase();
        String type = "";
        if(isEmployer.equals("y"))
        {
            type = "employer";
        }
        else
        {
            type = "regular";
        }
        
        //organization
        System.out.println("Please enter your company/organization/school");
        String org = input.next();
        
        //check id in database
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DATABASE_URL ="jdbc:mysql://mis-sql.uhcl.edu/nguyent2771";
        try
        {
            con = DriverManager.getConnection(DATABASE_URL,"nguyent2771","1409417");
            stat = con.createStatement();
            rs = stat.executeQuery("select * from linkedIn_account where id = '"+id+"'");        
            if(rs.next())
            {
                System.out.println("this account is already existed. Please choose another name");
            }
            else
            {
                //int i = stat.executeUpdate("insert into linkedIn_account values('"+"')");
                System.out.println("New account was created");
            }
       }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
                stat.close();
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void login()
    {
        Scanner input = new Scanner(System.in);
        String id = "";
        String pass = "";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        final String DATABASE_URL ="jdbc:mysql://mis-sql.uhcl.edu/nguyent2771";
        
        System.out.println("please enter your id");
        id = input.next();
        System.out.println("please enter your password");
        pass = input.next();
        try
        {
            con = DriverManager.getConnection(DATABASE_URL,"nguyent2771","1409417");
            stat = con.createStatement();
            rs = stat.executeQuery("select * from linkedIn_account where id = '"+id+"'");        
            if(rs.next())
            {
                if(rs.getString("pass").equals(pass))
                {
                    System.out.println("login sucessfully");
                }
                else
                {
                    System.out.println("in-correct password");
                }
            }
            else
            {

                System.out.println("in-correct id name");
            }
       }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
                stat.close();
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
            
    private static boolean checkIdString(String id)
    {
        boolean haveSpecialChar = false;
        if(!id.matches("[a-zA-Z0-9]*")) //not all letters in a string
        {
            if(id.matches(".*\\d.*")) //match any digit
            {
                for(int i = 0;i<id.length();i++)
                {
                    if(id.charAt(i)=='#'||id.charAt(i)=='!'||id.charAt(i)=='*'||id.charAt(i)=='$')
                    {
                        haveSpecialChar = true;
                        break;
                    }
                }
            }
        }
        
        if(haveSpecialChar==false)
        {
            return false;
        }
        return true;
    }
    
    
}
