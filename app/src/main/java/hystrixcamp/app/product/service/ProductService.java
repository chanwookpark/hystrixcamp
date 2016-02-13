package hystrixcamp.app.product.service;

import hystrixcamp.app.product.ProductViewModel;

/**
 * @author chanwook
 */
public interface ProductService {

    ProductViewModel getProduct(String pid);

}
