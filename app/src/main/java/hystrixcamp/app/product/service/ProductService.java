package hystrixcamp.app.product.service;

import hystrixcamp.app.product.Product;

/**
 * @author chanwook
 */
public interface ProductService {

    Product getProduct(String pid);

}
