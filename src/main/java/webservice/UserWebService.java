package webservice;

import java.io.IOException;

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
	
	public static void addUser(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public static void updateUser(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public static void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
