package ru.geekbrains.service;

import ru.geekbrains.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(long id);
}
