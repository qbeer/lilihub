package payment.strategy;

import cart.Cart;

public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Cart cart) {
        System.out.println(cart.getValue() + " HUF has been paid by PayPal");
    }
}
