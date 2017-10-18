<%-- 
    Document   : listPart
    Created on : 30/09/2017, 01:52:47 AM
    Author     : Carlos Correa
--%>

<%@page import="Model.Part"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de partes</title>
        <link href="MisEstilos.css" rel="stylesheet" type="text/css"/>    
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Listar partes</h1>
            </header>

            <%@include file="navegation.jsp" %>

            <main >
                <table align="center" class="tectTable">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Peso soportado</th>
                            <th>Bateria</th>
                            <th>ESC</th>
                            <th>Helice</th>
                            <th>Estado</th>
                            <th>Operación</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            // Se recupera la variable de session listaUsuario
                            List<Part> partList
                                    = (List<Part>) request.getAttribute("partList");
                            for (Part p : partList) {
                                out.println("<tr>");
                                out.println("<td>" + p.getPartId() + "</td>");
                                out.println("<td>" + p.getName()+ "</td>");
                                out.println("<td>" + p.getWeightSupported() + "</td>");
                                out.println("<td>" + p.getBatteryCells() + "</td>");
                                out.println("<td>" + p.getEsc() + "</td>");
                                out.println("<td>" + p.getPropeller() + "</td>");
                                out.println("<td>" + p.getStatus() + "</td>");
                                out.println("<td><a href= 'Controller?opcion=deletePart&partId="
                                        + p.getPartId() + "'>Borrar</a></td>");
//                                out.println("<td><a href= 'Controller?opcion=editPart&partId="
//                                        + p.getPartId() + "'>Editar</a></td>");
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
