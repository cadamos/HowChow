package daotest;



import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import model.Dish;
import model.Review;
import model.User;
import service.DishService;
import service.ReviewService;
import service.UserService;

public class ReviewDAOTest {
	@BeforeSuite
	public void setUp() {
		UserService.insertUser(new User("user", "password"));
	}
	@Test(priority=1)
	public void addReview(){
		User u = UserService.selectUserByUsername("user");
		Dish d = DishService.selectDishById(1200);
		Assert.assertTrue(ReviewService.addReview(new Review(u, d,3, "This pizza is greattt dude")));
	}
	@Test(priority=2)
	public void getReview() {
		for(Review rs: ReviewService.getAllReviews()) {
			if(rs.getComment().equals("This pizza is greattt")) {
				System.out.println(rs.getComment());
				Assert.assertNotNull(ReviewService.getReviewById(rs.getR_id()));
			}
		}

	}
	@Test(priority=3)
	public void upReview() {
		for(Review rs: ReviewService.getAllReviews()) {
			if(rs.getComment().equals("This pizza is greattt")) {
				ReviewService.upReview(rs);
				Assert.assertTrue(ReviewService.upReview(rs));
			}
		}

	}
	@Test(priority=4)
	public void downReview() {
		for(Review rs: ReviewService.getAllReviews()) {
			if(rs.getComment().equals("This pizza is greattt")) {
				Assert.assertTrue(ReviewService.downReview(rs));
			}
		}

	}
	@Test(priority=5)
	public void getAllReviewByDishId() {
		Assert.assertNotNull(ReviewService.getReviewsByDishId(1200));
	}
	
	@AfterSuite
	public void tearDown() {
		UserService.deleteUserById(UserService.selectUserByUsername("user").getId());
	}
}

