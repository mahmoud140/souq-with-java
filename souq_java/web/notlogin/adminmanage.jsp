<%-- 
    Document   : adminmanage
    Created on : Feb 26, 2018, 2:36:42 PM
    Author     : sun com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/SouqAdminHeader.html"></jsp:include>
    <style>
        .list
        {
            font-size: 220%;
         
            color:white;
            align-content: center;

        }
        .link{

            color:blueviolet;
        }
        .click{

            color: darkmagenta;
            border: blueviolet;
            border-spacing:inherit;
            height:400%;
            width: 30% ;
               font-size: 70%;
               cursor: pointer;
             
        }
    </style>
    <ul class="list">
        <li><a  class="link" href="/souq_java/notlogin/Selectproducts.jsp"><input class="click" type="submit" value="View All Products"/></a></li><br>
        <li><a  class="link" href="/souq_java/notlogin/insertproduct.jsp"> <input class="click" type="submit" value="Add To The List"/></a></li><br>
        <li><a  class="link" href="/souq_java/notlogin/Updateproduct.jsp"><input class="click" type="submit" value=" Edit The List"/></a></li><br>
                <li><a  class="link" href="/souq_java/notlogin/deleteproducts.jsp"><input class="click" type="submit" value=" Delete Product"/></a></li><br>
        <li><a class="link" href="/souq_java/notlogin/listOfUsers.jsp"><input class="click" type="submit" value="List Of Users"/></a></li><br>
        <li><a class="link" href="/souq_java/notlogin/UserHistory.jsp"><input class="click" type="submit" value="User History"/></a></li><br>
    </ul>



<jsp:include page="/SouqFooter.html"></jsp:include>
