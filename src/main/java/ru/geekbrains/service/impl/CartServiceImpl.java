package ru.geekbrains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.geekbrains.domain.Product;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class CartServiceImpl implements CartService {

    private final List<Product> products;

    private final ProductService productService;

    @Autowired
    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
        products = new ArrayList<>();
    }

    @Override
    public boolean addProduct(long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            products.add(optionalProduct.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeProduct(long id) {
        return products.removeIf(product -> product.getId() == id);
    }
}
