<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table>
    <thead>
    <tr>
        <th>Date and Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Excess</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${meals}">
        <tr class="<c:if test="${meal.excess eq false}">green</c:if>
                   <c:if test="${meal.excess eq true}">red</c:if>">
            <td>${meal.dateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>${meal.excess}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<style>
    table {
        width: 50%;
        border-width: 2px;
        border-collapse: collapse;
        border-color: #cfcfcf;
        border-style: solid;
    }

    table td, table th {
        border-width: 2px;
        border-color: #cfcfcf;
        border-style: solid;
        padding: 3px;
    }

    table tr.red {
        color: red;
    }

    table tr.green {
        color: green;
    }
</style>
</body>
</html>