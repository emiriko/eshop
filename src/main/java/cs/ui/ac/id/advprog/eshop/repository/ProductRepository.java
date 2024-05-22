package cs.ui.ac.id.advprog.eshop.repository;

import cs.ui.ac.id.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        List<Product> result = productData.stream().filter(product -> product.getProductId().equals(productId)).toList();

        return result.getFirst();
    }

    public Product editProduct(Product product) {
        Product newProduct = findById(product.getProductId());

        newProduct.setProductName(product.getProductName());
        newProduct.setProductQuantity(product.getProductQuantity());

        return newProduct;
    }

    public void deleteProduct(String productId) {
        Product selectedProduct = findById(productId);

        productData.remove(selectedProduct);
    }


}
