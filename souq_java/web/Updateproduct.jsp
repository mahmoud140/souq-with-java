<%-- 
    Document   : Updateproduct
    Created on : Mar 2, 2018, 8:29:24 AM
    Author     : Noha
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqAdminHeader.html"></jsp:include> 

<%
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iti_souq", "postgres", "root");
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
    out.println("<table align='center' border='3'color='white'  bordercolor='black' >"
            + "   <tr>\n"
            + "        <th bgcolor='blueviolet'>Product name</th>\n"
            + "        <th bgcolor='blueviolet'>Product price</th>\n"
            + "        <th bgcolor='blueviolet'>Product category</th>\n"
            + "        <th bgcolor='blueviolet'>Quantity</th>\n"
            + "        <th bgcolor='blueviolet'>photo</th>\n"
            + "        <th bgcolor='blueviolet'>Product Description</th>\n"
            + "   </tr>   ");
    while (rs.next()) {
  //   int id=rs.getInt("item_id");
        out.println("<tr   text-decoration='white'>");
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
    .back{
        align-content: center;
        animation: infinite;
        align-content: center;
        animation: infinite;
        color: darkmagenta;
        border: blueviolet;
        border-spacing:inherit;
        align-items: center;  
        margin-top: 5%;
        margin-left:45%;
    }
    .updatetable{
        height: 50%;
        width:50%;
        size: 30px 40px;
  
    }
    body{
        background-color:#8000ff;
    }
</style>
<body>
<form  name="updateform" id="update" method=" get" action="Updayeproducts">
    <table class="updatetable" bgcolor="black" bordercolor="blueviolet" align="center">
        <tr>
            <td><p class="p">Enter product name to be updated:</p></td>
            <td><input class="i" type="text" name="name" id="name"  placeholder="Enter product name" ></td>

        </tr>
        <tr>
            <td><p class="p">Price:</p></td>
            <td><input class="i" type="text" name="price"  placeholder="Enter price"  required></td>
        </tr>
        <tr>
            <td><p class="p">category:</p></td>
            <td><input  class="i" type="text" name="category"  placeholder="Enter category" required></td>
        </tr>
        <tr>
            <td><p class="p">amount in the stock :</p></td>
            <td><input  class="i" type="text" name="amount"  placeholder="Enter amount" required></td>
        </tr> 
        <tr>
            <td><p class="p"> photo(url) :</p></td>
            <td><input  class="i" type="text" name="photo"  placeholder="Enter photo" required></td>
        </tr>
        <tr>

            <td><p class="p"> Description:</p></td>
            <td ><textarea    name="description" placeholder="Enter description" required></textarea></td>
        </tr>
        <tr> 
            <td> <input class="button" type="submit" value="Update"/>
                <input class="button" type="reset" value="reset"/>

            </td>
        </tr>
    </table>
</form> 


<a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a>
</body>