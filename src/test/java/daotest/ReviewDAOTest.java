package daotest;



import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import model.Dish;
import model.Review;
import model.Tag;
import model.User;
import service.DishService;
import service.ReviewService;
import service.TagService;
import service.UserService;

public class ReviewDAOTest {
	@BeforeSuite
	public void setUp() {
		UserService.insertUser(new User("user", "password"));
	    //TagService.insertTag(new Tag("test"));
	    //DishService.insertDish(new Dish("img", "pizza", "this is pizza", TagService.selectAllTags(),"test place"));
	}
	@Test(priority=1)
	public void addReview(){
		User u = UserService.selectUserByUsername("user");
		Assert.assertTrue(ReviewService.addReview(new Review(u, 3, "This pizza is greattt")));
	}
	@Test(priority=2)
	public void getReview() {
		
	}
	
	@AfterSuite
	public void tearDown() {
		UserService.deleteUserById(100);
		TagService.deleteTagByName("test");
		DishService.deleteDishById(50);
		ReviewService.deleteReview(50);
	}
}

