<%-- mmmaimankarae --%>

<%@page import="java.util.Iterator"%>
<%@page import="model.ShoppingTable"%>
<%@page import="model.ShoppingcartPK"%>
<%@page import="model.Shoppingcart"%>
<%@page import="model.ProductsTable"%>
<%@page import="model.Products"%>
<%@page import="model.CalculatorPrice"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SHOW YOUR ORDER</title>
        
        <%-- PART OF CSS TO IMPROVE UI
          --  body = defind front and background-color
          --  center, h1 = defind position and color of header 1
          --  table = defind style of table
          --  th, td = defind style header of table
          --  a = defind style of link
          --  a:hover = defind the action, while mouse is hovering the box 
        --%>
        
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }
            center {
                text-align: center;
                padding: 20px;
            }
            h1 {
                color: #333;
            }
            table {
                border-collapse: collapse;
                width: 80%;
                margin: 20px auto;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            table, th, td {
                border: 1px solid #ccc;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #333;
                color: #fff;
            }
            a {
                display: inline-block;
                margin: 10px;
                text-decoration: none;
                color: #333;
                background-color: #fff;
                padding: 10px 20px;
                border-radius: 5px;
            }
            a:hover {
                background-color: #555;
                color: #fff;
            }
        </style>
    </head>
    <%
        String cartId = request.getParameter("id");
        ShoppingcartPK cart = ShoppingTable.findCARTid(Integer.parseInt(cartId));
        
        int movieId = cart.getMovieId();
        Products pro = ProductsTable.findProductByMovieId(movieId);
        
        List<Shoppingcart> detail = ShoppingTable.detailOrder(Integer.parseInt(cartId));
        CalculatorPrice cal = new CalculatorPrice();
    %>
    <body>
        <center>
        <h1>ORDER CART ID:
            <% 
                out.println(cart.getCartId());
            %>
        </h1>
        <table border="1">
            <tr>
                <th>DVD Names</th>
                <th>Rating</th>
                <th>Year</th>
                <th>Price/Unit</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <tr>
                <td><%= pro.getMovie() %></td>
                <td><%= pro.getRating() %></td>
                <td><%= pro.getYearcreate() %></td>
                <td><%= pro.getPrice() %></td>
                <%
                    int totalPrice = 0;
                    for (Shoppingcart list : detail) {
                        int qty = list.getQuantity();
                        int price = pro.getPrice();
                        int sum = cal.sumOfMovie(qty, price);
                        totalPrice += sum;
                        out.println("<td> "+ qty + "</td>");
                        out.println("<td> "+ sum + "</td>");
                    }
                %>
                <tr>
                    <td colspan="5", style="text-align: center;"> Total </td>
                    <td> <%= totalPrice %> </td>
                </tr>
            </tr>
        </table>
        <a href="index.html">Back to Menu</a>
        </center>
    </body>
</html>
