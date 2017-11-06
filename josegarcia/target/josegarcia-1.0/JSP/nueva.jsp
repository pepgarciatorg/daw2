<%-- 
    Document   : nueva
    Created on : 06-oct-2017, 16:49:46
    Author     : 1 daw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2><%= request.getContextPath()%><h2>
        <%
            int op1=35;
            int op2=27;
            int resultado=op1+op2;
        %>
        <p>El resultado de sumar <%=op1%> y <%=op2%> es igual a <%=resultado%><p>
    </body>
</html>
