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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class DBClass {

    Connection conn;
    Vector<String> players_name = new Vector<String>();
    boolean vaild = true;

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

    public void edit(String uName, int uBudget) {
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

    public boolean vaild(String uName) throws SQLException {
        try {
            String query = "select user_name from users";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                players_name.add(rs.getString(1));
            }
            for (String s : players_name) {
                if (uName.equals(s)) {
                    vaild = false;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vaild;
    }

    public ResultSet bought() throws SQLException {
        ResultSet rs;

        String query = "select user_name,item_name,trans_date,amount from transactions t,items i,users u where u.user_id=t.user_id and i.item_id=t.item_id and trans_date is not null";
        PreparedStatement stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        return rs;
    }
    
    public void delete(String uName) throws SQLException {
        String query = "delete from users where user_name=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, uName);
        stmt.executeUpdate();
    }
}
