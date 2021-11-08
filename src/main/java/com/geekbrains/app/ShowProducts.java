package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "ShowProducts", urlPatterns = "/prod")
public class ShowProducts extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ShowProducts.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Show 10 products");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");

        Product [] products = new Product[] {
                new Product("Orange", 1, 100),
                new Product("Apple", 2, 200),
                new Product("Certain", 3, 300),
                new Product("Lime", 4, 400),
                new Product("Coat", 5, 500),
                new Product("Pillowcase", 6, 600),
                new Product("Ice cream", 7, 150),
                new Product("Lamp", 8, 250),
                new Product("Beef ground", 9, 350),
                new Product("Sugar", 10, 450)
        };
        for (Product p: products) {
            resp.getWriter().printf("<html><body><h1>%s</h1></body></html>", p);
        }

        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
        logger.info("10 products have shown");
    }
}
