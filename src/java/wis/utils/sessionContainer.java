/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wis.utils;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Falcon
 */
public final class sessionContainer {
    
    private static HttpSession s;
    
    private static boolean isLoggedIn = false;
    private static boolean isAdmin = false;
    
    public sessionContainer(HttpSession session, boolean flag){
        isAdmin = flag;
        isLoggedIn = true;
        s = session;
    }
    
    public static boolean isAdmin(){
        return isAdmin;
    }
    
    public static boolean isLoggedIn(){
        return isLoggedIn;
    }
    
    public static void logOut(){
        isAdmin = false;
        isLoggedIn = false;
        s.invalidate();
    }
}
