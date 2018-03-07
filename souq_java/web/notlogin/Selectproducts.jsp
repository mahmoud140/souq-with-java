<%-- 
    Document   : Selectproducts
    Created on : Mar 3, 2018, 2:54:08 AM
    Author     : Noha
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/SouqAdminHeader.html"></jsp:include> 
<%

    Connection con = (Connection) request.getServletContext().getAttribute("conn");
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String category = request.getParameter("category");
    String photo = request.getParameter("photo");
    String amount = request.getParameter("amount");
    String Description = request.getParameter("description");
    String search = "select * from items";
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(search);

    out.println("<br>");
    out.println("<table align='center' border='3'  bordercolor='blueviolet' >"
            + "   <tr>\n"
            //  + "        <th bgcolor='blueviolet'>Product Id</th>\n"
            + "        <th bgcolor='blueviolet'>Product name</th>\n"
            + "        <th bgcolor='blueviolet'>Product price</th>\n"
            + "        <th bgcolor='blueviolet'>Product category</th>\n"
            + "        <th bgcolor='blueviolet'>Quantity</th>\n"
            + "        <th bgcolor='blueviolet'>Photo</th>\n"
            + "        <th bgcolor='blueviolet'>Product Description</th>\n"
            + "   </tr>   ");
    while (rs.next()) {
        //   int id=rs.getInt("item_id");
        out.println("<tr>");
        //  out.print("<td >" + rs.getInt(1) + "</td>");
        out.print("<td >" + rs.getString(2) + "</td>");
        out.print("<td >" + rs.getString(3) + "</td>");
        out.print("<td >" + rs.getString(4) + "</td>");
        out.print("<td >" + rs.getString(5) + "</td>");
        out.print("<td >" + rs.getString(6) + "</td>");
        out.print("<td >" + rs.getString(7) + "</td>");
        out.println("</tr>");
    }
    out.println("<table>"
            + "<br>");


%>
<style>
    .p{
        color:blueviolet;
        font-size: 20px;
        align-content: center;
        border-bottom-width: thick;
        font-family: serif;
    }
    .i
    { 
        height: 70%;
        width: 90%;
        size: A4;

    }
    .button
    {
        color: darkmagenta;
        border: blueviolet;
        border-spacing:inherit;
        height:50%;
        width: 30% 
    }
    .back{
        align-content: center;
        animation: infinite;
        color: darkmagenta;
        border: blueviolet;
        border-spacing:inherit;
        align-items: center;  
        margin-top: 5%;
        margin-left:45%;
    }
    .inserttable{
        height: 20%;
        width:50%;
        size: 30px 40px;

    }
    body{
        background-color:white;
    }
</style> 
<body>
    <a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a>
</body>
