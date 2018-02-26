/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet(name = "MobilesServlet", urlPatterns = {"/notlogin/MobilesServlet"})
public class MobilesServlet extends HttpServlet {
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
        response.setContentType("text/html");
        PrintWriter pt = response.getWriter();
        int i=0;
        conn = (Connection) request.getServletContext().getAttribute("conn");
       

        try {
            pst = conn.prepareStatement("select * from items where item_category like 'mobiles'");
            rs = pst.executeQuery();
            request.getRequestDispatcher("SouqHeader.html").include(request, response);
            pt.println("<div align=\"center\">\n"
                + "   <table>");
            while (rs.next()) {
                if(i==0){pt.println("<tr>");}
                i++;
                pt.println("<td item-width=\"100px\"><div align=\"center\">\n"
                        +"<form method=\"get\" action=\"AddToCartServlet\" > "
                        + "<img width=\"100px\" height=\"100px\" src=\"" + rs.getString(6) + "\"/>\n"
                        + "    <br>\n"
                        + "    <h3>" + rs.getString(2) + "</h3>\n" + "<h2>&nbsp;&nbsp;&nbsp;price:"+ rs.getString(3)+"&nbsp;&nbsp;&nbsp;</h2>" 
                        + "    <br>\n<input type=\"hidden\" name=\"choosedId\" value=\""+rs.getString(1)+"\">"
                        + "<input type=\"submit\" value=\"Add to cart\" > </form></div> </td>");
                if(i==8){i=0;pt.println("</tr>");}
            }
            if(i!=0){pt.println("</tr>");}
              pt.println("</table>\n"
                    + "  </div>");
        
        request.getRequestDispatcher("SouqFooter.html").include(request, response);
          
        } catch (SQLException ex) {
            Logger.getLogger(MobilesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
