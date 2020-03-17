<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="domain.db.DierDB" %>
<%@page import="domain.model.Dier" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bekijk alle dieren</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Overview"/>
    </jsp:include>
    <main>
        <h2>Bekijk alle dieren</h2>
        <c:choose>
            <c:when test="${empty dieren}">
                <p>Er zijn geen dieren geregistreerd.</p>
            </c:when>
            <c:otherwise>

                <table>
                    <thead>
                    <tr>
                        <th>Naam</th>
                        <th>Soort</th>
                        <th>Voedsel</th>
                    </thead>
                    <tbody>
                    <c:forEach var="dier" items="${dieren}">
                        <tr>
                            <td>${dier.naam}
                            </td>
                            <td>${dier.soort}
                            </td>
                            <td>${dier.voedsel}
                            </td>
                        </tr>
                    </c:forEach></tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>