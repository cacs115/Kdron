<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar usuario</title>
        <link href="MisEstilos.css" rel="stylesheet" type="text/css"/>  

    <body>
        <div id="wrapper">
            <header>
                <h1>Agregar usuario</h1>
            </header>

            <%@include  file="navegation.jsp" %>


            <form method="post" name="frmRegister" id = "frmRegistrese" action="Controller">
                <label for="mail">email </label>
                <!--                <input type="hidden" name="opcion" value="createdUser">-->
                <input type="email" name="mail" id="mail" ><br/>


                <label for="password">Password </label>
                <input type="password" name="password" id="password"><br/>

                <br/>

                <input type="submit"/>
                <!--<input type="submit" value="Enviar" class="button"/>-->
                <input type="reset" value="Limpiar Campos" class="button"/>

            </form>


            <footer>
                <%@include file="navegation.jsp" %>
            </footer>
        </div>
    </body>
    <!-- <script src="miScript.js" type="text/javascript"></script> -->
</html>
