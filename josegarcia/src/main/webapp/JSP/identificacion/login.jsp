<%-- 
    Document   : login
    Created on : 10-oct-2017, 17:42:57
    Author     : 1 daw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--// tenemos que presentar usuario y contraseña con un checked de recordar usuario
    // boton login y boton logout
    // mensajes cuando no este logeado dependiendo de error1 si viene directo de menu
    // error2 si viene de comprobar y no es correcto
    // en sesion guardamos solamente el usuario
    // debemos guardar en una cookie la fecha de acceso
    // y en otra si recordamos al usuario aunque la sesion se haya cerrado.
    // el campo usuario debe´ra leer esa cokie ysi existe poner el valor (nombre)--%>
    <body>
        <h1>Login usuario</h1>
    <%
   
   Date dNow = new Date();
   SimpleDateFormat ft = new SimpleDateFormat ("EEE, d MMM yyyy HH:mm:ss ");
   String currentDate = ft.format(dNow);
   Cookie cookfecha= new Cookie ("UACCESO","10102017");
   response.addCookie(cookfecha);
    %>
    <p>Fecha último acceso: <%=currentDate%></p>
        
    <% Cookie galleton=null;
       boolean recuerdo=false;
       String usuario;
       Cookie[] galleta = request.getCookies(); 
            if (galleta!=null){
                for (int i=1;i<galleta.length;i++){
                    if (galleta[i].getName().equals("USUARIO")){
                        galleton=galleta[i];
                        usuario=galleton.getValue();
                        recuerdo=true;
                        break;
                    }
                     
                 }
             }
            
    %>
        <%--// tenemos que definir si el mensaje de error de autentificacion nos viene de 
        * no haber iniciado sesion o de error en ususario/contraseña*/--%>
        <form action="sendredirect(loginIN.jsp)" method="POST">
        <p>Usuario: </p> <input type="text" name="usuario">
        <p>Contraseña: </p> <input type="password" name="contrasena">
        <p>Recordar contraseña</p> <input type="checkbox" value="recordar" id="recuerda">
        <br>
        <br>
         <input type="submit" name="logear" value="logear">
        </form>
        <%--//si esta marcado recuerda grabamos la cookie--%>
        <%--<% if (request.getParameter("recuerda").equals("recordar")){
            Cookie recusu=new Cookie("USUARIO",request.getParameter("usuario"));
            response.addCookie(recusu);
        }
            
            
            %>--%>
    </body>
</html>
