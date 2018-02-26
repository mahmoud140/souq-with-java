<%-- 
    Document   : list
    Created on : Feb 26, 2018, 2:24:14 PM
    Author     : sun com
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.java.DBClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqHeader.html"></jsp:include>
<%
        Connection conn = (Connection) application.getAttribute("conn");
        DBClass insert = new DBClass(conn);
        ResultSet rs=insert.listOfUsers();
        out.println(
"<table border=\"2\"> \n" +
"   <tr>\n" +
"        <td>uName</td>\n" +
"        <td>user_password</td>\n" +
"        <td>user_budget </td>\n" +
"        <td>address </td>\n" +
"        <td>birth_date</td>\n" +
"        <td>job </td>\n" +
"        <td>email</td>\n" +


"   \n" +
"   </tr>   ");
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
       // out.println("</table>");
    %>
    Enter the UserName you want to edit
    <form action="notlogin/listOfUsers">
        <br>UserName
        <input type="text" name="UserName" placeholder="UserName" required>
        <br>Credit Limit
        <input type="number" name="user_budget" placeholder="UserBudget" required>
        <br>
         <input type="submit" value="Enter">
    </form>
<jsp:include page="SouqFooter.html"></jsp:include>
