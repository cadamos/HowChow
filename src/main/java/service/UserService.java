package service;

import java.util.List;

import dao.UserDAOImpl;
import model.User;

public class UserService {
	
	public static UserDAOImpl ud = new UserDAOImpl();

	public static int insertUser(User u) {
		return ud.insertUser(u);
	}
	
	public static List<User> selectAllUsers() {
		return ud.selectAllUsers();
	}
	
	public static User selectUserById(int id) {
		return ud.selectUserById(id);
	}
	
	public static User selectUserByUsername(String username) {
		return ud.selectUserByUsername(username);
	}
	
	public static void updateUser(User u) {
		ud.updateUser(u);
	}
	
	public static void deleteUserById(int id) {
		ud.deleteUserById(id);
	}
	
	public static void deleteUserByUsername(String username) {
		ud.deleteUserByUsername(username);
	}
	
}
