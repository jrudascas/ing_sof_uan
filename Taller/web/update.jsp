<%-- 
    Document   : update
    Created on : Aug 23, 2019, 6:45:57 PM
    Author     : jrudascas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <center>

            <form action="EstudiantesServlet?action=update" method="post">
                <table border="1" width="100%">
                    <tr>
                        <td>ID</td>
                        <td>
                            <input type="text" name="id" value="${estudiante.getIdEstudiantes()}"><br/>
                        </td>
                    </tr>
                    <tr>
                        <td>NOMBRES</td>
                        <td>
                            <input type="text" name="nombres" value="${estudiante.getNombres()}"><br/>
                        </td>
                    </tr>      
                </table>

                <input type="submit" value="Actualizar">
            </form>    
        </center>
    </body>
</html>

