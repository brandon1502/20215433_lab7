<%@ page import="com.example.lab7_20215433.beans.Employees" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: BRANDON
  Date: 6/06/2024
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<Employees> lista = (ArrayList<Employees>) request.getAttribute("lista");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista de Empleados</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>

        <div class="container" style="max-width: 60%;">
            <div class="clearfix mt-3 mt-2">
                <a href="<%=request.getContextPath()%>/">
                    <h1 class="float-start link-dark">Lista de Trabajos</h1>
                </a>
                <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/?action=new">Crear trabajo</a>
            </div>
            <hr/>
            <table class="table table-striped mt-3">
                <thead>
                    <tr class="table-primary">
                        <th>Empleado</th>
                        <th>Email</th>
                        <th>Fecha de contrato</th>
                        <th>ID de trabajo</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Employees employee : lista) { %>
                    <tr>
                        <td><%= employee.getFullNameEmployee() %></td>
                        <td><%= employee.getEmail() %></td>
                        <td><%= employee.getHireDate() %></td>
                        <td><%= employee.getJob_id() %></td>
                        <td><a class="btn btn-success" href="<%=request.getContextPath()%>/?action=edit&id=<%= employee.getEmployee_id() %>">Editar</a></td>

                        <td><a onclick="return confirm('¿Esta seguro de borrar?')" class="btn btn-danger" href="<%=request.getContextPath()%>/?action=del&id=<%= employee.getEmployee_id() %>">Borrar</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

    </body>
</html>
