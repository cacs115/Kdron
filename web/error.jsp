<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos en Linea</title>
        <link href="styles.css" rel="stylesheet" type="text/css"/>    
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Usuario o contraseña no encontrado</h1>
            </header>
            <main>
                <form action='Controller' style="margin-top: 0px;height:250px;zoom: 1;
                      filter: alpha(opacity=50);
                      opacity: 0.9;" >
                    <p style="padding-top: 0px">Uff que pena usuario no encontrado, debes registrarte</p>
                    <div>
                        <label for="mail">Email:</label>
                        <input type="email" id="mail" name="mail" required />
                        <input type="hidden" name="opcion" value="register" />

                    </div>
                    <div>
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required />
                    </div>
                    <div class="button">
                        <button id="myButton" type="submit" >Registrarse</button>
                    </div>
                </form>
            </main>




            <footer>
            </footer>
        </div>
    </body>
</html>
