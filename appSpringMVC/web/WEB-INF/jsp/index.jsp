<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- EXPRESSION LANGUAGE: -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto MVC con Spring</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="container mt-4">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-light" href="agregar.htm">Nuevo Registro</a>
                </div>
            </div>
            
            <div class="card-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Dirección</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <!-- JSTL:-->
                        <c:forEach var="registro" items="${Lista}">
                            <tr>
                                <td> ${registro.id}   </td>
                                <td> ${registro.nombre} ${registro.apellido}  </td>
                                <td> ${registro.correo}  </td>
                                <td> ${registro.direccion}   </td>
                                <td>
                                    <a href="editar.htm?id=${registro.id}" class="btn btn-warning"> Editar</a>
                                    <a href="delete.htm?id=${registro.id}" class="btn btn-danger"> Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        
    </body>
</html>
