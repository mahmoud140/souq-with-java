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
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/notlogin/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

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
        int user_id = (int) Integer.valueOf(request.getParameter("user_id"));
        try {
            pst = conn.prepareStatement("select * from users where user_id=?");
            pst.setInt(1, user_id);
            rs = pst.executeQuery();
            rs.next();
            request.getRequestDispatcher("/SouqHeader.html").include(request, response);
            pt.println("<style>"
                    + "      \n"
                    + "            input[type=number] {\n"
                    + "    width: 50%;\n"
                    + "    box-sizing: border-box;\n"
                    + "    border: 2px solid #ccc;\n"
                    + "    border-radius: 4px;\n"
                    + "    font-size: 16px;\n"
                    + "    background-color: white;\n"
                    + "    background-image: url('searchicon.png');\n"
                    + "    background-position: 10px 10px; \n"
                    + "    background-repeat: no-repeat;\n"
                    + "    padding: 12px 20px 12px 40px;\n"
                    + "    -webkit-transition: width 0.4s ease-in-out;\n"
                    + "    transition: width 0.4s ease-in-out;\n"
                    + "}"
                    + "#customers {\n"
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
                    + "<div align=\"center\">\n"
                    + "    <br><br><img width=\"100px\" height=\"100px\" src=\"/souq_java/blank.jpeg\" /><br>\n"
                    + "    <h2>" + rs.getString(2) + "</h2>\n"
                    + "</div>\n"
                    + "<br><br>\n"
                    + "<div align=\"center\">\n"
                    + "\n"
                    + "<form method='get' action='EndEditServlet'>"
                    + "<table id=\"customers\">\n"
                    + "    <tr><td>budget: </td><td><input type='number' name='budget' value='" + rs.getString(5) + "' min='0' required></td></tr>\n"
                    + "    <tr><td>address: </td><td><input type='text' name='address' value='" + rs.getString(6) + "' required></td></tr>\n"
                    + "    <tr><td>job: </td><td><input type='text' name='job' value='" + rs.getString(8) + "' required></td></tr>\n"
                    + "    <tr><td>birth date: </td><td><input type='text' name='birthDate' value='" + rs.getString(7) + "' required></td></tr>\n"
                    + "    <tr><td>email: </td><td><input type='text' name='email' value='" + rs.getString(9) + "' required></td></tr>\n"
                    + "    <tr><td>password: </td><td><input type='text' name='password' value='" + rs.getString(3) + "' required></td></tr>\n"
                    + "</table><br>"
                    + "<input type='submit' value='Done'></form>"
                    + "</form>\n"
                    + "\n"
                    + "</div><br><br><br>"
            );
            request.getRequestDispatcher("/SouqFooter.html").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
