<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>web-notes.com</title>

    <script type="text/javascript" src="../js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>

    <!-- Bootstrap -->
    <link href="../js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
    <div>
        <form class="form-horizontal col-lg-10" role="form" method="post" action="/login">
            <div class="form-group">
                <label class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input  class="form-control" NAME="inputEmail" placeholder="Email" value="admin">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" NAME="inputPassword" placeholder="Password" value="qwerty">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-default">Sign in</input>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
