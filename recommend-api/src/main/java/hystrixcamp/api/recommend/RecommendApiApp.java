package hystrixcamp.api.recommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@SpringBootApplication
@RestController
public class RecommendApiApp {
    public static void main(String[] args) {
        SpringApplication.run(RecommendApiApp.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "OK!";
    }
}
