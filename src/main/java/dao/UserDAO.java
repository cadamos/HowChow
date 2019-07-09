package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	public int insertUser(User u);
	public List<User> selectAllUsers();
	public User selectUserById(int id);
	public User selectUserByUsername(String username);
	public void updateUser(User u);
	public void deleteUserById(int id);
	
}
