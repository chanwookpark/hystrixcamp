package hystrixcamp.app.review;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * @author chanwook
 */
@Component
public class ReviewApiClient {

    private static final String HOST = "http://localhost:9005";

    RestTemplate restTemplate = new RestTemplate();

    public List<ProductReview> getProductReview(String productId) {
        List<ProductReview> reviewList =
                restTemplate.getForObject(HOST + "/review/product/{0}", List.class, productId);
        return reviewList;
    }

    public static class ProductReviewWrapper implements Serializable {
    }
}
