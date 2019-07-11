package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import service.UserService;

public class UserWebService {
	
	public static void getUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		User u = UserService.selectUserByUsername(username);
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(u);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void registerUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean canRegister = true;
		List<User> users = UserService.selectAllUsers();

		try {
			for (User u : users) {
				if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
					canRegister = false;
				}
			}
			if (canRegister) {
				UserService.insertUser(new User(username, password));
				response.getWriter().append("User has been added to the database");
			} else {
				response.getWriter().append("User already exists in the database");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void loginUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean login = false;
		List<User> users = UserService.selectAllUsers();

		try {
			for (User u : users) {
				if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
					login = true;
				}
			}
			if (login) {
				response.getWriter().append("true");
			} else {
				response.getWriter().append("false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
