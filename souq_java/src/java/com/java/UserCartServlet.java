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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
@WebServlet(name = "UserCartServlet", urlPatterns = {"/notlogin/UserCartServlet"})
public class UserCartServlet extends HttpServlet {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    ResultSet rs1;

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
        int item_id;
        int amount = 0;
        int max_amount = 0;
        try {
            pst = conn.prepareStatement("select * from transactions where user_id=? ");
            pst.setInt(1, user_id);
            rs = pst.executeQuery();
            pt.println("<table align=\"left\">");
            while (rs.next()) {
                amount = rs.getInt(6);
                item_id = rs.getInt(3);

                try {
                    pst = conn.prepareStatement("select * from items where item_id=? ");
                    pst.setInt(1, item_id);
                    rs1 = pst.executeQuery();
                    rs1.next();
                    max_amount = rs1.getInt(5);
                    if (amount > max_amount) {
                        amount = max_amount;
                    }
                    if (amount > 0) {
                        pt.println("<tr><td width=\"19.5%\"><div align=\"center\">\n"
                                + "<form method=\"get\" action=\"BuyServlet\" > "
                                + "<img width=\"100px\" height=\"100px\" src=\"" + "/souq_java/" + rs1.getString(6) + "\"/>\n"
                                + "    <br>\n"
                                + "    <h3>" + rs1.getString(2) + "</h3>\n" + "<h2>&nbsp;&nbsp;&nbsp;price:" + rs1.getString(3) + "&nbsp;&nbsp;&nbsp;</h2>"
                                + "select the amount : <input type=\"number\" min=\"0\" required name=\"amount\" value=\"" + amount + "\" max=\"" + rs1.getInt(5) + "\">"
                                + "<input type=\"hidden\" name=\"item_id\" value=\"" + item_id + "\">"
                                + "<input type=\"hidden\" name=\"user_id\" value=\"" + user_id + "\">"
                                + "<input type=\"submit\" value=\"Buy\" height=\"10px\"> </form><br>"
                                + "<form method=\"get\" action=\"CancelBuyServlet\" >"
                                + "<input type=\"hidden\" name=\"item_id\" value=\"" + item_id + "\">"
                                + "<input type=\"hidden\" name=\"user_id\" value=\"" + user_id + "\">"
                                + "<input type=\"submit\" value=\"Cancel\" height=\"10px\"> </form><br><br>"
                                + "</div> </td>"
                                + "<td width=\"80.5%\"><div align=\"center\">" + rs1.getString(7) + "</div></td></tr>");
                    }else{
                        try{
                         pst = conn.prepareStatement("delete from transactions where user_id=? and item_id=? ");
                         pst.setInt(1, user_id);
                         pst.setInt(2, item_id);
                         pst.executeQuery();
                        }catch (SQLException ex) {
                        }
                    }
                } catch (SQLException ex) {
                }
            }
            pt.println("</table>");
            request.getRequestDispatcher("/SouqFooter.html").include(request, response);
        } catch (SQLException ex) {
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
