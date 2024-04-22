package productreviewdemo;

import productreviewdemo.dao.ProductReviewDAO;
import productreviewdemo.dao.ProductReviewDAOImpl;
import productreviewdemo.model.ProductReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainRunner {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "teamlead";
        String password = "teamlead_password";



        try {

            Connection conn  = DriverManager.getConnection(url,user,password);
            ProductReviewDAO  reviewDAO = new ProductReviewDAOImpl(conn);

            ProductReview newReview = new ProductReview(0,"S10_1678",4,"Excellecent product!!!");

            reviewDAO.addReview(newReview);
            System.out.println("Review was added successfully");

            List<ProductReview> reviews = reviewDAO.getAllReviews();

            for(ProductReview review : reviews) {
                System.out.println("Review ID: " + review.getPrId() + ", Product Code: " + review.getProductCode() +
                        ", Rating: " + review.getRating() + ", Review: " + review.getReview());

            }
            conn.close();

        } catch (SQLException ex){
            ex.printStackTrace();
        }


    }

}
