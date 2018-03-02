<%-- 
    Document   : deleteproducts
    Created on : Mar 2, 2018, 3:23:24 AM
    Author     : sun com
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqAdminHeader.html"></jsp:include>
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
            height: 200%;
            width: 100%;
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
        .back
        {
            align-content: center;
            animation: infinite;
        }
        .deletetable{
            background-color:white;
            height: 30%;
            width:30%;


        }
        .back
        { 
            color: darkmagenta;
            border: blueviolet;
            border-spacing:inherit;
            align-items: center;  
            margin-top: 5%;
            margin-left:45%;


        }
    </style> 
<%
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_souq", "postgres", "root");
    String name = request.getParameter("name");
    String search = "select item_name from items";
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(search);
            
    out.println("<br>");
    out.println("<table align='center' border='1'  bordercolor='blueviolet' >"+
            "   <tr>\n" +
"        <th bgcolor='blueviolet'>Product name</th>\n" +
"   </tr>   ");
            while (rs.next())
            {  
                
                 out.print ("<tr color='blueviolet'><td >"+rs.getString(1)+"</td>");
            }  
 out.println("<table>"
            + "<br>");
   

%>
<body  >
    <form  method="get" action="Deleteproducts">
        <table class="deletetable"  bgcolor="white" bordercolor="blueviolet" align="center">
            <tr>
                <td><p class="p">Enter product name to be deleted:</p></td><br>
                <td><input class="i" type="text" name="name"  placeholder="Enter item name" required></td>
            </td> 
            <tr> 
                <td> <input class="button" type="submit" value="Delete" />


                </td>
            </tr>
        </table>  

    </form>

    <a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a></br>
    <a href="">  <input class="back" type="submit" value="View All products"/><a>
     
      