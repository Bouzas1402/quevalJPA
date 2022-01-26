<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
</body>
</html>