<%-- 
    Document   : deletefail
    Created on : Mar 2, 2018, 8:06:44 AM
    Author     : sun com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqAdminHeader.html"></jsp:include>  
<script>
        
         .back
        { 
            color: darkmagenta;
            border: blueviolet;
            border-spacing:inherit;
            align-items: center;  
            margin-top: 5%;
            margin-left:45%;
            align-content: center;
            animation: infinite;


        }
    </script>
<%
     out.println("<html><body><h1 color='blueviolet'>Please try again,product not found :D'</h1></body></html>");
     

 
%> 
<div>  <a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a><br></div>
   <a href="Deleteproducts.jsp"><input class="back" type="submit" value="Back to delete menu"/></a></br>