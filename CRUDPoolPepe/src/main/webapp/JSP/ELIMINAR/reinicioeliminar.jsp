<%-- 
    Document   : reinicioeliminar
    Created on : 05-nov-2017, 12:10:50
    Author     : Papa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="es.albarregas.beans.Aves"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar registros</h1>
            <form>
            <table border="1">
                <thead>
                    <tr>
                        <th>Anilla</th>
                        <th>Especie</th>
                        <th>Lugar</th>
                        <th>Fecha</th>
                        <th>Marcar</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    ArrayList<Aves> datos =(ArrayList<Aves>) request.getAttribute("listaaves");
                    for(int i=0;i<datos.size();i++){
                    %>
                        <tr>
                    <%
                        Aves ave=datos.get(i);
                    %>
                            <td><%=ave.getAnilla()%></td>
                            <td><input type="text" name="anilla" value="<%=ave.getEspecie()%>" /></td>
                            <td><input type="text" name="anilla" value="<%=ave.getLugar()%>"/></td>
                            <td><input type="text" name="anilla" value="<%=ave.getFecha()%>"</td>
                            <td><input type="checkbox" name="sel" value="<%=ave.getAnilla()%>" /></td>
            
                    <%}%>
                        </tr>      
                </tbody>
            </table>
                <input type="hidden" name="origen" value="3" />
                <br><br>
                <input type="submit" value="Actualzar" />
                <input type="submit" value="Cancelar" />
    </body>
</html>

