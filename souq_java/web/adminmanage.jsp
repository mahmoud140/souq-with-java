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
        body{
            background-color:#8000ff;
        }

        .click
        { 
            width: 250px;
            font-size: 20px;
            text-align: center;
            border-radius: 5px;
            color: darkmagenta;
            border: blueviolet;
            border-spacing:inherit;
            height:100%;
            background-position:left;
            cursor: pointer;
            margin-bottom: 70px;
            margin-right: 100px;
            position: relative;
            left:40%; 
            top:30% 

        }
    </style> 
    <body>
      

        <a href="Selectproducts.jsp"><input class="click" type="submit" value="View All Products"/></a></br>
        <a href="insertproduct.jsp"><input class="click" type="submit" value="Add New Product"/></a></br>
        <a href="Updateproduct.jsp"><input class="click" type="submit" value="Edit Product"/></a></br>
        <a href="deleteproducts.jsp"><input class="click" type="submit" value="Remove Product"/></a></br>
        <a href="listOfUsers.jsp"><input class="click" type="submit" value="List Of Users"/></a></br>
      
    </body>


<jsp:include page="SouqFooter.html"></jsp:include>
