package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Products;
import model.ProductsTable;

public class AddCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] movies = request.getParameterValues("movies");
        
        if (movies != null) {
            List<Products> selectedProducts = new ArrayList<>();
    
            for (String movieId : movies) {
                int id = Integer.parseInt(movieId);
                Products product = ProductsTable.findProductByMovieId(id);
                selectedProducts.add(product);
            }

            HttpSession session = request.getSession();
            session.setAttribute("selectedProducts", selectedProducts);
            request.getRequestDispatcher("confirm_cart.jsp").forward(request, response);
        }
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
