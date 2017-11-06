<%-- 
    Document   : calculadora
    Created on : 10-oct-2017, 11:10:37
    Author     : 1 daw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../CSS/Index.css"/>
</head>
<html>
    <h1>Calculadora</h1>

  

<%

String n1 = request.getParameter("num1");

String n2 = request.getParameter("num2");

String op = request.getParameter("operacion");
String mensaje="";
int num1 = Integer.parseInt(n1);

int num2 = Integer.parseInt(n2);

int res=0;

if(op.equals("suma")){
    res = num1+num2;
    mensaje=Integer.toString(res);
}

if(op.equals("resta")){
    res = num1-num2;
    mensaje=Integer.toString(res);
}

if (op.equals("multiplicacion")){
    res = num1*num2;
    mensaje=Integer.toString(res);
}

if (op.equals("division")){
    if (num2==0){
         mensaje="está intentando dividir entre 0";
    }else {
    res = num1/num2;
    mensaje=Integer.toString(res);
}

}
%>
  <div id="contenedor">
      
      <p><%="El resultado de la operación "+ op+" es "+mensaje%></p>
      <a href="../HTML/calculadora.html">Volver a Calculadora</a>
         
</div>
</body>

</html>
