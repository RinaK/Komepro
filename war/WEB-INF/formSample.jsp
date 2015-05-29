<%-- 
    Document   : formSample
    Created on : 2015/01/19, 17:21:54
    Author     : 
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ユーザー登録</title>
    </head>
    <body>
        <form action="/komepro/FormSampleServlet" method="post">
            名前:<br>
            <input type="text" name="name"></br>
            メールアドレス:<br>
            <input type="text" name="mail"></br>
            電話番号:<br>
            <input type="text" name="phone"></br>
            住所:<br>
            <input type="text" name="adress"></br>
            ユーザーID:<br>
            <input type="text" name="id"></br>
            パスワード:<br>
            <input type="password" name="pass"></br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>