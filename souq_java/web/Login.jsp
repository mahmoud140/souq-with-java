<%-- 
    Document   : Login
    Created on : Feb 24, 2018, 11:46:12 AM
    Author     : Mahmoud
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%!
    Vector<String> players_name = new Vector<String>();
    Vector<String> players_password = new Vector<String>();
    boolean vaild = true;
%>
<%
    String uname = request.getParameter("UserName");
    String pass = request.getParameter("Password");
    Connection conn = (Connection) application.getAttribute("conn");
    String query = "select uname from users";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
        players_name.add(rs.getString(1));
    }
    for (String s : players_name) {
        if (uname.equals(s)) {
            vaild = false;
            break;
        }
    }
    if (!vaild) {
        query="select password,uprivilage from users where uname = ?";
        PreparedStatement stm=conn.prepareStatement(query);
        stm.setString(1, uname);
        ResultSet rs2 = stm.executeQuery();
        System.out.println(rs2.next());
         String password=rs2.getString("password");
         String uprivilage=rs2.getString("uprivilage");
         if(password.equalsIgnoreCase(pass)){
             if(uprivilage.equalsIgnoreCase("admin"))
             {
//                 response.getWriter().println("admin");
                 request.getSession(true);
                 response.sendRedirect("MainForAdmin.html");
             }
             else{
                 request.getSession(true);
                 response.sendRedirect("MainForUser.html");
             }
         }
    } else {
        response.sendRedirect("LoginFail.jsp");
    }
%>
