<%-- 
    Document   : Login
    Created on : Feb 24, 2018, 11:46:12 AM
    Author     : Mahmoud
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqHeader.html"></jsp:include>
<jsp:include page="login.html"></jsp:include>
<jsp:include page="SouqFooter.html"></jsp:include>
<%!
    Vector<String> players_name = new Vector<String>();
    Vector<String> players_password = new Vector<String>();
    boolean vaild = true;
%>
<%
    String uname = request.getParameter("name");
    String pass = request.getParameter("password");
    Connection conn = (Connection) application.getAttribute("conn");
    String query = "select uname,password from users";
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
        query="select password,uprivilage from users where uname="+uname;
         rs = stmt.executeQuery(query);
         String password=rs.getString(1);
         String uprivilage=rs.getString(2);
         if(password.equalsIgnoreCase(pass)){
             if(uprivilage.equalsIgnoreCase("admin"))
             {
                 response.sendRedirect("MainForAdmin");
             }
             else{
             response.sendRedirect("MainForUser.html");
             }
         }
    } else {
        response.sendRedirect("LoginFail.jsp");
    }
%>
