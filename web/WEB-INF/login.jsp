<%-- 
    Document   : login
    Created on : Oct 1, 2019, 9:54:45 AM
    Author     : 745507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1><br>
        <form action="login" method="post">
            Username: <input type="text" name="username" value="${username}">${usernameErrorMsg}<br>
            Password: <input type="text" name="password" value="${password}">${passwordErrorMsg}<br>
            <input type="submit" value="Log in" name="loginButton">
        </form>
        ${loginMsg}
    </body>
</html>
