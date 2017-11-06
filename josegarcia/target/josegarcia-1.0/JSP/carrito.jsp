<%-- 
    Document   : carrito
    Created on : 14-oct-2017, 17:41:43
    Author     : 1 daw
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="es.albarregas.models.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <% 
    HttpSession sesion = request.getSession(true);
    String aLibros[]={"LA MUERTE LLEGA A PEMBERLEY","LA CONJURA DE CORTES","BUENOS DIAS, PRINCESA","EMOCIONES TOXICAS",
        "JUEGO DE TRONOS","LA ORDEN DEL TEMPLE","EL DECAMERON","CHACAL","ORIGEN","CORTO MALTES"};
    
    ArrayList <Libro> aCarrito = new ArrayList <Libro>(); //inicializamos ArrayList vacío
    
    if (sesion.getAttribute("carrito") != null) { // si existe sesion cargamos el carrito de la sesión
        aCarrito = (ArrayList <Libro>) sesion.getAttribute("carrito");
    }
    
    String mensaje="";
    boolean sw=false; // vamos a controlar si se ha pulsado o no finalizar para pintar el formulario o no
 %> 
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../CSS/Index.css"/>
    </head>
    <body>
         <%
    if (request.getParameter("finalizar") != null) {
                sw=true;
               System.out.println("se ha pulsado finalizar");
               if (!aCarrito.isEmpty()) { // si se ha pulsado finalizar y el carrito no está vacío dibujamos el carrito
                   %>
                     <div id="contenedor">
                        <h1>Libros On-Line</h1>
                        <img src="../images/carritolibros.jpg" width="100"/>
                        <p>Este es el detalle de su pedido:</p>
                        <div id="centratabla">
                        <table>
                          <tr>
                            <th>Cantidad</th>
                            <th>Titulo</th>
                          </tr>
                          <tr>
                        <%
                        Iterator it = aCarrito.iterator();
                        while(it.hasNext()){
                          Libro libro = (Libro) it.next();
                          %>
                         <td><%=libro.getTitulo()%></td>
                         <td><%=libro.getCantidad()%></td>
                         </tr>
                        <%
                    }
                    sesion.invalidate();
                    %>
                    </div>
                    </table>
                    <a href="../index.html">Gracias por confiar en nosotros</a>
                    </div>
                   <%
                }
               else {
                    sesion.invalidate(); // si no tiene nada mostramos mensaje y cerramos sesion
                    %>
                    <div id="contenedor">
                    <h1>Libros On-Line</h1>
                    <img src="../images/carritolibros.jpg" width="100"/>
                    <p>No ha seleccionado ningún producto</p>
                    <a href="../index.html">Gracias por confiar en nosotros</a>
                    </div>
                    <%
                 }
}   %>
        <%
            if (!sw || request.getParameter("anadir")!=null ) {
               if (request.getParameter("elegido") == null){ 
                   mensaje = "Seleccione un libro por favor ....";
               }
               else {
                   try {
                        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        if (cantidad<=0){
                            mensaje = " La cantidad de entrada no puede ser 0 o negativa";
                        }
                        else {
                            Iterator it = aCarrito.iterator();
                            String elegido = request.getParameter("elegido");
                            boolean encontrado = false;
                            while(it.hasNext() && !encontrado){   // recorremos ArrayList buscando título
                                Libro libro = (Libro) it.next();
                                if (elegido.equals(libro.getTitulo())){ // si lo encontramos, lo actualizamos
                                    encontrado = true;
                                    aCarrito.remove(libro); // borramos libro del ArrayList
                                    libro.setCantidad(libro.getCantidad() + cantidad);
                                    aCarrito.add(libro); // hemos actualizado la cantidad en el objeto libro actual y grabamos actualizacion
                                    sesion.setAttribute("carrito", aCarrito);
                                    mensaje = "Añadido a la cesta " + cantidad + " unidades del libro " + libro.getTitulo();
                                }
                            }
                            if (!encontrado){
                                Libro nuevo = new Libro(); // si no existe el titulo creamos un nuevo objeto, lo añadimos al ArrayList
                                nuevo.setTitulo(request.getParameter("elegido"));
                                nuevo.setCantidad(cantidad);
                                aCarrito.add(nuevo);
                                sesion.setAttribute("carrito", aCarrito); //actualizamos la sesión
                                mensaje="Añadido a la cesta " + cantidad + "unidades del libro " + nuevo.getTitulo();
                            }
                        }
                    } catch (NumberFormatException e){
                        mensaje = "La cantidad no es un número válido";
                    }
                }
%>
        <p><%=mensaje%></p>
        <form action="carrito.jsp" method="post">
            <label>Seleccione un libro</label>
            <br><br>
            <select name="elegido" size="5">
            <% for (int i=0;i<aLibros.length;i++){ %>
                <option value="<%=aLibros[i]%>"><%=aLibros[i]%></option>
            <%}%>
            </select>
            <br><br>
            <label>Cantidad: </label>
            <input type="text" name="cantidad">
            <br><br>
            <input type="submit" name="anadir" value="Añadir a la cesta">
            <input type="submit" name="limpiar" value="Limpiar">
            <input type="submit" name="finalizar" value="Finalizar">
        </form>
            <%}%>
    </body>
</html>
