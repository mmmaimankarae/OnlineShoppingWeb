package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Products;
import model.ProductsTable;
import model.ShoppingTable;
import model.Shoppingcart;
import model.ShoppingcartPK;

public class ConfirmTheOrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] productIds = request.getParameterValues("productId");
        List<Shoppingcart> shoppingcartList = ShoppingTable.findAllCART();
        int cartId;
        if (shoppingcartList.isEmpty()) {
            cartId = 1;
        }else {
                Shoppingcart lastProduct = shoppingcartList.get(shoppingcartList.size() - 1);
                cartId = lastProduct.getShoppingcartPK().getCartId()+1;
        }
        for (int i = 0; i < productIds.length; i++) {
            for (String productId : productIds) {
                    int quantity = Integer.parseInt(request.getParameter("quantity" + productId));
                    int Id =Integer.parseInt(productId);
                    Products prod = ProductsTable.findProductByMovieId(Id);
                    Shoppingcart cart = new Shoppingcart();
                    ShoppingcartPK cartPK = new ShoppingcartPK(cartId, Id);
                    cart.setShoppingcartPK(cartPK);
                    cart.setQuantity(quantity);
                    cart.setProducts(prod);
                    ShoppingTable.insertOrder(cart);
            }        
        }
        request.getRequestDispatcher("show_cforder.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
