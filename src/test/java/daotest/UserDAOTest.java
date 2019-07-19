package daotest;

import java.util.List;

import org.testng.Assert;
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
		Assert.assertTrue(users.size() > 1);
	}
	
	@Test
	public void canSelectUserById() {
		List<User> users = UserService.selectAllUsers();
		for (User u : users) {
			if (u.getUsername().equals("user2")) {
				Assert.assertNotNull(UserService.selectUserById(u.getId()));
			}
		}
	}
	
	@Test
	public void canSelectUserByUsername() {
		Assert.assertNotNull(UserService.selectUserByUsername("user3"));
	}
	
	@Test
	public void canUpdateUser() {
		User u = UserService.selectUserByUsername("user1");
		u.setUsername("newUser1");
		UserService.updateUser(u);
		Assert.assertNotNull(UserService.selectUserByUsername("newUser1"));
	}
	
	@AfterSuite
	public void tearDown() {
		List<User> users = UserService.selectAllUsers();
		for (User u : users) {
			UserService.deleteUserById(u.getId());
		}
	}
}
