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
public class Account {
    private String id;
    private String pass;
    private String type;
    private String gender;
    private String org;
    //register
    public Account(String i, String p, String g,String t, String o)
    {
        id = i;
        pass = p;
        gender = g;
        type = t;
        org = o;
    }
       
        
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getOrg() {
        return org;
    }

    public String getGender() {
        return gender;
    }
    
}
