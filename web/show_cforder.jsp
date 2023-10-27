<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
            <%
                int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
            %>
            <h1>
        Your Order is confirmed!<br>
        The total amount is $<%= totalPrice %>
    </h1>
    </body>
</html>