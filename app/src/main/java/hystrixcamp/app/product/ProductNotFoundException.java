package hystrixcamp.app.product;

/**
 * @author chanwook
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
