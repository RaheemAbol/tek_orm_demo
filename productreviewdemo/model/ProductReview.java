package productreviewdemo.model;

public class ProductReview {

    private int prId;

    private String productCode;

    private int rating;

    private String review;

    public ProductReview(int prId, String productCode, int rating, String review) {
        this.prId = prId;
        this.productCode = productCode;
        this.rating = rating;
        this.review = review;
    }

    public int getPrId() {
        return prId;
    }

    public void setPrId(int prId) {
        this.prId = prId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
