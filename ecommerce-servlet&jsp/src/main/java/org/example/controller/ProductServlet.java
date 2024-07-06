package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Product;

@WebServlet("/products")
public class ProductServlet extends HelloServlet {

  List<Product> products = new ArrayList<>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("products", products);

    request.getRequestDispatcher("/viewAllProducts.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String name = request.getParameter("name");
    double price = Double.parseDouble(request.getParameter("price"));

    int id = products.size()+1;

    Product product = new Product(id, name, price);

    products.add(product);

    request.setAttribute("products", products);

    request.getRequestDispatcher("/viewAllProducts.jsp").forward(request, response);

  }
}
