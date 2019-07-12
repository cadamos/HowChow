package driver;

import model.Dish;
import model.Review;
import model.User;
import service.ReviewService;
import service.TagService;
import service.UserService;

public class Test {
	public static void main(String[] args) {
		User u1 = new User("1","2");
		User u2 = new User("hi","bye");
		
//		UserService.insertUser(u2);
//		UserService.insertUser(u1);
		TagService.deleteTagByName("pasta");
		
		//System.out.println(UserService.selectAllUsers());

	}
}
