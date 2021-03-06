/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
@WebServlet(name = "EndEditServlet", urlPatterns = {"/notlogin/EndEditServlet"})
public class EndEditServlet extends HttpServlet {
    
     Connection conn;
    PreparedStatement pst;
    ResultSet rs;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pt=response.getWriter();
        conn = (Connection) request.getServletContext().getAttribute("conn");

        try {
                    pst = conn.prepareStatement("update users set user_budget=? , address=? , job=? , email=? , birth_date=? , user_password-? where user_id=? ");
                    pst.setInt(1,Integer.valueOf(request.getParameter("budget")));
                    pst.setString(2,request.getParameter("address"));
                    pst.setString(3,request.getParameter("job"));
                    pst.setString(4,request.getParameter("email"));
                    pst.setDate(5,Date.valueOf(request.getParameter("birthDate")));
                    pst.setString(6,request.getParameter("password"));
                    pst.setInt(7,(int) request.getSession(false).getAttribute("user_id"));
                    pst.execute();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
        response.sendRedirect("ProfileServlet");
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
