<%-- 
    Document   : reinicioinsertar
    Created on : 05-nov-2017, 12:11:13
    Author     : Papa
--%>

<%@page import="es.albarregas.beans.Aves"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1>Insertar Registros</h1>
        <h2><%=request.getAttribute("error")%></h2>
        <% if (request.getAttribute("error")!=null){
        Aves datos = (Aves)request.getAttribute("aves");
        
        %>
      
        
        <div id="registro">
            Anilla:<input type="text" name="anilla" value="<%=datos.getAnilla()%>"/><br><br>
            Especie: <input type="text" name="especie" value="<%=datos.getEspecie()%>" /><br><br>
            Lugar: <input type="text" name="lugar" value="<%=datos.getLugar()%>" /><br><br>
            Fecha: <input type="text" name="fecha" value="<%=datos.getFecha()%>" /><br><br>
            <input type="hidden" name="origen" value="1">
            <input type="submit" value="Insertar" name="insertar" />
            <input type="submit" value="Cancelar" name="cancelar" />
        </div>
        <%} else {
%>
<div id="registro">
            Anilla:<input type="text" name="anilla" value=""/><br><br>
            Especie: <input type="text" name="especie" value="" /><br><br>
            Lugar: <input type="text" name="lugar" value="" /><br><br>
            Fecha: <input type="text" name="fecha" value="" /><br><br>
            <input type="hidden" name="origen" value="1">
            <input type="submit" value="Insertar" name="insertar" />
            <input type="submit" value="Cancelar" name="cancelar" />
        </div>
<%}%>
    </body>
</html>
