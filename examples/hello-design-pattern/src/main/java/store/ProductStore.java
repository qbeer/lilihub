package store;

import model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductStore {

    private static ProductStore INSTANCE;

    private long incrementer = 0;
    private final Map<Long, Product> products;

    private ProductStore(){
        products = new HashMap<>();
    }

    public static ProductStore getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ProductStore();
        }
        return INSTANCE;
    }

    public Product getProductById(Long productId) {
        return products.get(productId);
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public void registerProduct(Product product) {
        products.put(++incrementer, product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}
