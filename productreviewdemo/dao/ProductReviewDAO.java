package productreviewdemo.dao;

import productreviewdemo.model.ProductReview;

import java.util.List;

public interface ProductReviewDAO {

    void addReview(ProductReview productReview);
    List<ProductReview> getAllReviews();
    ProductReview getReviewById(int id);
    void updateReview(ProductReview productReview);
    void deleteReview(int id);

}
