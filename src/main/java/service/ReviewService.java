package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.ReviewDAOImpl;
import model.Reviews;

public class ReviewService {
	static ReviewDAOImpl rd = new ReviewDAOImpl();
	
	public static List<Reviews> getReviewsByDishId(int d_id) {
		List<Reviews> reviews = new ArrayList<Reviews>();
		for(Reviews r : rd.getAllReviews()) {
			if(r.getD_id()==d_id) {
				reviews.add(r);
			}
		}
		Collections.sort(reviews);
		return reviews;
	}
	
	public static boolean addReview(Reviews r) {
		return rd.addReview(r);
	}
	
	public static boolean upReview(Reviews r) {
		r.upUserRating();
		return rd.updateReview(r);
	}
	public static boolean downReview(Reviews r) {
		r.downUserRating();
		return rd.updateReview(r);
	}
}
