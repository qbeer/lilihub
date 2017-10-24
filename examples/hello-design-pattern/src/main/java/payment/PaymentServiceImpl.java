package payment;

import cart.Cart;
import payment.strategy.PaymentStrategy;
import payment.strategy.PaymentStrategyFactory;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public void pay(Cart cart, PaymentMethod method) {
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.makePaymentStrategy(method);
        paymentStrategy.pay(cart);
    }


}
