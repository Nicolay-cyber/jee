package com.geekbrains.app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product("Orange", 1, 100),
                new Product("Apple", 2, 200),
                new Product("Curtain", 3, 300),
                new Product("Lime", 4, 400),
                new Product("Coat", 5, 500),
                new Product("Pillowcase", 6, 600),
                new Product("Ice cream", 7, 150),
                new Product("Lamp", 8, 250),
                new Product("Beef ground", 9, 350)
        ));
    }

    public Product getProdById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElseThrow(() -> new NullPointerException());
    }
    public List<Product> getAllProducts() {
        return products;
    }
}
