package hystrixcamp.api.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
//TODO SKU 개념을 적용해 개선
@RestController
@RequestMapping("/product")
public class ProductApiController {

    @RequestMapping(value = "/base/{productId}", method = RequestMethod.GET)
    public ProductBase getBase(@PathVariable("productId") String pid) {
        return new ProductBase(pid, "테스트 상품");
    }

    @RequestMapping(value = "/realtime/{productId}", method = RequestMethod.GET)
    public ProductRealTime getRealTime(@PathVariable("productId") String pid) {
        return new ProductRealTime(pid, 100, 90, 10);
    }
}
