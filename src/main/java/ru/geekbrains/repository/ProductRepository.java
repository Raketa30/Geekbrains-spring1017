package ru.geekbrains.repository;

import ru.geekbrains.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Optional<Product> findById(long id);
}
