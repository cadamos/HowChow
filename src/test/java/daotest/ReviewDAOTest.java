package daotest;

import org.testng.annotations.BeforeSuite;

import model.User;
import service.UserService;

public class ReviewDAOTest {
	@BeforeSuite
	public void setUp() {
		UserService.insertUser(new User("user", "password"));
	}
	
}
