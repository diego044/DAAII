<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <div class="container mt-4">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <h4>Agregar nuevo registro</h4>
                </div>
            </div>
            
            <div class="card-body">
                <form method="POST">
                    <label>Nombre :</label>
                    <input type="text" name="nombre" class="form-control">
                    <label>Apellido :</label>
                    <input type="text" name="apellido" class="form-control">
                    <label>Correo :</label>
                    <input type="text" name="correo" class="form-control">
                    <label>Direccion :</label>
                    <input type="text" name="direccion" class="form-control">
                    
                    <input type="submit" value="agregar" class="btn btn-success">
                    <a href="index.htm">Regresar</a>
                    
                </form>
            </div>
        
        </div>
  
    </body>
</html>
