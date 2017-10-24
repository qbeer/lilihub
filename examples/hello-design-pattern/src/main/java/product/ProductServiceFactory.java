package product;

public class ProductServiceFactory {

    public static ProductService makeProductService(String type) {
        if ("DEBUG".equals(type)) {
            return new DebugProductService();
        }

        return new ProductServiceImpl();
    }

}
