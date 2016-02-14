package hystrixcamp.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chanwook
 */
@SpringBootApplication
@Controller
public class AdminApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminApp.class).web(true).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminApp.class).web(true);
    }

    @RequestMapping("/")
    public String index() {
        return "forward:/hystrix";
    }

    //FIXME turbine-core 1.0이 servlet 2.5에 dependency가 있어서 turbine을 활성화하려면 톰캣 버전을 낮추거나 터빈 버전을 올려야 한다
    /*
    @Bean
    public ServletRegistrationBean turbine() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new TurbineStreamServlet());
        bean.addUrlMappings("/turbine.stream");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean turbineListener() {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new TurbineListener());
        return bean;
    }

    static class TurbineListener implements ServletContextListener {

        private final Logger logger = LoggerFactory.getLogger(TurbineListener.class);

        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
            logger.info("Initialize complete to Turbine!");
            TurbineInit.init();
        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {
            logger.info("Shutdown complete to Turbine!");
        }
    }
    */
}
