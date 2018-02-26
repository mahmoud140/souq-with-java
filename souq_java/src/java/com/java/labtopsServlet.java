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
@WebServlet(name = "labtopsServlet", urlPatterns = {"/notlogin/labtopsServlet"})
public class labtopsServlet extends HttpServlet {
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
        conn = (Connection) request.getServletContext().getAttribute("conn");
       

        try {
            pst = conn.prepareStatement("select * from items where item_category like 'labtops'");
            rs = pst.executeQuery();
            request.getRequestDispatcher("SouqHeader.html").include(request, response);
            pt.println("<div align=\"center\">\n"
                + "   <form method=\"get\" action=\"MainForUser\">");
            while (rs.next()) {
                pt.println(" <img height=\"100px\"src=\"" + rs.getString(6) + "\"/>\n"
                        + "    <br>\n"
                        + "    <h3>" + rs.getString(2) + "</h3>\n" + "<h2>price:"+ rs.getString(3)+"</h2>" 
                        + "    <br>\n"
                        + "    <select name=\"" + rs.getString(2) + "\">\n"
                        + "        <option value=\"0\">0</option>\n"
                        + "        <option value=\"1\">1</option>\n"
                        + "        <option value=\"2\">2</option>\n"
                        + "        <option value=\"3\">3</option>\n"
                        + "        <option value=\"4\">4</option>\n"
                        + "        <option value=\"5\">5</option>\n"
                        + "    </select><br><br>");
            }
              pt.println("<input type=\"submit\" value=\"go\" > </form>\n"
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
