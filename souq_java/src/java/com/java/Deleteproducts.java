package com.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sun com
 */
public class Deleteproducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean found = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_souq", "postgres", "root");
            String name = request.getParameter("name");
            //check if product is existing or not 

            String search = "select item_name from items";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(search);
            while (rs.next()) {
                if (name.equals(rs.getString(1))) {
                    found = true;

                }
            }
            if (found) {
                String query = "delete from items where item_name ='" + name + "' ";
                PreparedStatement ps = con.prepareStatement(query);
                ps.executeUpdate();

               //out.println("<html><body><p>product deleted successfully :D'</p></body></html>"); 
                response.sendRedirect("deletesuccess.jsp");
            }
            if (!found) {
                
               //  out.println("<html><body><p>product not found</p></body></html>");
                 response.sendRedirect("deletefail.jsp");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Deleteproducts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Deleteproducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
