<%-- 
    Document   : newjsp1
    Created on : Feb 26, 2018, 12:10:48 PM
    Author     : Mahmoud
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conn= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/iti_souq", "postgres", "iti");
        String query = "select * from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
//        Connection conn = (Connection) application.getAttribute("conn");
//        DBClass insert = new DBClass(conn);
//        ResultSet rs=insert.listOfUsers();
        out.println("<table border=\'1'>");
        while (rs.next()) {
            String uName = rs.getString("user_name");
            String user_password = rs.getString("user_password");
            int user_budget = rs.getInt("user_budget");
            String address = rs.getString("address");
            String birth_date = rs.getString("birth_date");
            String job = rs.getString("job");
            String email = rs.getString("email");
            out.println("<tr>");
            out.println("<td>");
            out.println(uName);
            out.println("</td>");
            out.println("<td>");
            out.println(user_password);
            out.println("</td>");
            out.println("<td>");
            out.println(user_budget);
            out.println("</td>");
            out.println("<td>");
            out.println(address);
            out.println("</td>");
            out.println("<td>");
            out.println(birth_date);
            out.println("</td>");
            out.println("<td>");
            out.println(job);
            out.println("</td>");
            out.println("<td>");
            out.println(email);
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("<table>");
    %>
    Enter the UserName you want to edit
    <form action="RForm.jsp">
        <br>UserName
        <input type="text" name="UserName" placeholder="UserName" required>
        <br>Credit Limit
        <input type="number" name="user_budget" placeholder="UserName" required>
        <br>
         <input type="submit" value="Enter">
    </form>
    </body>
</html>
