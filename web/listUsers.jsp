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
                <h1>Listar Usuario</h1>
            </header>

            <%@include file="navegation.jsp" %>

            <main >
                <table align="center" class="tectTable">
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Nombre</th>
                            <th>Password</th>
                            <th>Role</th>
                            <th>Operación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            // Se recupera la variable de session listaUsuario
                            List<User> userList
                                    = (List<User>) request.getAttribute("userList");
                            for (User u : userList) {
                                out.println("<tr>");
                                out.println("<td>" + u.getUserId() + "</td>");
                                out.println("<td>" + u.getMail() + "</td>");
                                out.println("<td>" + u.getPassword() + "</td>");
                                out.println("<td>" + u.getRoleID() + "</td>");
                                out.println("<td><a href= 'Controller?opcion=deleteUser&userId="
                                        + u.getUserId() + "'>Borrar</a></td>");
//                                out.println("<td><a href= 'Controller?opcion=editUser&userId="
//                                        + u.getUserId() + "'>Editar</a></td>");
                                out.println("</tr>");
                            }
                        %>
                    </tbody>
                </table>
            </main>
            <footer>
            </footer>
        </div>
    </body>
</html>
