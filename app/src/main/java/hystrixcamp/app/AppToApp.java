package hystrixcamp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@SpringBootApplication
@RestController
public class AppToApp {
    public static void main(String[] args) {
        SpringApplication.run(AppToApp.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "OK!";
    }
}
