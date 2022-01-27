<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JPA - Hibernate - MVC - Krazo</title>
</head>
<body>
<h1>Detalle Pregunta</h1>
<br/>
<div>
    <dl>
        <dt>Código:</dt>
        <dd>${pregunta.codigo}</dd>
        <dt>Texto:</dt>
        <dd>${pregunta.texto}</dd>
        <dt>Dificultad:</dt>
        <dd>${pregunta.dificultad}</dd>
    </dl>
</div>

<div>
    <table>
        <caption><h2>Respuestas</h2></caption>
        <tr>
            <th>ID</th>
            <th>Código</th>
            <th>Texto</th>
        </tr>
        <c:forEach var="respuesta" items="${pregunta.respuestas}">
            <tr>
                <td>${respuesta.id}</td>
                <td>${respuesta.codigo}</td>
                <td>${respuesta.texto}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>