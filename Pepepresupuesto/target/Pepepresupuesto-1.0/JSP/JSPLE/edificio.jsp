<%-- 
    Document   : edificio.jsp
    Created on : 22-oct-2017, 17:27:18
    Author     : Papa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seguro edificios</title>
    </head>
    <body>
        <h1>Seguro de edificios</h1>
         <h1>Seguro de edificios</h1>
        <form action="Controlador" method="post">
            <table>
            <tr>
                <td>Tipo de Edificio:</td>   
                <td>
                <select name="tipoedificio">
                    <option value="Piso" selected>Piso </option>
                    <option value="Casa">Casa </option>
                    <option value="Adosado">Adosado </option>
                    <option value="Duplex">Duplex </option>
                    <option value="Chalet">Chalet </option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Número de habitaciones:</td>
                <td>
                <select name="habitaciones">
                    <option value="1" selected>1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5 o más</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Fecha de construcción:</td>
                <td>
                <select name="fechacons">
                    <option value="1949" selected>Antes de 1950</option>
                    <option value="1950">Entre 1950 y 1990</option>
                    <option value="1991">Entre 1991 y 2005</option>
                    <option value="2006">Entre 2006 y 2015</option>
                    <option value="2016">Después de 2015</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Tipo de construccion:</td>
                <td>
                <div>
                   <input type="radio" name="tipoconstruc" value="madera" checked>Madera<br>
                   <input type="radio" name="tipoconstruc" value="hormigon">Hormigón
                </div>
                </td>
            </tr>
            <tr>
                <td>Valor estimado en el mercado:</td>
                <td>
                <select name="fechacons">
                    <option value="25000" selected>Menos de 50.000</option>
                    <option value="50001">Entre 50.001 y 80.000</option>
                    <option value="80001">Entre 80.001 y 100.000</option>
                    <option value="100001">Entre 101.000 y 150.000</option>
                    <option value="150001">Más de 150.000</option>
                </select>
                </td>
            </tr>
        </table>        
            <br>
            
            <input type="submit" name="enviar" value"Enviar">
        </form>
    </body>
</html>
