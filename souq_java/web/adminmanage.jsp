<%-- 
    Document   : adminmanage
    Created on : Feb 26, 2018, 2:36:42 PM
    Author     : sun com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqAdminHeader.html"></jsp:include>
<style>
    .list
    {
        font-size: 150%;
        font-stretch: expanded;
        font-style: initial;
        color:violet;
        
    }
    .link{
      
        color:blueviolet;
    }
</style>
<ul class="list">
    <li><a  class="link" href=""> View All products.</a></li><br>
    <li><a  class="link" href=""> Add New Product.</a></li><br>
    <li><a  class="link" href=""> Edit Product.</a></li><br>
    <li><a  class="link"  href="deleteproducts.jsp"> Remove Product.</a></li> <br>
    <li><a class="link" href="listOfUsers.jsp">List Of Users.</a></li><br>
</ul>
  

<jsp:include page="SouqFooter.html"></jsp:include>
