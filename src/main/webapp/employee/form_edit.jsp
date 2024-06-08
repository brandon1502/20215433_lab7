<%@ page import="com.example.lab7_20215433.beans.Employees" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employees employee = (Employees) request.getAttribute("employee");
%>
<html>
    <head>
        <title>Editar Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

        <div class="container">
            <h1>Editar Empleado</h1>
            <form action="<%=request.getContextPath()%>/" method="post">

                <input type="hidden" name="action" value="e">
                <input type="hidden" name="employee_id" value="<%=employee.getEmployee_id()%>">

                <div class="mb-3">
                    <label for="full_name" class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" id="full_name" name="full_name" value="<%=employee.getFullNameEmployee()%>" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=employee.getEmail()%>" required>
                </div>

                <div class="mb-3">
                    <label for="hire_date" class="form-label">Fecha de Contratación</label>
                    <input type="text" class="form-control" id="hire_date" name="hire_date" value="<%=employee.getHireDate()%>" required>
                </div>

                <div class="mb-3">
                    <label for="job_id" class="form-label">ID del Trabajo</label>
                    <input type="text" class="form-control" id="job_id" name="job_id" value="<%=employee.getJob_id()%>" required>
                </div>

                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="<%=request.getContextPath()%>/" class="btn btn-danger">Regresar</a>
            </form>
        </div>

    </body>
</html>
