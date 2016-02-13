package hystrixcamp.app.product;

import hystrixcamp.app.common.ApiModel;
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

        loadOfBase(pid, model);

        loadOfRealTime(pid, model);

        return model;
    }

    private void loadOfRealTime(String pid, ProductViewModel model) {
        ProductRealTime realTime = productApiClient.getRealTimeAttribute(pid);
        nullSafeSet(pid, model, "realTime", realTime);
    }

    private void loadOfBase(String pid, ProductViewModel model) {
        ProductBase base = productApiClient.getBaseAttribute(pid);
        nullSafeSet(pid, model, "base", base);
    }

    private void nullSafeSet(String pid, ProductViewModel productModel, String key, ApiModel apiModel) {
        if (apiModel == null) {
            throw new ProductNotFoundException(pid + "에 해당하는 정보가 존재하지 않습니다.");
        }
        productModel.put(key, apiModel);
    }
}
