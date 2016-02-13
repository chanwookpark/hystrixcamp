package hystrixcamp.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chanwook
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductApiClient productApiClient;

    @Override
    public Product getProduct(String pid) {
        Product product = productApiClient.getProduct(pid);

        if (product == null) {
            throw new ProductNotFoundException(pid + "에 해당하는 상품이 존재하지 않습니다.");
        }

        return product;
    }
}
