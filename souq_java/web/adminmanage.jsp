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
    <li><a  class="link" href=""> View All products.</a></li></br>
    <li><a  class="link" href=""> Add To The List.</a></li></br>
    <li><a  class="link" href=""> Edit The List.</a></li><br>
    <li><a  class="link"  href=""> Remove From The List.</a></li> <br>
</ul>
  

<jsp:include page="SouqFooter.html"></jsp:include>