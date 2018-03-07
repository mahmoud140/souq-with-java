<%-- 
    Document   : ListOfUsers
    Created on : Feb 26, 2018, 8:47:43 AM
    Author     : Mahmoud
--%>

<%@page import="java.sql.Connection"%>
<%@page session="false" import="java.sql.ResultSet"%>
<%@page import="com.java.DBClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/SouqAdminHeader.html"></jsp:include>
    <style>
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
            width: 30;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
            text-align: center;
        }
          .u{
          
                   color: blueviolet;
                   font-size: 25px;
             }
           .user
           {   
               height:15%;
               background-position:right;
               background-size:10px;
               width:15% ;
               background-repeat: no-repeat;
               size:60;
               font-size: 20px;
          
           }
          .pass
           {  
               height:15%;
               background-position:right;
               background-size: 10px;
               width:15% ;
               background-repeat: no-repeat;
               size:60;
               font-size: 20px;
            
           }
           .form
           {
               align-content: center;
          
           }
           .sub
           { 
               text-align: center;
               text-decoration: yellow;
                background-size: 10px;
                width: 7%;
                height: 5%; 
                color: blueviolet;
                font-size: 20px;    
           }
           .backbut
           { 
               text-align: center;
               text-decoration: yellow;
                background-size: 10px;
                width: 20%;
                height: 5%; 
                color: blueviolet;
                font-size: 20px;    
           }
           
    </style>

<%
    Connection conn = (Connection) application.getAttribute("conn");
    DBClass insert = new DBClass(conn);
    ResultSet rs = insert.listOfUsers();
    out.println("<br>");
    out.println("<table align='center' id='customers'>"+
            "   <tr>\n" +
"        <th>UserName</th>\n" +
"        <th>Password</th>\n" +
"        <th>UserBudget </th>\n" +
"        <th>Address </th>\n" +
"        <th>BirthDate</th>\n" +
"        <th>Job</th>\n" +
"        <th>Email</th>\n" +
"   \n" +
"   </tr>   ");
    while (rs.next()) {
        String privilage = rs.getString(4);
        if(!privilage.equals("admin"))
        {
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
    }
    out.println("<table>"
            + "<br>");
%>
<p class="u">Enter the UserName you want to edit</p>
<form action="notlogin/listOfUsers">
    <p class="u">UserName:</p>
    <input  class="user" type="text" name="UserName" placeholder="UserName" required>
    <p class="u">Credit Limit</p>
    <input class="user" type="number" name="user_budget" placeholder="UserBudget" required>
    <br>
    <br>
    <input class="sub" type="submit" value="Enter">
</form>
 <a href="adminmanage.jsp"> <input class="backbut" type="submit" value="Back to main menu"/></a><br>
<jsp:include page="SouqFooter.html"></jsp:include>

