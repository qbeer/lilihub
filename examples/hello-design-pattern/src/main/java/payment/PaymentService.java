package payment;

import cart.Cart;

public interface PaymentService {

    void pay(Cart cart, PaymentMethod method);

}
