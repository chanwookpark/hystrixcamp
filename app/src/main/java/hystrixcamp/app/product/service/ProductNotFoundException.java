package hystrixcamp.app.product.service;

/**
 * @author chanwook
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
