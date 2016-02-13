package hystrixcamp.app.product.service;

import hystrixcamp.app.common.DataModel;
import hystrixcamp.app.product.Product;
import hystrixcamp.app.product.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chanwook
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductApiClient productApiClient;

    @Autowired
    CouponApiClient couponApiClient;

    @Override
    public Product getProduct(String pid) {
        Product model = new Product();

        loadOfBase(pid, model);

        loadOfRealTime(pid, model);

        loadOfCoupon(pid, model);

        return model;
    }

    private void loadOfCoupon(String pid, Product model) {
        ProductCoupon coupon = couponApiClient.getProductCoupon(pid);

        nullSafeSet(pid, model, "coupon", coupon);
    }

    private void loadOfRealTime(String pid, Product model) {
        ProductRealTime realTime = productApiClient.getRealTimeAttribute(pid);
        nullSafeSet(pid, model, "realTime", realTime);
    }

    private void loadOfBase(String pid, Product model) {
        ProductBase base = productApiClient.getBaseAttribute(pid);
        nullSafeSet(pid, model, "base", base);
    }

    private void nullSafeSet(String pid, Product productModel, String key, DataModel dataModel) {
        if (dataModel == null) {
            throw new ProductNotFoundException(pid + "에 해당하는 정보가 존재하지 않습니다.");
        }
        productModel.put(key, dataModel);
    }
}
