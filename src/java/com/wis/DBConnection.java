/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wis;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class DBConnection {
    
    private final String url = "jdbc:mysql://localhost:3306/wis";
    private final String userName = "root";
    private final String password = "root";
    
    Connection conn = null;
    
    public String doLogin(String uname, String passw) throws NoSuchAlgorithmException, InvalidKeySpecException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            PreparedStatement pst = conn.prepareStatement("SELECT username,password FROM users WHERE username=? LIMIT 1");
            pst.setString(1, uname);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                String securePass = rs.getString("password");
                
                if(SecurityHelper.validatePassword(passw, securePass)==true){
                    return "User valid";
                } else {
                    return "User invalid";
                }
            } else {
                return "User Not Found";
            }
        } catch(SQLException | ClassNotFoundException ex){
            return "Error: " + ex.getMessage();
        }        
    }
}
