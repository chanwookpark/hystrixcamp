package hystrixcamp.api.product;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class ProductBase implements Serializable {

    private String productId;

    private String productName;

    public ProductBase() {
    }

    public ProductBase(String productId, String productName) {
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
