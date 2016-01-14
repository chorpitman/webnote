<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Note</title>
</head>
<body>
<table border="1px">
    <tr>
        <td colspan="5">
            <form action="add" method="post">
                title<br>
                <input type="text" name="title"><br>
                category<br>
                <input type="text" name="category"><br>
                description<br>
                <input type="text" name="description"><br>
                <br>
                <input type="submit" name="ok" value="OK!">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
