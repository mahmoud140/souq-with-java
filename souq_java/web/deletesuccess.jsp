<%-- 
    Document   : deletesuccess
    Created on : Mar 2, 2018, 7:50:44 AM
    Author     : sun com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqAdminHeader.html"></jsp:include> 
    <style>



        .back
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
        
            margin-bottom: 70px;
            margin-right: 100px;
            position: relative;
            left:40%; 
            top:30% 

        }
         h1{
            color: snow;
            align-content: center;
        }
        body{
            background-color:	#8000ff;
        }

    </style>
<%
    out.println("<html><body><h1>Process accomplished successfully :D'</h1></body></html>");

%> 


<a href="adminmanage.jsp"><input class="back" type="submit" value="Back to main menu"/></a></br>
<a href="Deleteproducts.jsp"><input class="back" type="submit" value="Back to delete menu"/></a></br>
<a href="Updateproduct.jsp"><input class="back" type="submit" value="Back to edit menu"/></a></br>
<a href="insertproduct.jsp"><input class="back" type="submit" value="Back to Add menu"/></a></br>
