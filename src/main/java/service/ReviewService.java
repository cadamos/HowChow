package service;

import java.util.List;

import dao.ReviewDAOImpl;
import model.Review;

public class ReviewService {
	static ReviewDAOImpl rd = new ReviewDAOImpl();



	public static List<Review> getAllReviews() {
		return rd.selectAllReviews();
	}

	public static Review getReviewById(int r_id) {
		return rd.selectReviewById(r_id);
	}

	public static boolean addReview(Review r) {
		return rd.insertReview(r);
	}

	public static boolean upReview(Review r) {
		r.upUserRating();
		return rd.updateReview(r);
	}

	public static boolean downReview(Review r) {
		r.downUserRating();
		return rd.updateReview(r);
	}
	
	public static boolean deleteReview (int r_id) {
		return rd.deleteReview(r_id);
	}
}
