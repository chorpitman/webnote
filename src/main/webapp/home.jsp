<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Webnote</title>

    <script type="text/javascript" src="../js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../js/test.js"></script>

    <!-- Bootstrap -->
    <link href="../js/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                <td><c:out value="${note.date}"/></td>
                <td><c:out value="${note.title}"/></td>
                <td><c:out value="${note.category}"/></td>
                <td><c:out value="${note.description}"/></td>
                <td>
                    <button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#myModal">
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
    <a href="/add" class="btn btn-primary" role="button">ADD NEW NOTE</a>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">web-notes.com</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">EDIT NOTE</h4>
                </div>
                <div class="modal-body">
                    <%--боди mодального окна--%>
                    <div class="container">
                        <div class="col-sm-6">
                            <form class="form-horizontal" role="form" id="formId" method="post">

                                <div class="form-group">
                                    <label for="inputTitle" class="col-sm-2 control-label">Title</label>
                                    <div class="col-sm-10">
                                        <input name="tytle" type="text" class="form-control" id="inputTytle"
                                               placeholder="Input tytle for note">
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
                                    <label for="inputDescription" class="col-sm-2 control-label">Description</label>

                                    <!-- текст арея -->
                                    <div class="col-sm-10">
                    <textarea class="form-control" rows="3" maxlength="1500"
                              placeholder="Describe your note"></textarea>
                                    </div>
                                    <!-- <div class = "count btn btn-primary">1500</div> -->

                                    <!-- текст арея -->
                                </div>

                                <!-- описание + текст арея -->
                                <%--<div class="form-group">--%>
                                <%--<label for="" class="col-sm-2 control-label"></label>--%>
                                <%--<div class="progress col-sm-10">--%>

                                <%--<!-- прогресс бар -->--%>
                                <%--<div class="progress-bar progress-bar-striped active" role="progressbar"--%>
                                <%--aria-valuenow="0"--%>
                                <%--aria-valuemin="0" aria-valuemax="1500" style="width: 0%;">0%--%>
                                <%--</div>--%>
                                <%--<span class="current-value">0%</span>--%>
                                <%--</div>--%>
                                <%--<!-- прогресс бар -->--%>


                                <%--<!-- кнопка   -->--%>
                                <%--<div class="form-group">--%>
                                <%--<div class="col-sm-offset-2 col-sm-10">--%>
                                <%--<button type="submit" class="btn btn-success">add note</button>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--<!-- кнопка   -->--%>
                                <%--</div>--%>
                            </form>
                        </div>
                    </div>
                    <%--боди mодального окна--%>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal -->
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>