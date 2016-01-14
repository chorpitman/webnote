<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Webnote</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>


    <%--<!-- Bootstrap -->--%>
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <!-- скрипт прогресс бара -->
    <script type="text/javascript">
        jQuery(document).ready(function () {

            $('textarea').keyup(function () {
                var box = $(this).val();
                var percent = (box.length / (1500 / 100)).toFixed(2);

                var main = box.length * 100;
                var value = (main / 100);
                var count = 0 + box.length;
                var reverse_count = 100 - box.length;

                if (box.length >= 0) {
                    $('.progress-bar').css('width', percent + '%');
                    $('.current-value').text(percent + '%');
                    $('.count').text(reverse_count);

                    if (count >= 750 && count < 1275) {
                        $('.progress-bar').removeClass('progress-bar-danger').addClass('progress-bar-warning');
                    }
                    if (count > 1275) {
                        $('.progress-bar').removeClass('progress-bar-warning').addClass('progress-bar-danger');
                    }
                    if (count >= 0 && count < 750) {
                        $('.progress-bar').removeClass('progress-bar-danger');
                        $('.progress-bar').removeClass('progress-bar-warning');
                        $('.progress-bar').addClass('progress-bar-success')
                    }

                }
                return false;
            });
        });
    </script>
    <!-- скрипт прогресс бара -->
</head>

<body>

<div class="container">
    <div class="col-sm-6">
        <h1 class="header">ADD NEW NOTE</h1>
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
            <div class="form-group">
                <label for="" class="col-sm-2 control-label"></label>
                <div class="progress col-sm-10">

                    <!-- прогресс бар -->
                    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0"
                         aria-valuemin="0" aria-valuemax="1500" style="width: 0%;">0%
                    </div>
                    <span class="current-value">0%</span>
                </div>
                <!-- прогресс бар -->


                <!-- кнопка   -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success">add note</button>
                    </div>
                </div>
                <!-- кнопка   -->
            </div>
        </form>
    </div>
</div>


</body>
</html>