package hystrixcamp.app.product.api;

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

    public static final String HOST = "http://localhost:9003";

    private final Logger logger = LoggerFactory.getLogger(ProductApiClient.class);

    RestTemplate restTemplate = new RestTemplate();

    // GroupKey는 클래스명, CommandKey는 메서드 명이 기본값
    @HystrixCommand(threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "30")})
    public ProductBase getBaseAttribute(String productId) {
        final ResponseEntity<ProductBase> response = restTemplate.getForEntity(HOST + "/base/{}", ProductBase.class, productId);
        return response.getBody();
    }

    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public ProductRealTime getRealTimeAttribute(String pid) {
        final ResponseEntity<ProductRealTime> response = restTemplate.getForEntity(HOST + "/realtime/{}", ProductRealTime.class, pid);
        return response.getBody();
    }
}
