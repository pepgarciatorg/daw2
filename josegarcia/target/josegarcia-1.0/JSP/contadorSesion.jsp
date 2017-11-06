<%-- 
    Document   : contadorsesion
    Created on : 10-oct-2017, 16:10:02
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
<%
    HttpSession sesion=request.getSession(true); //si no esta la crea
    int contador=0;
    boolean isInvalidate = false;
    if (request.getParameter("menu")!=null){
        System.out.println(sesion);
    
        //sesion.invalidate(
        try {
            sesion.invalidate();
            isInvalidate = true;
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        
        response.sendRedirect("../index.html");
        return;
    }
    if ( request.getParameter("eliminar") != null && request.getParameter("continuar")!=null) {
        sesion.invalidate();// la borramos con todos los atributos que tengan
        isInvalidate = true;
    }
    else {
        // Añadido el !isInvalidate.
        if (/*!isInvalidate && */sesion.getAttribute("contadorsesion") !=null){
            contador= ((Integer) sesion.getAttribute("contadorsesion"));
            
        } 
        // Añadido la comprobación si se ha invalidado.
        //if (!isInvalidate){
            sesion.setAttribute("contadorsesion",new Integer(contador+1));    
        //}
    
                
    }
    %>
 <%if (isInvalidate){
            
           %>
           <div id="contenedor">
            <h1>La sesión ha finalizado</h1>
            <form method="post" action="contadorSesion.jsp">
                <input type="submit" name="continuar" value="continuar"/>
                <input type="submit" name="menu" value="menu"/>
            </form>
        </div> 
           <%}
else {%>
        
        <div id="contenedor">
            <h1>Has visitado la página <%=  sesion.getAttribute("contadorsesion") %> veces!</h1>
            <form action="contadorSesion.jsp" method="POST">
                <input type="checkbox" name="eliminar" /><label>Eliminar sesion</label><br/><br/>
                <input type="submit" name="continuar" value="continuar"/>
                <input type="submit" name="menu" value="menu"/>
            </form>
        </div>
            <%}%>
        
    </body>
</html>
