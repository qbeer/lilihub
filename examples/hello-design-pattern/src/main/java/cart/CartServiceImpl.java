package cart;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartServiceImpl implements CartService {

    private Map<String, Cart> carts;

    public CartServiceImpl(){
        carts = new HashMap<>();
    }

    @Override
    public void addProduct(String user, Product product) {
        getCartByUser(user).addProduct(product);
    }

    @Override
    public void removeProduct(String user, Product product) {
        getCartByUser(user).removeProduct(product);
    }

    @Override
    public int getValue(String user) {
        Cart cart = getCartByUser(user);
        return cart.getValue();
    }

    @Override
    public Cart getCart(String user) {
        return getCartByUser(user);
    }

    private Cart getCartByUser(String user) {
        if (!carts.containsKey(user)) {
            carts.put(user, new Cart(user));
        }

        return carts.get(user);
    }
}
