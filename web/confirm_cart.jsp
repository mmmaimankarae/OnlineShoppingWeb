<%-- mmmaimankarae --%>

<%@page import="java.util.Iterator"%>
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
            .checkout-button {
                font-family: Arial, sans-serif;
                font-size: 16px;
                display: inline-block;
                margin: 10px;
                text-decoration: none;
                color: #333;
                background-color: #fff;
                padding: 10px 25px;
                border-radius: 5px;
                border: none;
            }
            .checkout-button:hover {
                background-color: #0A8A4F;
                color: #fff;
            }
            .select-more-button {
                display: inline-block;
                margin: 10px;
                text-decoration: none;
                color: #333;
                background-color: #fff;
                padding: 10px 20px;
                border-radius: 5px;
            }
            .select-more-button:hover {
                background-color: #cc0000;
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
            .footer {
                display: flex;
                justify-content: flex-end;
                padding: 20px;
        }
        </style>
    </head>

    <%
        int totalPrice = 0;
        CalculatorPrice cal = new CalculatorPrice();
        List<Products> selectedProducts = (List<Products>) session.getAttribute("selectedProducts");
        if (selectedProducts != null && !selectedProducts.isEmpty()) {
    %>
    <body>
        <center>
        <h1>YOUR ORDER CART
        </h1>
        <form action="ConfirmTheOrderController" method="POST">
        <table border="1">
            <%
            for (Products product : selectedProducts) {
            %>
            <tr>
                <th>DVD Names</th>
                <th>Rating</th>
                <th>Year</th>
                <th>Price/Unit</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <tr>
                <td><%= product.getMovie() %></td>
                <td><%= product.getRating() %></td>
                <td><%= product.getRating() %></td>
                <td><%= product.getPrice() %></td>
    <%
                int productId = product.getId();
                int qty = Integer.parseInt(request.getParameter("quantity" + productId));
                int price = product.getPrice();
                int sum = cal.sumOfMovie(qty, price);
                    totalPrice += sum;
                    out.println("<td> "+ qty + "</td>");
                    out.println("<td> "+ sum + "</td>");
                    %>
                <input type="hidden" name="productId" value="<%= productId %>">
                <input type="hidden" name="quantity<%= product.getId() %>" value="<%= qty %>">
                <%
            }
        }
    %>
                <tr>
                    <td colspan="5", style="text-align: center;"> Total </td>
                    <td> <%= totalPrice %> </td>
                    <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                </tr>
            </tr>
        </table>
            <button type="submit" class="checkout-button">Check out</button>
            <a href="add_theorder.jsp" class = "select-more-button" >Select More Order</a>
        </form>
    </center>
        <div class="footer">
            <a href="index.html">I'm want to cancle</a>
        </div>
    </body>
</html>