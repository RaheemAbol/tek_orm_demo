package productreviewdemo.dao;

import productreviewdemo.model.ProductReview;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductReviewDAOImpl implements ProductReviewDAO {
    private Connection conn;

    public ProductReviewDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addReview(ProductReview review) {

        String sql = "INSERT INTO ProductReviews (productCode, rating, review) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, review.getProductCode());
            pstmt.setInt(2, review.getRating());
            pstmt.setString(3, review.getReview());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductReview> getAllReviews() {
        List<ProductReview> reviews = new ArrayList<>();
        String sql = "SELECT * FROM ProductReviews";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reviews.add(new ProductReview(
                        rs.getInt("pr_id"),
                        rs.getString("productCode"),
                        rs.getInt("rating"),
                        rs.getString("review")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }


    @Override
    public ProductReview getReviewById(int prId) {
        String sql = "SELECT * FROM  ProductReviews WHERE pr_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ProductReview(
                        rs.getInt("pr_id"),
                        rs.getString("productCode"),
                        rs.getInt("rating"),
                        rs.getString("review")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateReview(ProductReview review) {
        String sql = "UPDATE ProductReviews SET rating = ?, review = ? WHERE pr_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, review.getRating());
            pstmt.setString(2, review.getReview());
            pstmt.setInt(3, review.getPrId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteReview(int prId) {
        String sql = "DELETE FROM ProductReviews WHERE pr_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
