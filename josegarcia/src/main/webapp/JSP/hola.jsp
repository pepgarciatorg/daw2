<%-- 
    Document   : hola
    Created on : 06-oct-2017, 17:01:46
    Author     : 1 daw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalTime" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../CSS/Index.css"/>
    </head>
    <body>
        
        <%
            String saludo;
            int hora=LocalTime.now().getHour();
            String genero="";
            if (hora<12){
                saludo="dias";
            }
            else {
                if(hora>21) {
                    saludo="noches";
                }
                else {
                    saludo="tardes";
                }
            }
            
            if (request.getParameter("sexo").equals("Hombre")){
                genero="señor";
            }
            else{ 
                    genero="señora";
            }
            %>
            <div id="contenedor">
                <p>Buenas <%=saludo%> <%=genero%> <%=request.getParameter("nombre")%></p>
                <a href="../index.html">Volver al menú</a>
            </div>
        </body>
</html>
