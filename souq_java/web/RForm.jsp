<%-- 
    Document   : RFrom
    Created on : Feb 24, 2018, 5:18:39 PM
    Author     : Mahmoud
--%>
<%@page import="com.java.DBClass"%>
<%@page session="false" import="java.sql.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String uname = request.getParameter("UserName");
    String pass = request.getParameter("Password");
    int ubudget = (Integer.valueOf(request.getParameter("CreditLimit")));
    System.out.println(ubudget);
    String job = request.getParameter("Job");
    String email = request.getParameter("E-mail");
    String address = request.getParameter("Address");
    Date birthDate =Date.valueOf(request.getParameter("BirthDate"));
//    Date date = formatter.parse(dateInString);
    Connection conn = (Connection) application.getAttribute("conn");
//    String query = "insert into users(user_name,user_password,user_privilege,user_budget,address,birth_date,job,email) values (?,?,'user',?,?,?,?,?)";
//    PreparedStatement stmt=conn.prepareStatement(query);
//    stmt.setString(1, uname);
//    stmt.setString(2, pass);
//    stmt.setInt(3, ubudget);
//    stmt.setString(4, address);
//    stmt.setDate(5, birthDate);
//    stmt.setString(6, job);
//    stmt.setString(7, email);
//    stmt.executeUpdate();
    DBClass insert =new DBClass( conn);
    insert.rForm(uname, pass, ubudget, job, email, address, birthDate);
    response.sendRedirect("LoginGUI.jsp");
%>

