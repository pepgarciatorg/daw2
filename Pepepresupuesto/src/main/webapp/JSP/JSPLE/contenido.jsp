<%-- 
    Document   : contenido
    Created on : 22-oct-2017, 18:14:17
    Author     : Papa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contenido</title>
    </head>
    <body>
        <h1>Seguro de contenido</h1>
        <form action="CalcularCuota()" method="post">
            <table>
                <tr>
                    <td>Cubrir daños accidentales:</td>
                    <td>
                        <input type="checkbox" name="danos" checked>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad que quiere asegurar:</td>
                    <td>
                    <select name="cantidad">
                        <option value="10000" selected>10.000 </option>
                        <option value="20000">20.000 </option>
                        <option value="30000">30.000 </option>
                        <option value="50000">50.000 </option>
                        <option value="100000">100.000 </option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td>Importe franquicia:</td>
                    <td>
                    <input type="radio" name="franquicia" value="ninguna">Ninguna<br>
                    <input type="radio" name="franquicia" value="500">500<br>
                    <input type="radio" name="franquicia" value="1000" checked>1.000
                    </td>
                </tr>
            </table>
                    <input type="submit" name="enviar" value"Enviar">
        </form>
    </body>
</html>
