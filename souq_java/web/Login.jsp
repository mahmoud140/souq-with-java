<%-- 
    Document   : Login
    Created on : Feb 24, 2018, 11:46:12 AM
    Author     : Mahmoud
--%>

<%@page import="com.java.DBClass"%>
<%@page import="java.sql.DriverManager"%>
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
    String query;
%>
<%
    String uname = request.getParameter("UserName");
    String pass = request.getParameter("Password");
    Connection conn = (Connection) request.getServletContext().getAttribute("conn");
    DBClass select =new DBClass( conn);
    ResultSet rs=select.login(uname, pass);
//    String query = "select user_name from users";
//    Statement stmt = conn.createStatement();
//    ResultSet rs = stmt.executeQuery(query);
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
        query="select user_password,user_privilege,user_id from users where user_name = ?";
        PreparedStatement stm=conn.prepareStatement(query);
        stm.setString(1, uname);
        ResultSet rs2 = stm.executeQuery();
        System.out.println(rs2.next());
         String password=rs2.getString("user_password");
         String uprivilage=rs2.getString("user_privilege");
         int id=rs2.getInt("user_id");
                          System.out.println(pass);
                          System.out.println(password);
         if(password.equalsIgnoreCase(pass)){
             System.out.println(uprivilage+"2");
             if(uprivilage.equalsIgnoreCase("admin"))
             {
//                 response.getWriter().println("admin");
                 System.out.println("admin3");
                 request.getSession(true).setAttribute("user_id", id);
                 response.sendRedirect("MainForAdmin.html");
             }
             else{
                 request.getSession(true).setAttribute("user_id", id);;
                 response.sendRedirect("MainForUser");
             }
         }else{
            response.sendRedirect("LoginFail.jsp"); 
         }
    } else {
        response.sendRedirect("LoginFail.jsp");
    }
%>
