package payment.strategy;

import cart.Cart;

public interface PaymentStrategy {

    void pay(Cart cart);

}
