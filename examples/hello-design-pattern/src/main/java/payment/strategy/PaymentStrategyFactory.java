package payment.strategy;

import payment.PaymentMethod;

public class PaymentStrategyFactory {

    public static PaymentStrategy makePaymentStrategy(PaymentMethod method) {
        switch (method) {
            case CREDIT_CARD: return new CreditCardPaymentStrategy();
            case PAYPAL: return new PayPalPaymentStrategy();
            default:
                return new CashPaymentStrategy();
        }
    }

}
