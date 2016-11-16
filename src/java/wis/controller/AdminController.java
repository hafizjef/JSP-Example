/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wis.controller;

import wis.utils.FlashMessage;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wis.datastore.userBean;
import wis.utils.DBConnection;

/**
 *
 * @author Falcon
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        String user;
        try { user = session.getAttribute("userRole").toString(); }
        catch (Exception ex) { user = ""; }
        
        try {
            switch (user) {
                case "user-admin":
                    
                    DBConnection db = new DBConnection(request.getServletContext());
                    List<userBean> users = db.getUsers();
                    request.setAttribute("users", users);
                    
                    RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/admin-panel.jsp");
                    view.forward(request, response);
                    break;
                case "user-user":
                    response.sendRedirect("manage");
                    break;
                default:
                    request.getSession().invalidate();
                    FlashMessage.createWarnMessage(request.getSession(), "You are not logged in<br>Please login again", "Invalid Session");
                    response.sendRedirect("");
                    break;
            }
        } catch (IOException | ServletException r) {}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
