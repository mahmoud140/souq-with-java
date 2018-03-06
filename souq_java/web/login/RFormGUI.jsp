<%-- 
    Document   : RForm
    Created on : Feb 24, 2018, 2:03:33 PM
    Author     : Mahmoud
--%>

<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<style>
    #u{
        background-position: center;
        color:black;
        font-size: 25px;

    }
    #user,#pass
    {  
        height: 7%;
        align-items:center;
        background-position: center;
        background-size: 10px;
        width:20% ;
    }
    #form
    {
        align-content: center;
    }
    #sub
    { 
        text-align: center;
        text-decoration: yellow;
        background-size: 10px;
        width: 7%;
        height: 5%; 
        color: blueviolet;
        font-size: 20px;
    } 
    body{
        background-color:#8000ff;
    }

</style>

<jsp:include page="/SouqHeader.html"></jsp:include>
    <body>
        <form id="form" action="RForm.jsp">
            <p id="u">UserName</p>
            <input id="user" type="text" name="UserName" placeholder="UserName" required>
            <p id="u">Password</p>
            <input id="user" type="password" name="Password" placeholder="Password" required>
            <p id="u">Credit Limit</p>      
            <input id="user" type="text" name="CreditLimit" placeholder="Credit Limit" required>
            <p id="u">Job</p>  
            <input id="user" type="text" name="Job" placeholder="Job">
            <p id="u">E-mail</p> 
            <input id="user" type="text" name="E-mail" placeholder="E-mail">
            <p id="u">Address</p> 
            <input id="user" type="text" name="Address" placeholder="Address">
            <p id="u">Birth-Date</p> 
            <input id="user" type="text" name="BirthDate" placeholder="1994-12-12">
            <br>
            <br>
            <input id="sub" type="submit" value="submit">
        </form>
    </body>
<jsp:include page="/SouqFooter.html"></jsp:include>
