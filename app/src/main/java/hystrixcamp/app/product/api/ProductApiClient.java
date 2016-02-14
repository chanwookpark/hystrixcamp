package hystrixcamp.app.product.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Component
public class ProductApiClient {

    public static final String HOST = "http://localhost:9003";

    RestTemplate restTemplate = new RestTemplate();

    // GroupKey는 클래스명, CommandKey는 메서드 명이 기본값
    @HystrixCommand(threadPoolKey = "getBaseAttribute", threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "50")})
    public ProductBase getBaseAttribute(String productId) {
        final ResponseEntity<ProductBase> response = restTemplate.getForEntity(HOST + "/product/base/{0}", ProductBase.class, productId);
        return response.getBody();
    }

    @HystrixCommand(threadPoolKey = "getRealTimeAttribute", threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "50")}, commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public ProductRealTime getRealTimeAttribute(String pid) {
        final ResponseEntity<ProductRealTime> response = restTemplate.getForEntity(HOST + "/product/realtime/{0}", ProductRealTime.class, pid);
        return response.getBody();
    }
}
