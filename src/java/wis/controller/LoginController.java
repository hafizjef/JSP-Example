/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wis.controller;

import wis.utils.DBConnection;
import wis.utils.FlashMessage;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        String userRole = "";
        
        try {
            userRole = session.getAttribute("userRole").toString();
        } catch (Exception ex) {}
        
        if(!userRole.equals("user-admin")){
            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/login-index.jsp");
            view.forward(request, response); 
        } else {
            response.sendRedirect("cpanel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Sanitize userinput from HTML Form
        String username = Jsoup.clean(request.getParameter("username"), Whitelist.none());
        String password = request.getParameter("password");
        
        if(username.equals("") || password.equals("")){
            FlashMessage.createAlertMessage(session, "Null request", "Error");
            response.sendRedirect("");
        } else {
            DBConnection db = new DBConnection();
            try {
                
                int loginStatus = db.doLogin(username, password);
                
                switch (loginStatus) {
                    case 1:
                        session.setAttribute("userRole", "user-admin");
                        FlashMessage.createSuccessMessage(session, String.format("Logged in as <b>%s</b>", username), "Login Successfull");
                        response.sendRedirect("cpanel");
                        break;
                    case 2:
                        FlashMessage.createWarnMessage(session, "Incorrect Username/Password combination", "Authentication Error");
                        response.sendRedirect("");
                        break;
                    case 3:
                        FlashMessage.createWarnMessage(session, String.format("User <b>%s</b> not found!", username), "Authentication Error");
                        response.sendRedirect("");
                        break;
                    default:
                        FlashMessage.createAlertMessage(session, "System Error, Please contact your administrator", "Application Error");
                        response.sendRedirect("");
                        break;
                }
                
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
