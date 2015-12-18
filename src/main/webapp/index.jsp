<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>
<body>
<h2>Hello World!</h2>

<table border="1px">

<c:forEach var="note" items="${notes}">

    <tr>
        <td>id: <c:out value="${note.id}"/></td> ${note.id}
    </tr>

    <tr>
    <td>date <c:out value="${note.date}"/></td>
    </tr>
    <tr>
    <td>title <c:out value="${note.title}"/></td><br>
        </tr>
    <tr>
        <td>category <c:out value="${note.category}"/></td><br>
    </tr>
    <tr>
        <td>description <c:out value="${note.description}"/></td><br>
    </tr>
</c:forEach>
</table>

</body>
</html>