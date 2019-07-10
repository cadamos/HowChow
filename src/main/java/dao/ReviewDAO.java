package dao;

import java.util.List;

import model.Review;

public interface ReviewDAO {

	List<Review> getAllReviews();

	Review getReviewById(int r_id);

	boolean addReview(Review r);

	boolean updateReview(Review r);

}
