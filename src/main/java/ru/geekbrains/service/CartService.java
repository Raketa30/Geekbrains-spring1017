package ru.geekbrains.service;

public interface CartService {

    boolean addProduct(long id);

    boolean removeProduct(long id);
}
