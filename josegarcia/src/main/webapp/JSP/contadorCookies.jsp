<%-- 
    Document   : contadorCookies
    Created on : 09-oct-2017, 20:45:06
    Author     : 1 daw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/Index.css"/>
        <title>Contador de visitas</title>
    </head>
    <body>
 <%
             Cookie galleton=null;
             Cookie[] galleta = request.getCookies(); 
             if (galleta!=null){
                for (int i=0;i<galleta.length;i++){
                    if (galleta[i].getName().equals("CONTADOR")){
                        galleton=galleta[i];
                        break;
                    }
                 }
             }
             if (request.getParameter("menu")!=null){
                 response.sendRedirect("../index.html");
             }
             if (request.getParameter("eliminar")!=null){
                    galleton=null; //reseteamos cookiese ha pulsado resetear
             }
             if (galleton == null ){
                 galleton =new Cookie("CONTADOR","0");
             }
             
             
             int valor = Integer.parseInt(galleton.getValue());
             galleton.setValue(Integer.toString(valor+1));
             
             galleton.setMaxAge(24*60*60);
             response.addCookie(galleton); //solo se crea cuando se hace response
        %>

        <div id="contenedor">
            <h2>Has visitado la pagina <%=galleton.getValue()%> veces</h2>
            <%
                if (galleton.getValue().equals("1")){
                    %>
                    <h3>Información de la cookie</h3>
                    <p>Caducidad: <%= galleton.getMaxAge() %></p>
                    <p>Nombre: <%= galleton.getName() %></p>
                    <p>Segura: <%= galleton.getSecure() %></p>
                    <p>Versión: <%= galleton.getVersion() %></p>
                    <form action="contadorCookies.jsp" method="post">
                        <input type="submit" name="recargar" value="recargar">
                        <input type="submit" name="eliminar" value="eliminar">
                        <input type="submit" name="menu" value="menu">
                    </form>
            <%}  
            else {%>
                    <form action="contadorCookies.jsp" method="post">
                        <input type="submit" name="recargar" value="recargar">
                        <input type="submit" name="eliminar" value="eliminar">
                        <input type="submit" name="menu" value="menu">
                    </form>
                    <%}%>
            
        </div>
    </body>
</html> 
