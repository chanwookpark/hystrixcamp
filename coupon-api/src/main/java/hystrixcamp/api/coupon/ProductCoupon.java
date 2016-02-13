package hystrixcamp.api.coupon;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class ProductCoupon implements Serializable {

    private String productId;

    private String couponId;

    private String couponName;

    private CouponType couponType;

    private long value; //% 또는 가격

    public ProductCoupon() {
    }

    public ProductCoupon(String productId, String couponId, String couponName, CouponType couponType, long value) {
        this.productId = productId;
        this.couponId = couponId;
        this.couponName = couponName;
        this.couponType = couponType;
        this.value = value;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public enum CouponType {
        FIXED_RATE, FIXED_AMOUT;
    }
}
