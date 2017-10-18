<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos en Linea</title>
        <link href="MisEstilos.css" rel="stylesheet" type="text/css"/>    
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Bienvenido</h1>
            </header>
            <%@include file="navegation.jsp" %>

            <main>
                <div  style="text-align: center ">
                    <a href="Controller?opcion=createUser" target="_parent"> <button>Crear Usuario</button></a>
                    <a href="Controller?opcion=createPart" target="_parent">  <button>Crear Parte</button></a>


                </div>

                <!--                <select>
                <-%
                    // Se recupera la variable de session listaUsuario
//                            List<User> userList = 
//                                    (List<User>) request.getAttribute("userList");
//                            for (User u : userList) {
//                          
//                                out.println("<option value='u.getMail'>" + u.getMail()+ "</option>");
//                               
//                            }
%>
                           </select>-->
            </main>
            <footer>

            </footer>
        </div>
    </body>

</html>
