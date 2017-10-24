package cart;

import model.Product;

public interface CartService {

    void addProduct(String user, Product product);

    void removeProduct(String user, Product product);

    int getValue(String user);

    Cart getCart(String user);

}
