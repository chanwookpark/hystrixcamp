package hystrixcamp.api.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@RestController
public class ProductApiController {

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("productId") String pid) {

        return new Product(pid, "테스트 상품");
    }
}
