package cs.ui.ac.id.advprog.eshop.service;

import cs.ui.ac.id.advprog.eshop.model.Product;

import java.util.List;

public interface ProductService {
    public Product create(Product product);

    public List<Product> findAll();
}
