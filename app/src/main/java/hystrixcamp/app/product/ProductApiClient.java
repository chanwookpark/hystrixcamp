package hystrixcamp.app.product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Component
public class ProductApiClient {

    private final Logger logger = LoggerFactory.getLogger(ProductApiClient.class);

    RestTemplate restTemplate = new RestTemplate();

    // GroupKey는 클래스명, CommandKey는 메서드 명이 기본값
    @HystrixCommand(threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30")},
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")})
    public ProductBase getProduct(String productId) {
        final ResponseEntity<ProductBase> response = restTemplate.getForEntity("http://localhost:9003/product/{}", ProductBase.class, productId);

        if (logger.isDebugEnabled()) {
            logger.debug("> Get Product Entity: " + response);
        }
        return response.getBody();
    }
}
