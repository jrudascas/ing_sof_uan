<%-- 
    Document   : index
    Created on : Aug 23, 2019, 4:56:23 PM
    Author     : jrudascas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Taller de Ejemplo - Hibernate, Servlets, JSP</title>
    </head>
    <body>
    <center>
        <h1>Administrador de estudiantes</h1>
        <h2>
            <a href="create.jsp">Crear</a>
            &nbsp;&nbsp;&nbsp;
            <a href="EstudiantesServlet?action=list">Listar</a>

        </h2>
    </center>

    <table border="1" width="100%">
        <tr>
            <td>ID</td>
            <td>NOMBRES</td>
            <td colspan=2>ACCIONES</td>
        </tr>
        
        <c:forEach var="estudiante" items="${lista}">
            <tr>
                <td><c:out value="${estudiante.getIdEstudiantes()}"/></td>
            <td><c:out value="${estudiante.getNombres()}"/></td>
            <td><a href="EstudiantesServlet?action=showUpdate&id=<c:out value='${estudiante.getIdEstudiantes()}'/>">Editar</a></td>
            <td><a href="EstudiantesServlet?action=delete&id=<c:out value='${estudiante.getIdEstudiantes()}'/>">Eliminar</a></td>	
            </tr>
        </c:forEach>
    </table>
</body>
</html>

