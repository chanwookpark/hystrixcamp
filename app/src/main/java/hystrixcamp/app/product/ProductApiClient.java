package hystrixcamp.app.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author chanwook
 */
@Component
public class ProductApiClient {

    private final Logger logger = LoggerFactory.getLogger(ProductApiClient.class);

    public Product getProduct(String pid) {
        final GetProductBaseCommand command = new GetProductBaseCommand(pid);
        final Product result = command.execute();

        if (logger.isDebugEnabled()) {
            logger.debug("> Get Product : " + result);
        }

        return result;
    }
}
