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
@WebServlet(name = "BuyServlet", urlPatterns = {"/notlogin/BuyServlet"})
public class BuyServlet extends HttpServlet {

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
        PrintWriter pt=response.getWriter();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int one_item_price = 0;
        int user_budget = 0;
        int cost = 0;
        int avilable_amount=0;
        conn = (Connection) request.getServletContext().getAttribute("conn");
        try {
            pst = conn.prepareStatement("select trans_id from transactions where user_id=? and item_id=?");
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
            //response.sendRedirect("MainForUser");

            //////////////////////////////////Actualy Buying/////////////////////////////////////////////////////
                           
            try {
                pst = conn.prepareStatement("select * from items where item_id=?");
                pst.setInt(1, item_id);
                rs = pst.executeQuery();
                rs.next();
                one_item_price = rs.getInt(3);
                avilable_amount= rs.getInt(5);

            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst = conn.prepareStatement("select * from users where user_id=?");
                pst.setInt(1, user_id);
                rs = pst.executeQuery();
                rs.next();
                user_budget = rs.getInt(5);
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
            }
            cost = amount * one_item_price;
            if (cost < user_budget && (avilable_amount-amount)>=0) {
                
                user_budget = user_budget - cost;
                //deleting from cart
                try {
                    pst = conn.prepareStatement("delete from transactions where user_id=? and item_id=? ");
                    pst.setInt(1, user_id);
                    pst.setInt(2, item_id);
                    pst.execute();
                    
                
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
                //decreasing user budget
                try {
                    pst = conn.prepareStatement("update users set user_budget=? where user_id=? ");
                    pst.setInt(1, user_budget);
                    pst.setInt(2, user_id);
                    pst.execute();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
                //decreasing the avilable amount
                try {
                    pst = conn.prepareStatement("update items set avilable_amount=avilable_amount-? where item_id=? ");
                    pst.setInt(1, amount);
                    pst.setInt(2, item_id);
                    pst.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("MainForUser");
            }
        else{
               request.getRequestDispatcher("/SouqHeader.html").include(request, response);
                pt.println("<div align=\"center\">"
                        +"<form actiom=\"UserCartServlet\">"
                        + "<h1>Sorry we can't continue the transaction<br>"
                        + "Your budget is lower than the cost</h1><br>"
//                        + "<input type=\"hidden\" name=\"item_id\" value=\""+request.getParameter("item_id")+"\">"
//                        + "<input type=\"hidden\" name=\"user_id\" value=\""+request.getParameter("user_id")+"\">"
//                        + "<input type=\"hidden\" name=\"amount\" value=\""+request.getParameter("amount")+"\">"
//                        + "<input type=\"submit\" value=\"Back\">"
                        + "</form>"
                        + "</div>");
            
        }

        } catch (SQLException ex) {
            Logger.getLogger(AddToCartServletEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
         request.getRequestDispatcher("/SouqFooter.html").include(request, response);
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
