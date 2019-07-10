package dao;

import java.util.List;

import model.Reviews;

public interface ReviewDAO {
	
	List<Reviews> getAllReviews();
	boolean addReview(Reviews r);
	boolean updateReview(Reviews r);


}
