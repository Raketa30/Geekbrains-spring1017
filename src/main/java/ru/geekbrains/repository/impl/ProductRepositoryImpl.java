package ru.geekbrains.repository.impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.domain.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "first", 7.62));
        products.add(new Product(2, "second", 11.3));
        products.add(new Product(3, "third", 4.63));
        products.add(new Product(4, "fourth", 2.55));
        products.add(new Product(5, "fifth", 7.50));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(long id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
