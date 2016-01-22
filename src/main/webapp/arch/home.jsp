<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="../js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../js/test.js"></script>
</head>
<body>
<h1>WEB NOTES</h1>

<table border="1px">
    <tr>
        <th>NOTE ID</th>
        <th>DATE NOTE</th>
        <th>TITLE</th>
        <th>CATEGORY</th>
        <th>DESCRITION</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="noteRest" items="${notes}">
        <tr>
            <td><c:out value="${noteRest.id}"/></td>
            <td><c:out value="${noteRest.date}"/></td>
            <td><c:out value="${noteRest.title}"/></td>
            <td><c:out value="${noteRest.category}"/></td>
            <td><c:out value="${noteRest.description}"/></td>
            <td><a class="edit" href="#">edit</a></td>
            <td><a href="#">delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add">add</a>
<div id="res"></div>
</body>
</html>