package hystrixcamp.app.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

/**
 * @author chanwook
 */
@Configuration
@EnableCircuitBreaker
@EnableHystrix
public class HystrixConfig {
}
