<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Web notes</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <script type="text/javascript" src="../js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../js/app/main.js"></script>

    <!-- Bootstrap -->
    <link href="../css/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/lib/bootstrap/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h1 class="header">ALL NOTES</h1>
    <%--<h3 class="header">${pageContext.session.id}</h3>--%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="text-center">DATE NOTE</th>
            <th class="text-center">TITLE</th>
            <th class="text-center">CATEGORY</th>
            <th class="text-center">DESCRITION</th>
            <th class="text-center">EDIT</th>
            <th class="text-center">DELETE</th>
        </tr>
        </thead>
        <tbody class="text-center" id="addCopyItem">

        <c:forEach var="note" items="${notes}">
            <tr id="${note.id}" class="note">
                <td class="note_date text-left"><fmt:formatDate pattern="dd.MM.yyyy, HH:mm:ss"
                                                                value="${note.date}" /></td>
                <td class="note_title text-left"><c:out value="${note.title}"/></td>
                <td class="note_category text-left"><c:out value="${note.category}"/></td>
                <td class="note_description text-justify"><c:out value="${note.description}"/></td>
                <td>
                    <button type="button" class="btn btn-success btn-sm editNote" data-toggle="modal" data-target="#myModal">EDIT</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger btn-sm deleteNote">DELETE</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <button type="button" class="btn btn-info btn-md editNote" data-toggle="modal" data-target="#myModalAdd">
        ADD NEW NOTE
    </button>

    <jsp:include page="editNote.jsp"/>
    <jsp:include page="addNote.jsp"/>
    <jsp:include page="itemNote.jsp"/>

</div>
</body>
</html>