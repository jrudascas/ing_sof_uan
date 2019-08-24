<%-- 
    Document   : create
    Created on : Aug 23, 2019, 6:05:02 PM
    Author     : jrudascas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Crear Estudiante</title>
    </head>
    <body>
    <center>

        <form action="EstudiantesServlet?action=create" method="post">
            <table border="1" width="100%">
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id"><br/>
                    </td>
                </tr>
                <tr>
                    <td>NOMBRES</td>
                    <td>
                        <input type="text" name="nombres"><br/>
                    </td>
                </tr>      
            </table>
            
            <input type="submit" value="Crear">
        </form>    
    </center>
</body>
</html>
