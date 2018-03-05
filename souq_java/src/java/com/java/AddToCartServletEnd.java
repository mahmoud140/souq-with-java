/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "AddToCartServletEnd", urlPatterns = {"/notlogin/AddToCartServletEnd"})
public class AddToCartServletEnd extends HttpServlet {

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

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        conn = (Connection) request.getServletContext().getAttribute("conn");
        try {
            pst = conn.prepareStatement("select trans_id from transactions where user_id=? and item_id=? and trans_state like 'waiting' ");
            pst.setInt(1, user_id);
            pst.setInt(2, item_id);
            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    pst = conn.prepareStatement("update transactions set amount=? where user_id=? and item_id=?");
                    pst.setInt(1, amount);
                    pst.setInt(2, user_id);
                    pst.setInt(3, item_id);
                    pst.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    pst = conn.prepareStatement("insert into transactions(user_id,item_id,trans_state,amount) values(?,?,?,?)");
                    pst.setInt(1, user_id);
                    pst.setInt(2, item_id);
                    pst.setString(3, "waiting");
                    pst.setInt(4, amount);
                    pst.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                pst = conn.prepareStatement("delete from transactions where amount=0");
                pst.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("UserCartServlet");

        } catch (SQLException ex) {
            Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
        }

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
