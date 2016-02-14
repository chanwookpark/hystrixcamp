package hystrixcamp.admin;

import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chanwook
 */
@Configuration
@EnableHystrixDashboard
@PropertySource({"classpath:/config.properties"})
public class HystrixDashboardConfig {
}
