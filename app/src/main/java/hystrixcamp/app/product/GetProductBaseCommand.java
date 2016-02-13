package hystrixcamp.app.product;

import com.netflix.hystrix.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
public class GetProductBaseCommand extends HystrixCommand<Product> {
    private static RestTemplate restTemplate = new RestTemplate();

    private final String productId;

    public GetProductBaseCommand(String productId) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("Product"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetProductBase"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("Product"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(30))

        );

        this.productId = productId;
    }

    @Override
    protected Product run() throws Exception {
        final ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:9003/product/{}", Product.class, productId);
        return response.getBody();
    }
}
