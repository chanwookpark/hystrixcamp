package hystrixcamp.api.product;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class ProductRealTime implements Serializable {

    private String productId;

    private long retailPrice;

    private long salesPrice;

    private int stock;

    public ProductRealTime(String productId, long salesPrice, long retailPrice, int stock) {
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.retailPrice = retailPrice;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(long retailPrice) {
        this.retailPrice = retailPrice;
    }

    public long getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(long salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
