<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <title>Registro</title>
    </head>
    <body>
        <div class='container'>
            <h1 class='mb-3'>Registrar un nuevo employee</h1>
            <form method="post" action="<%=request.getContextPath()%>/">
                <div class="mb-3">
                    <label>Employee ID</label>
                    <input type="text" class="form-control" name="employee_id">
                </div>
                <div class="mb-3">
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="first_name">
                </div>
                <div class="mb-3">
                    <label>Apellido</label>
                    <input type="text" class="form-control" name="last_name">
                </div>
                <div class="mb-3">
                    <label>Email </label>
                    <input type="text" class="form-control" name="email">
                </div>
                <div class="mb-3">
                    <label>Fecha de contratación (tome como referencia el siguiente ejemplo: 1987-06-17 00:00:00)</label>
                    <input type="text" class="form-control" name="hire_date">
                </div>
                <div class="mb-3">
                    <label>Job ID</label>
                    <input type="text" class="form-control" name="job_id">
                </div>



                <a href="<%=request.getContextPath()%>/" class="btn btn-danger">Regresar</a>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
    </body>
</html>
