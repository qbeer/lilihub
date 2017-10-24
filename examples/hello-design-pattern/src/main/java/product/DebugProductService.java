package product;

import model.Product;

import java.util.Collection;
import java.util.List;

public class DebugProductService implements ProductService {

    private ProductService service;

    public DebugProductService() {
        service = new ProductServiceImpl();
    }

    @Override
    public Collection<Product> getAvailableProducts() {
        System.out.println("getAvailableProducts has been called");
        return service.getAvailableProducts();
    }

    @Override
    public Product getProductById(Long productId) {
        System.out.println("getProductById has been called");
        return service.getProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("addProduct has been called");
        service.addProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        System.out.println("removeProduct has been called");
        service.removeProduct(product);
    }

    @Override
    public Product grabProduct(Long productId) {
        System.out.println("grabProduct has been called");
        return service.grabProduct(productId);
    }
}
