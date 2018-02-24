/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
@WebServlet(name = "MainForUser", urlPatterns = {"/MainForUser"})
public class MainForUser extends HttpServlet {

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
         PrintWriter pt = response.getWriter();
        request.getRequestDispatcher("SouqHeader.html").include(request, response);
        pt.println("<html>\n"
                + "<body>\n"
                + "    <br><br>\n"
                + "    <table width=\"100%\">\n"
                + "    <tr>\n"
                + "      <td  align=\"center\"><a href=\" MobilesServlet\"><img src=\"mobile-phones.jpg\" width=\"50%\"/><br><h3>mobiles</h3> </a></td>\n"
                + "      <td  align=\"center\"><a href=\"labtopsServlet\"><img src=\"laptops.jpg\"width=\"50%\" /><br><h3>labtops</h3> </a></td>\n"
                + "    </tr>\n"
                + "    </table>\n"
                + "</body>\n"
                + "\n"
                + "</html>");
        request.getRequestDispatcher("SouqFooter.html").include(request, response);
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
