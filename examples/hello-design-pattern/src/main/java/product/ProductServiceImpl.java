package product;

import model.Product;
import store.ProductStore;

import java.util.Collection;

public class ProductServiceImpl implements ProductService {

    private final ProductStore store;

    public ProductServiceImpl() {
        store = ProductStore.getINSTANCE();
    }

    @Override
    public Collection<Product> getAvailableProducts() {
        return store.getProducts();
    }

    @Override
    public Product getProductById(Long productId) {
        return store.getProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        store.registerProduct(product);
    }

    @Override
    public void removeProduct(Product product) {
        store.removeProduct(product);
    }

    @Override
    public Product grabProduct(Long productId) {
        Product product = store.getProductById(productId);
        store.removeProduct(product);
        return product;
    }
}
