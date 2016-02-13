package hystrixcamp.app.product;

import hystrixcamp.app.product.service.ProductService;
import hystrixcamp.app.review.ProductReview;
import hystrixcamp.app.review.ReviewApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chanwook
 */
@Controller
public class ProductViewController {

    @Autowired
    ProductService productService;

    @Autowired
    ReviewApiClient reviewApiClient;

    @RequestMapping("/product/{productId}")
    public String getProductView(@PathVariable("productId") String pid, ModelMap model) {

        Product product = productService.getProduct(pid);

        List<ProductReview> reviewList = reviewApiClient.getProductReview(pid);

        model.put("prd", product);
        model.put("reviewList", reviewList);

        return "productMain";
    }
}
