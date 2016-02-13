package hystrixcamp.api.product;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class Product implements Serializable {

    private String productId;

    private String productName;

    public Product() {
    }

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
