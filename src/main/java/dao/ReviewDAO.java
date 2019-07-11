package dao;

import java.util.List;

import model.Review;

public interface ReviewDAO {

	List<Review> selectAllReviews();

	Review selectReviewById(int r_id);

	boolean insertReview(Review r);

	boolean updateReview(Review r);
	
	boolean deleteReview(int r_id);

}
