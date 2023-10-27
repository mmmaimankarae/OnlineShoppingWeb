<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ShoppingTable"%>
<%@page import="model.Shoppingcart"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            font-size: 16px;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        h1 {
            color: #333;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
    </head>
    <body>
            <%
                int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
                int cartId = ShoppingTable.findLastCART();
            %>
            <h1>
        Your Order is confirmed!<br>
        The total amount is $<%= totalPrice %><br>
        Your Cart Order is <%= cartId %>
    </h1>
    </body>
</html>