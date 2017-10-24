package cart;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String user;
    private List<Product> products;

    public Cart(String user){
        this.user = user;
        products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    public int getValue() {
        int sum = 0;
        for(Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public String getUser() {
        return user;
    }

}
