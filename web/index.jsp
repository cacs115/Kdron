<%-- 
    Document   : index
    Created on : 29/09/2017, 12:42:53 AM
    Author     : Carlos Correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <main>
            <form action='Controller'>
                <div>
                    <label for="mail">Email:</label>
                    <input type="email" id="mail" name="mail" required />
                <input type="hidden" name="opcion" value="login" />

                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required />
                </div>
                <div class="button">
                    <button id="myButton" type="submit" >Iniciar Sesión</button>
                </div>
            </form>
        </main>
    </body>
<!--    <script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "Controller";
    };
</script>-->
</html>
