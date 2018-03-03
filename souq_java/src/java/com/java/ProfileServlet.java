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
import javax.websocket.Session;

/**
 *
 * @author Mohamed
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/notlogin/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
        PrintWriter pt = response.getWriter();
        conn = (Connection) request.getServletContext().getAttribute("conn");
        int user_id = (int) request.getSession(false).getAttribute("user_id");
        try {
            pst = conn.prepareStatement("select * from users where user_id=?");
            pst.setInt(1, user_id);
            rs = pst.executeQuery();
            rs.next();
            request.getRequestDispatcher("/SouqHeader.html").include(request, response);

            pt.println("<style>#customers {\n"
                    + "            font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n"
                    + "            border-collapse: collapse;\n"
                    + "            width: 50%;\n"
                    + "        }\n"
                    + "\n"
                    + "        #customers td, #customers th {\n"
                    + "            border: 1px solid #ddd;\n"
                    + "            padding: 10px;\n"
                    + "            text-align: center;\n"
                    + "            width: 30;\n"
                    + "        }\n"
                    + "\n"
                    + "        #customers tr:nth-child(even){background-color: #f2f2f2;}\n"
                    + "\n"
                    + "        #customers tr:hover {background-color: #ddd;}\n"
                    + "\n"
                    + "        #customers th {\n"
                    + "            padding-top: 12px;\n"
                    + "            padding-bottom: 12px;\n"
                    + "            text-align: left;\n"
                    + "            background-color: #4CAF50;\n"
                    + "            color: white;\n"
                    + "            text-align: center;\n"
                    + "        }</style>"
                    +"<div align=\"center\">\n"
                    + "    <br><br><img width=\"100px\" height=\"100px\" src=\"/souq_java/blank.jpeg\" /><br>\n"
                    + "    <h2>"+rs.getString(2)+"</h2>\n"
                    + "</div>\n"
                    + "<br><br>\n"
                    + "<div align=\"center\">\n"
                    + "\n"
                    + "<table id=\"customers\">\n"
                    + "    <tr><td>budget: </td><td>"+rs.getString(5)+"</td></tr>\n"
                    + "    <tr><td>address: </td><td>"+rs.getString(6)+"</td></tr>\n"
                    + "    <tr><td>job: </td><td>"+rs.getString(8)+"</td></tr>\n"
                    + "    <tr><td>birth date: </td><td>"+rs.getString(7)+"</td></tr>\n"
                    + "    <tr><td>email: </td><td>"+rs.getString(9)+"</td></tr>\n"
                    + "</table><br>\n"
                    + "\n"
                    +"<form method='get' action='EditProfileServlet'>"
                    + "<input type='hidden' name='user_id' value='"+user_id+"'><br>"
                    + "<input type='submit' value='Edit'></form>"
                    + "</div>"
                    );
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
