package hystrixcamp.api.review;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chanwook
 */
public class ProductReview implements Serializable {

    private String reviewId;

    private String productId;

    private String contents;

    private String reviewer;

    private int star; // 1~5

    private LocalDateTime updated;

    public ProductReview() {
    }

    public ProductReview(String productId, String reviewId, String contents, int star, String reviewer, LocalDateTime updated) {
        this.contents = contents;
        this.productId = productId;
        this.reviewId = reviewId;
        this.star = star;
        this.reviewer = reviewer;
        this.updated = updated;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
