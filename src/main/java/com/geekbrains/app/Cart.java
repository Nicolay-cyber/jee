package com.geekbrains.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cart {
    private ProductRepository productRepository;
    private List<Product> cart = new ArrayList<>();

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        while (cart.size() < 5) {
            int randomProdId = (int) ((Math.random() * 10) + 1);
            addProductToCart(randomProdId);
        }
    }

    public void addProductToCart(int productId) {
        cart.add(productRepository.getProdById(productId));
    }

    public String getCart() {
        if (cart.isEmpty()) {
            return "Empty";
        }
        StringBuilder cart = new StringBuilder("№ | Id | Product | cost\n");
        for (int i = 0; i < this.cart.size(); i++) {
            cart.append(i + 1).append("   ");
            cart.append(this.cart.get(i).toString()).append("\n");
        }
        return String.valueOf(cart);
    }

    public void removeProd(int numberInCart) {
        cart.remove(numberInCart);
    }
}
