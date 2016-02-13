package hystrixcamp.app.product.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Component
public class CouponApiClient {
    public static final String HOST = "http://localhost:9002";

    RestTemplate restTemplate = new RestTemplate();

    @HystrixCommand
    public ProductCoupon getProductCoupon(String pid) {
        final ResponseEntity<ProductCoupon> response = restTemplate.getForEntity(HOST + "/coupon/product/{pid}", ProductCoupon.class, pid);
        return response.getBody();
    }
}
