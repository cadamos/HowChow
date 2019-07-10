package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.ReviewDAOImpl;
import model.Dish;
import model.Review;

public class ReviewService {
	static ReviewDAOImpl rd = new ReviewDAOImpl();
	
	public static List<Review> getReviewsByDishId(int d_id) {
		List<Review> reviews = new ArrayList<Review>();
		for(Review r : rd.getAllReviews()) {
			if(r.getDish().getD_id()== d_id) {
				reviews.add(r);
			}
		}
		Collections.sort(reviews);
		return reviews;
	}
	public static List<Review> getAllReviews(){
		return rd.getAllReviews();
	}
	
	public static boolean addReview(Review r) {
		return rd.addReview(r);
	}
	
	public static boolean upReview(Review r) {
		r.upUserRating();
		return rd.updateReview(r);
	}
	public static boolean downReview(Review r) {
		r.downUserRating();
		return rd.updateReview(r);
	}
}
