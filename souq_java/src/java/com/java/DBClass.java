/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class DBClass {

    Connection conn;

    public DBClass(Connection con) {
        conn = con;
    }
    PreparedStatement stmt;

    public void rForm(String uname, String pass, int ubudget, String job, String email, String address, Date birthDate) throws SQLException {
        String query = "insert into users(user_name,user_password,user_privilege,user_budget,address,birth_date,job,email) values (?,?,'user',?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, uname);
        stmt.setString(2, pass);
        stmt.setInt(3, ubudget);
        stmt.setString(4, address);
        stmt.setDate(5, birthDate);
        stmt.setString(6, job);
        stmt.setString(7, email);
        stmt.executeUpdate();
    }

    public ResultSet login(String uname, String pass) throws SQLException {
        String query = "select user_name from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public ResultSet listOfUsers() throws SQLException {
        String query = "select * from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    public void edit(String uName,int uBudget )
    {
        try {
            String query = "update users set user_budget=? where user_name=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(2, uName);
            stmt.setInt(1, uBudget);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
