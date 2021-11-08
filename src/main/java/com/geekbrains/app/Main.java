package com.geekbrains.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.app");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        Scanner scanner;
        System.out.println(
                "Commands:\n" +
                        "q - quit\n" +
                        "shop - show all products\n" +
                        "add *product's id* - add product to cart\n" +
                        "remove *product's number in the cart* - remove product from cart\n"
        );
        while (true) {

            System.out.println("Your cart:");

            System.out.println(cart.getCart());
            scanner = new Scanner(System.in);
            try {
                String request = scanner.nextLine();
                String[] req = request.split(" ", 2);
                switch (req[0]) {
                    case "q": {
                        if (req.length > 1) {
                            throw new Exception();
                        }
                        context.close();
                        System.exit(1);
                    }
                    case "shop": {
                        if (req.length > 1) {
                            throw new Exception();
                        }
                        for (Product product : productRepository.getAllProducts()) {
                            System.out.println(product);
                        }
                        break;
                    }
                    case "add": {
                        int addedProdId = Integer.parseInt(req[1]);
                        cart.addProductToCart(addedProdId);
                        break;
                    }
                    case "remove": {
                        int numProdInCart = Integer.parseInt(req[1]);
                        cart.removeProd(numProdInCart - 1);
                        break;
                    }
                    default: {
                        System.out.println("Wrong request");
                    }
                }
            } catch (Exception e) {
                System.out.println("Wrong request");
            }
            System.out.println("----------------------------");
        }
    }
}
