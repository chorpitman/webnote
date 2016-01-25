<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>web-notes.com</title>

    <script type="text/javascript" src="../js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../js/test.js"></script>

    <!-- Bootstrap -->
    <link href="../js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h1 class="header">All notes</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>NOTE ID</th>
            <th>DATE NOTE</th>
            <th>TITLE</th>
            <th>CATEGORY</th>
            <th>DESCRITION</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        </thead>
        <tbody class="text-center">

        <c:forEach var="note" items="${notes}">
            <tr id="${note.id}" class="note">
                <td><c:out value="${note.id}"/></td>
                <td class="note_date"><c:out value="${note.date}"/></td>
                <td class="note_title"><c:out value="${note.title}"/></td>
                <td class="note_category"><c:out value="${note.category}"/></td>
                <td class="note_description"><c:out value="${note.description}"/></td>
                <td>
                    <button type="button" class="btn btn-success btn-xs editNote" data-toggle="modal"
                            data-target="#myModal">
                        EDIT
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger btn-xs">DELETE</button>
                </td>
                    <%--<td><a class="edit" href="#myModal">EDIT</a></td>--%>
                    <%--<td><a class="delete" id="${note.id}" href="#">DELETE</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <button type="button" class="btn btn-info btn-lg editNote" data-toggle="modal"
            data-target="#myModalAdd">
        ADD NEW NOTE
    </button>

    <!-- Modal START (FOR EDIT BUTTON)-->
    <div class="modal fade" id="myModal" tabindex="-1" role="
    dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">web-notes.com</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">ADD NOTE SERVICE</h4>
                </div>
                <div class="modal-body">
                    <%--body of modal window  START--%>
                    <div class="container">
                        <div class="col-sm-6">
                            <form class="form-horizontal" role="form" id="formId" method="post">

                                <div class="form-group hidden">
                                    <label class="col-sm-2 control-label">id</label>
                                    <div class="col-sm-10">
                                        <input name="id" type="text" class="form-control" id="idNote"
                                               placeholder="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Title</label>
                                    <div class="col-sm-10">
                                        <input name="title" type="text" class="form-control" id="inputTitle"
                                               placeholder="Input title for note">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputCategory" class="col-sm-2 control-label">Category</label>
                                    <div class="col-sm-10">
                                        <input name="category" type="text" class="form-control" id="inputCategory"
                                               placeholder="Input category for note">
                                    </div>
                                </div>

                                <!-- описание + текст арея -->
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Description</label>

                                    <!-- текст арея -->
                                    <div class="col-sm-10">
                    <textarea class="form-control" rows="3" maxlength="1500"
                              placeholder="Describe your note" id="description" name="description"></textarea>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                    <%--body of modal window END--%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="saveChangesOnNote" data-dismiss="modal">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal END (FOR EDIT BUTTON)-->

    <!-- Modal START (FOR ADD BUTTON)-->
    <div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">web-notes.com</span>
                        <span class="sr-only">web-notes.com add</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabelAdd">ADD NOTE SERVICE</h4>
                </div>
                <div class="modal-body">
                    <%--body of modal window  START--%>
                    <div class="container">
                        <div class="col-sm-6">
                            <form class="form-horizontal" role="form" id="addFormId" method="post">

                                <%--<div class="form-group">--%>
                                    <%--<label class="col-sm-2 control-label">id</label>--%>
                                    <%--<div class="col-sm-10">--%>
                                        <%--<input name="id" type="text" class="form-control" id="addIdNote"--%>
                                               <%--placeholder="id">--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Title</label>
                                    <div class="col-sm-10">
                                        <input name="title" type="text" class="form-control" id="addInputTitle"
                                               placeholder="Input title for note">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="inputCategory" class="col-sm-2 control-label">Category</label>
                                    <div class="col-sm-10">
                                        <input name="category" type="text" class="form-control" id="addInputCategory"
                                               placeholder="Input category for note">
                                    </div>
                                </div>

                                <!-- описание + текст арея -->
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Description</label>

                                    <!-- текст арея -->
                                    <div class="col-sm-10">
                    <textarea class="form-control" rows="6" maxlength="1500"
                              placeholder="Describe your note" id="addFormDescription" name="description"></textarea>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                    <%--body of modal window END--%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="saveAddNote" data-dismiss="modal">Save note</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal END (FOR ADD BUTTON)-->

</div>
</body>
</html>