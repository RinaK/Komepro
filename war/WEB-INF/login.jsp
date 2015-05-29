<%-- 
    Document   : login
    Created on : 2015/01/16, 18:09:07
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>米商店</title>
    </head>
    <body>
        <form action="/komepro/loginServlet1" method="post">
        ユーザーID:<input type="text" name="userId"><br>
        パスワード：<input type="password" name="pass"><br>
        <input type="submit" value="ログイン">
        </form>
    </body>
</html>
