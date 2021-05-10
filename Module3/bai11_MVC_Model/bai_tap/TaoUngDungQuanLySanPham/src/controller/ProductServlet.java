package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/", "/products"})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();
    private ArrayList<Product> products = productService.getAllProduct();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNewProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/detail.jsp");
        }
        request.getRequestDispatcher("product/detail.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("product/create.jsp");
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product = new Product(products.size() + 1, name, description, price);
        this.productService.addNewProduct(product);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product = this.productService.findById(id);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            product.setProductName(name);
            product.setProductDesc(description);
            product.setProductPrice(price);
            productService.updateProduct(id, product);
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/delete.jsp").forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            this.productService.removeProduct(id);
            response.sendRedirect("/products");
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String searchName = request.getParameter("search").toLowerCase();
        Product product = this.productService.findByName(searchName);
        if(product == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else {
            if(product.getProductId() == 1){
                if(product.getProductName().toLowerCase().equals(searchName)){
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("product/detail.jsp").forward(request, response);
                }
                else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
            else {
                request.setAttribute("product", product);
                request.getRequestDispatcher("product/detail.jsp").forward(request, response);
            }
        }
    }
}
