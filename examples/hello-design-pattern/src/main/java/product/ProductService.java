package product;

import model.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getAvailableProducts();

    Product getProductById(Long productId);

    // Admin stuff
    void addProduct(Product product);

    // Admin stuff
    void removeProduct(Product product);

    // User stuff
    Product grabProduct(Long productId);

}
