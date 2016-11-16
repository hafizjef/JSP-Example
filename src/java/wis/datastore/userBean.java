/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wis.datastore;

import java.io.Serializable;

public class userBean implements Serializable {
    
    private int id;
    private String name;
    private boolean IsAdmin;
    
    public userBean(){
        this.name = "";
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setIsAdmin(int isAdmin){
        this.IsAdmin = isAdmin==1;
    }
    
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean getIsAdmin(){
        return IsAdmin;
    }
}
