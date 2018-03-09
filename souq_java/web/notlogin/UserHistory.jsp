<%-- 
    Document   : UserHistory
    Created on : Mar 6, 2018, 11:31:32 AM
    Author     : Mahmoud
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.java.DBClass"%>
<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
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
            background-color: blueviolet;
            color: black;
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
    DBClass obj = new DBClass(conn);
    ResultSet rs = obj.bought();
    out.println("<br>");
    out.println("<table align='center' id='customers'>"
            + "   <tr>\n"
            + "        <th>UserName</th>\n"
            + "        <th>ItemName</th>\n"
            + "        <th>Transaction date </th>\n"
            + "        <th>Amount </th>\n"
            + "   </tr>   ");
    while (rs.next()) {
        String privilage = rs.getString(4);
        if (!privilage.equals("admin")) {
            String uName = rs.getString("user_name");
            String item_name = rs.getString("item_name");
            Date trans_date = rs.getDate("trans_date");
            int amount = rs.getInt("amount");
            out.println("<tr>");
            out.println("<td>");
            out.println(uName);
            out.println("</td>");
            out.println("<td>");
            out.println(item_name);
            out.println("</td>");
            out.println("<td>");
            out.println(trans_date);
            out.println("</td>");
            out.println("<td>");
            out.println(amount);
            out.println("</td>");
            out.println("</tr>");
        }
    }
    out.println("<table>"
            + "<br>");
%>
<jsp:include page="/SouqFooter.html"></jsp:include>