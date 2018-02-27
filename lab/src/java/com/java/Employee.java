/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Mahmoud
 */
@Path("/employee")
public class Employee {

    Connection conn;

    public Employee() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/souq", "postgres", "iti");
    }

    @GET
    public void create(@QueryParam("name") String uname) throws SQLException
    {
        System.out.println("((((((((((((((((((("+uname);
        String query = "insert into users (uname) values (?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, uname);
//        stmt.setString(2, password);
        stmt.executeUpdate();
    }
    
//    public String sayHello() {
//
//        return "hello";
//    }

//    @POST
//    public String retrive(@FormParam("name") String uname) {
//        String str = "";
//        try {
//            String query = "select * from users where uname='" + uname + "'";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            int i = 0;
//            while (rs.next()) {
//                i++;
//                str = str + " " + rs.getString(i);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return str;
//    }

//    @GET
//    public void delete(@QueryParam("name") String uname) throws SQLException {
//        String query = "delete  from users where uname = ?";
//        PreparedStatement stmt = conn.prepareStatement(query);
//        stmt.setString(1, uname);
//        stmt.execute();
//    }

    @POST
    public void edit(@FormParam("name") String uname, String password) throws SQLException {
        String query = "update users set password = ? where uname=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, "123");
        stmt.setString(1, "admin");
        stmt.executeUpdate();
    }
}
