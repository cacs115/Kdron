<%-- 
    Document   : createPart
    Created on : 30/09/2017, 03:21:28 AM
    Author     : Carlos Correa
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar parte</title>
        <link href="MisEstilos.css" rel="stylesheet" type="text/css"/>  

    <body>
        <div id="wrapper">
            <header>
                <h1>Agregar parte</h1>
            </header>

            <%@include  file="navegation.jsp" %>


            <form  action='Controller'>
                <label for="name">Nombre de parte </label>
                <input type="hidden" name="opcion" value="partCreated">
                <input type="text" name="name" id="name" ><br/>


                <label for="weightSupported">Peso que soporta </label>
                <input type="number" name="weightsupported" id="weightsupported"><br/>
                
                <label for="batteryCells">celdas de bateria </label>
                <input type="number" name="batteryCells" id="batteryCells"><br/>
                
                <label for="esc">ESC </label>
                <input type="text" name="esc" id="esc"><br/>
                
                <label for="propeller">Helice </label>
                <input type="text" name="propeller" id="propeller"><br/>
                
    

                <br/>

<!--                <input type="submit"/>-->
                <input type="submit" value="Enviar" class="button"/>
                <input type="reset" value="Limpiar Campos" class="button"/>

            </form>


            <footer>
                <%@include file="navegation.jsp" %>
            </footer>
        </div>
    </body>
    <!-- <script src="miScript.js" type="text/javascript"></script> -->
</html>