import cart.Cart;
import cart.CartService;
import cart.CartServiceImpl;
import model.Book;
import model.Product;
import model.Television;
import payment.PaymentMethod;
import payment.PaymentService;
import payment.PaymentServiceImpl;
import product.ProductService;
import product.ProductServiceFactory;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        ProductService productService = ProductServiceFactory.makeProductService("DEBUG");

        CartService cartService = new CartServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        Book book = new Book();
        book.setTitle("Lord of the Ring");
        book.setAuthor("John Ronald Reuel Tolkien");
        book.setPrice(3000d);
        book.setDescription("One ring to rule them all.");

        productService.addProduct(book);

        Television television = new Television();
        television.setTitle("Big Screen Television");
        television.setPrice(80000d);
        television.setType(Television.TVType.LED);
        television.setDescription("I'm a tv");

        productService.addProduct(television);

        final String user = "me";

        Collection<Product> availableProducts = productService.getAvailableProducts();

        cartService.addProduct(user, productService.grabProduct(1L) );
        cartService.addProduct(user, productService.grabProduct(2L) );
        cartService.removeProduct(user, television);

        Cart cart = cartService.getCart(user);
        paymentService.pay(cart, PaymentMethod.CREDIT_CARD);
    }

}
