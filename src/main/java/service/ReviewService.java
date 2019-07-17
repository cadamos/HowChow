package service;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public static List<Review> getReviewsByDishId(int d_id){
		List<Review> revs = new ArrayList<Review>();
		
		for(Review r : getAllReviews()) {
			if(r.getDish().getD_id()==d_id) {
				revs.add(r);	
			}
			
		}
		Collections.sort(revs);
		return revs;
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
