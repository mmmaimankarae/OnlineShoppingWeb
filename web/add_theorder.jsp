<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.ProductsTable" %>
<%@ page import="model.Products" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>ADD DVD MOVIE TO YOUR CART</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <%-- PART OF CSS TO IMPROVE UI
          --  body = defind front and background-color
          --  table = defind style of table
          --  th, td = defind style header of table
          --  styled-button = defind style of button
          --  styled-button:hover = defind the action, while mouse is hovering the box
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
        }
        th {
            background-color: #333;
            color: #fff;
            text-align: center;
        }
        .styled-button {
            font-family: Arial, sans-serif;
            font-size: 16px;
            display: block;
            margin: 0 auto;
            text-decoration: none;
            color: #000000;
            background-color: #fff;
            padding: 10px 25px;
            border-radius: 5px;
            border: none;
        }
        .styled-button:hover {
            background-color: #cc0000;
            color: #fff;
        }
        a {
            display: inline-block;
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
<body>
    <center>
    <h1>DVD Catalogs</h1>
    </center>
    <form name="addOrderCART" action="AddCartController" method="POST" onsubmit="return validateForm();">
    <table>
        <thead>
            <tr>
                <th>DVD Names</th>
                <th>Rating</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <% List<Products> productsList = ProductsTable.findAllProducts(); %>
            <% for (Products pro : productsList) { %>
                <tr>
                    <td><input type="checkbox" name="movies" value="<%= pro.getId() %>"/> 
                        <%= pro.getMovie() %>
                    </td>
                    <td><%= pro.getRating() %></td>
                    <td><%= pro.getYearcreate() %></td>
                    <td><%= pro.getPrice() %></td>
                    <td><input type="number" name="quantity<%= pro.getId() %>" style="width: 100%;"</td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <input type="submit" value="Add to Cart" name="submit" class="styled-button"/>
    <div class="footer">
        <a href="index.html">Back to Menu</a>
    </div>
</body>
</html>