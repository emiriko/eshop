package cs.ui.ac.id.advprog.eshop.service;

import cs.ui.ac.id.advprog.eshop.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    List<Product> findAll();
}
