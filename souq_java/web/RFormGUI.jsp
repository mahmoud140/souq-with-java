<%-- 
    Document   : RForm
    Created on : Feb 24, 2018, 2:03:33 PM
    Author     : Mahmoud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="SouqHeader.html"></jsp:include>
    <form action="RForm.jsp">
        <br>UserName
        <input type="text" name="UserName" placeholder="UserName">
        <br>Password
        <input type="text" name="Password" placeholder="Password">
        <br>
        Credit Limit
        <input type="text" name="CreditLimit" placeholder="Credit Limit">
        <br>Job
        <input type="text" name="Job" placeholder="Job">
        <br>
        E-mail
        <input type="text" name="E-mail" placeholder="E-mail">
        <br>Address
        <input type="text" name="Address" placeholder="Address">
        <br>Birth-Date
        <input type="text" name="BirthDate" placeholder="1994-12-12">
        <br>
        <input type="submit" value="submit">
    </form>
<jsp:include page="SouqFooter.html"></jsp:include>
