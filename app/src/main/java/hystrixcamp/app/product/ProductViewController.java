package hystrixcamp.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chanwook
 */
@Controller
public class ProductViewController {

    @Autowired
    ProductService service;

    @RequestMapping("/product/{productId}")
    public String getProductView(@PathVariable("productId") String pid, ModelMap model) {

        ProductViewModel product = service.getProduct(pid);

        model.put("prd", product);
        return "productMain";
    }
}
