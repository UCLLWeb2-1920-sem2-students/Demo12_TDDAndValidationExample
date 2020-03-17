<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Voeg een huisdier toe</title>
    <link rel="stylesheet" type="text/css" href="style/style.css"/>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Add"/>
    </jsp:include>
    <main>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h2>Voeg je huisdier toe</h2>
        <form method="POST" action="Controller?command=add" novalidate>
            <p class="form-group ${naamClass}">
                <label class="control-label" for="naam">Naam:</label>
                <input id="naam" name="naam" type="text"
                       value="${naamPreviousValue}">
            </p>
            <p class="form-group ${soortClass}">
                <label class="control-label" for="soort">Soort:</label>
                <input id="soort" name="soort" type="text"
                       value="${soortPreviousValue}">
            </p>
            <p class="form-group ${voedselClass}">
                <label class="control-label" for="voedsel">Aantal keer eten per dag:</label>
                <input id="voedsel" name="voedsel" type="number" max="10" min="1"
                       value="${voedselPreviousValue}">
            </p>
            <p>
                <input type="submit" value="Voeg dier toe" id="submit">
            </p>
            <p class="left">Alle velden zijn verplicht.</p>
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>