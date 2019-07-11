package daotest;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import model.User;
import service.UserService;

public class UserDAOTest {
	
	@BeforeSuite
	public void setUp() {
		UserService.insertUser(new User("user1", "password1"));
		UserService.insertUser(new User("user2", "password2"));
		UserService.insertUser(new User("user3", "password"));
		UserService.insertUser(new User("user4", "password"));
	}
	
	@Test
	public void canSelectAllUsers() {
		List<User> users = UserService.selectAllUsers();
		Assert.assertEquals(users.size(), 4);
		
	}
	
	@Test
	public void canSelectUserById() {
		Assert.assertEquals(UserService.selectUserById(51).getUsername(), "user2");
	}
	
	@Test
	public void canSelectUserByUsername() {
		Assert.assertEquals(UserService.selectUserByUsername("user3").getId(), 52);
	}
	
	@Test
	public void canUpdateUser() {
		User u = UserService.selectUserById(50);
		u.setUsername("newUser1");
		UserService.updateUser(u);
		u = UserService.selectUserById(50);
		Assert.assertEquals(u.getUsername(), "newUser1");
	}
	
	@AfterSuite
	public void tearDown() {
		List<User> users = UserService.selectAllUsers();
		for (User u : users) {
			UserService.deleteUserById(u.getId());
		}
	}
}
