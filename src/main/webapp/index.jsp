<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web notes</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Bootstrap -->
    <link href="../css/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="header">LOGIN</h1>
        <form class="form-horizontal col-lg-10" role="form" method="post" action="/login">
            <div class="form-group">
                <label class="col-sm-2 control-label">Login</label>
                <div class="col-sm-10">
                    <input  class="form-control" NAME="email" placeholder="Email" value="admin">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" NAME="password" placeholder="Password" value="a">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-primary" type="submit">Sign In</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
