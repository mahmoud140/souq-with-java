<%-- 
    Document   : deletesuccess
    Created on : Mar 2, 2018, 7:50:44 AM
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


        }
    </script>
<%
     out.println("<html><body><h1 color='blueviolet'>Operation accomplished successfully :D'</h1></body></html>");
     

 
%> 
  <div><a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a><br></div>
    <a href="Deleteproducts.jsp"><input class="back" type="submit" value="Back to delete menu"/></a></br>
    <a href="Updateproduct.jsp"><input class="back" type="submit" value="Back to edit menu"/></a></br>
    <a href="insertproduct.jsp"><input class="back" type="submit" value="Back to Add menu"/></a></br>
