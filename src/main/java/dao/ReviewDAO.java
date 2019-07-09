package dao;

import java.util.List;

import model.Review;

public interface ReviewDAO {
	
	List<Review> getAllReviews();
	boolean addReview(Review r);
	boolean rateReview(Review r, boolean up);


}
