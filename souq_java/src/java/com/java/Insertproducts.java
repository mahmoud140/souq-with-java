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
 * @author Noha
 */
public class Insertproducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // PreparedStatement stmt = null;

        boolean found = false;
        Statement stmt = null;
        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_souq", "postgres", "root");

            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String category = request.getParameter("category");
            String photo = request.getParameter("photo");
            int amount = Integer.parseInt(request.getParameter("amount"));
            String Description = request.getParameter("description");

            //    String query = "insert into items values (?,?,?,?,?,?)";  
            String search = "select item_name from items";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(search);
            while (rs.next()) {
                if (name.equals(rs.getString(1))) {
                    found = true;

                }
            }
            if (!found) {
              
                String query = "insert into items(item_name,item_price,item_category,avilable_amount,photo_url,description) values ('" + name + "','" + price + "','" + category + "','" + amount + "','" + photo + "','" + Description + "')";
                stmt = con.createStatement();
                int i = stmt.executeUpdate(query);
                out.println(stmt);
              
               // out.println("<html><body><p>product inserted successfully :D'</p></body></html>");
                 response.sendRedirect("deletesuccess.jsp");
            }
            if (found) {
            
              // out.println("<html><body><p>product arealy existed </p></body></html>");
                 response.sendRedirect("deletefail.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Insertproducts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insertproducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
