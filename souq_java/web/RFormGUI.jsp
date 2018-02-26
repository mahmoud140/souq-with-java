<%-- 
    Document   : RForm
    Created on : Feb 24, 2018, 2:03:33 PM
    Author     : Mahmoud
--%>

<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<style>
    #u{
        background-position: center;
        color: blueviolet;
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

</style>
<jsp:include page="SouqHeader.html"></jsp:include>
    <form id="form" action="RForm.jsp">
        <br>UserName
        <input id="user" type="text" name="UserName" placeholder="UserName">
        <br>
        <br>Password
        <input id="pass" type="text" name="Password" placeholder="Password">
        <br>
        <br>
        Credit Limit
        <input id="user" type="text" name="CreditLimit" placeholder="Credit Limit">
        <br>
        <br>Job
        <input type="text" name="Job" placeholder="Job">
        <br>
        <br>
        E-mail
        <input id="user" type="text" name="E-mail" placeholder="E-mail">
        <br>
        <br>Address
        <input id="user" type="text" name="Address" placeholder="Address">
        <br>
        <br>Birth-Date
        <input id="user" type="text" name="BirthDate" placeholder="1994-12-12">
        <br>
        <br>
        <input id="sub" type="submit" value="submit">
    </form>
<jsp:include page="SouqFooter.html"></jsp:include>
