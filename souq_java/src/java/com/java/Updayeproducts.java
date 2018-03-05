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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Noha
 */
//@WebServlet(name = "Deleteproducts ", urlPatterns = {"/Deleteproducts"})
public class Updayeproducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PreparedStatement stmt;
        boolean found = false;

        try {
            // Class.forName("org.postgresql.Driver");
            //   DriverManager.registerDriver(new org.postgresql.Driver());
            Connection con = (Connection) request.getServletContext().getAttribute("conn");
            // Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_souq", "postgres", "root");

            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String category = request.getParameter("category");
            int amount = Integer.parseInt(request.getParameter("amount"));
            String photo = request.getParameter("photo");
            String Description = request.getParameter("description");
            
            
            String search = "select item_name from items";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(search);
           
            while (rs.next()) {
                if (name.equals(rs.getString(1))) {
                    found = true;

                }
            }
            if (found) {

                String query2 = "update items set item_price='" + price + "',item_category='" + category + "',avilable_amount='" + amount + "', photo_url='" + photo + "',description='" + Description + "' where item_name='" + name + "'";
                stmt = con.prepareStatement(query2);

                stmt.executeUpdate();

                response.sendRedirect("deletesuccess.jsp");
            }
            if (!found) {
               
                response.sendRedirect("deletefail.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Updayeproducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
