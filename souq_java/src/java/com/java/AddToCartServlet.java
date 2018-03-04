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
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/notlogin/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

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
        request.getRequestDispatcher("/SouqHeader.html").include(request, response);

        conn = (Connection) request.getServletContext().getAttribute("conn");
        int user_id = (int) request.getSession(false).getAttribute("user_id");
        int item_id = Integer.parseInt(request.getParameter("choosedId"));
        int amount = 0;
        int max_amount = 0;
        if (request.getParameter("choosedId") == null) {
            response.sendRedirect("MobilesServlet");
        } else {

            try {
                pst = conn.prepareStatement("select * from transactions where item_id=? and user_id=? and trans_state like 'waiting' ");
                pst.setInt(1, item_id);
                pst.setInt(2, user_id);
                rs = pst.executeQuery();

                if (rs.next()) {

                    amount = rs.getInt(6);

                    try {
                        pst = conn.prepareStatement("select * from items where item_id=? ");
                        pst.setInt(1, item_id);
                        rs = pst.executeQuery();
                        rs.next();
                        max_amount = rs.getInt(5);
                        if(max_amount!=0)
                        {
                        if (amount < max_amount) {
                            pt.println("<table align=\"left\"><tr><td width=\"19.5%\"><div align=\"center\">\n"
                                    + "<form method=\"get\" action=\"AddToCartServletEnd\" > "
                                    + "<img width=\"100px\" height=\"100px\" src=\"" + "/souq_java/" + rs.getString(6) + "\"/>\n"
                                    + "    <br>\n"
                                    + "    <h3>" + rs.getString(2) + "</h3>\n" + "<h2>&nbsp;&nbsp;&nbsp;price:" + rs.getString(3) + "&nbsp;&nbsp;&nbsp;</h2>"
                                    + "select the amount : <input type=\"number\" min=\"0\" required name=\"amount\" value=\"" + amount + "\" max=\"" + rs.getInt(5) + "\">"
                                    + "<input type=\"hidden\" name=\"item_id\" value=\"" + item_id + "\">"
                                    + "<input type=\"hidden\" name=\"user_id\" value=\"" + user_id + "\">"
                                    + "<input type=\"submit\" value=\"OK\" height=\"10px\"> </form></div> </td>"
                                    + "<td width=\"80.5%\"><div align=\"center\">" + rs.getString(7) + "</div></td></tr></table>");
                        } else {
                            pt.println("<table align=\"left\"><tr><td width=\"19.5%\"><div align=\"center\">\n"
                                    + "<form method=\"get\" action=\"AddToCartServletEnd\" > "
                                    + "<img width=\"100px\" height=\"100px\" src=\"" + "/souq_java/" + rs.getString(6) + "\"/>\n"
                                    + "    <br>\n"
                                    + "    <h3>" + rs.getString(2) + "</h3>\n" + "<h2>&nbsp;&nbsp;&nbsp;price:" + rs.getString(3) + "&nbsp;&nbsp;&nbsp;</h2>"
                                    + "select the amount : <input type=\"number\" min=\"0\" required name=\"amount\" value=\"" + max_amount + "\" max=\"" + rs.getInt(5) + "\">"
                                    + "<input type=\"hidden\" name=\"item_id\" value=\"" + item_id + "\">"
                                    + "<input type=\"hidden\" name=\"user_id\" value=\"" + user_id + "\">"
                                    + "<input type=\"submit\" value=\"OK\" height=\"10px\"> </form></div> </td>"
                                    + "<td width=\"80.5%\"><div align=\"center\">" + rs.getString(7) + "</div></td></tr></table>");
                        }
                        }
                    } catch (SQLException ex) {
                    }
                } else {

                    try {
                        pst = conn.prepareStatement("select * from items where item_id=? ");
                        pst.setInt(1, item_id);
                        rs = pst.executeQuery();
                        rs.next();
                        System.out.println(rs.getString(1));
                        pt.println("<table align=\"left\"><tr><td width=\"19.5%\"><div align=\"center\">\n"
                                + "<form method=\"get\" action=\"AddToCartServletEnd\" > "
                                + "<img width=\"100px\" height=\"100px\" src=\"" + "/souq_java/" + rs.getString(6) + "\"/>\n"
                                + "    <br>\n"
                                + "    <h3>" + rs.getString(2) + "</h3>\n" + "<h2>&nbsp;&nbsp;&nbsp;price:" + rs.getString(3) + "&nbsp;&nbsp;&nbsp;</h2>"
                                + "select the amount : <input type=\"number\" min=\"0\" required name=\"amount\"max=\"" + rs.getInt(5) + "\">"
                                + "<input type=\"hidden\" name=\"item_id\" value=\"" + item_id + "\">"
                                + "<input type=\"hidden\" name=\"user_id\" value=\"" + user_id + "\">"
                                + "<input type=\"submit\" value=\"OK\" height=\"10px\"> </form></div> </td>"
                                + "<td width=\"80.5%\"><div align=\"center\">" + rs.getString(7) + "</div></td></tr></table>");
                    } catch (SQLException ex) {
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

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
