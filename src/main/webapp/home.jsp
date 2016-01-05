<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <script type="text/javascript" src="js/test.js"></script>
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

    <%--<c:forEach var="note" items="${notes}">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${note.id}"/></td>--%>
            <%--<td><c:out value="${note.date}"/></td>--%>
            <%--<td><c:out value="${note.title}"/></td>--%>
            <%--<td><c:out value="${note.category}"/></td>--%>
            <%--<td><c:out value="${note.description}"/></td>--%>
            <%--<td><a href="#" >edit</a></td>--%>
            <%--<td><a href="#" >delete</a></td>--%>
    <%--</c:forEach>--%>
</table>
<a href="/add">add</a>
</body>
</html>