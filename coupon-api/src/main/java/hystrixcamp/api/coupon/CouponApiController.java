package hystrixcamp.api.coupon;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static hystrixcamp.api.coupon.ProductCoupon.CouponType.FIXED_RATE;


/**
 * @author chanwook
 */
@RestController
@RequestMapping("/coupon")
public class CouponApiController {

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ProductCoupon getProductCoupon(@PathVariable("productId") String productId) {
        //TODO 여러 개 발급이 되도록..
        return new ProductCoupon(productId, "1", "설날특별할인", FIXED_RATE, 10);
    }
}
