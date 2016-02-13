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
    public ProductViewModel getProduct(String pid) {
        ProductViewModel model = new ProductViewModel();

        loadBaseOfProduct(pid, model);

        return model;
    }

    private void loadBaseOfProduct(String pid, ProductViewModel model) {
        ProductBase base = productApiClient.getProduct(pid);
        if (base == null) {
            throw new ProductNotFoundException(pid + "에 해당하는 상품이 존재하지 않습니다.");
        }
        model.put("base", base);
    }
}
