<%-- 
    Document   : error
    Created on : Nov 25, 2020, 1:48:15 PM
    Author     : sarun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating Notification</title>
    </head>
    <body>
        <h1><%= request.getAttribute("errMsg")%></h1>
        <a href="index.html">Back to Menu</a>
    </body>
</html>
