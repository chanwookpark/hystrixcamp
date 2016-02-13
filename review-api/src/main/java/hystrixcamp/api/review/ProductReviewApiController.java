package hystrixcamp.api.review;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author chanwook
 */
@RestController
@RequestMapping("/review/product")
public class ProductReviewApiController {

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public List<ProductReview> getProductReviewList(@PathVariable("productId") String pid) {

        return Arrays.asList(new ProductReview(pid, "1", "최고에요!", 5, "시골총각", LocalDateTime.now()),
                new ProductReview(pid, "2", "별로에요...", 2, "불만제로", LocalDateTime.now()));
    }
}
