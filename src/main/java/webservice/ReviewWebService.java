package webservice;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dish;
import model.Review;
import model.User;
import service.DishService;
import service.ReviewService;
import service.UserService;

public class ReviewWebService {
	
	public static boolean getReviewsByDishId(HttpServletRequest request, HttpServletResponse response) {
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(ReviewService.getReviewsByDishId(d_id));
			response.getWriter().append(json).close();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public static boolean addReview(HttpServletRequest request, HttpServletResponse response) {
		String username = null;

		Cookie cookies[] = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("username")) {
				username = cookies[i].getValue();
			}
		}
		if (username == null) {
			try {
				response.getWriter().append("No User").close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		User u = UserService.selectUserByUsername(username);
		Dish d = DishService.selectDishById(Integer.parseInt(request.getParameter("d_id")));
		
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("rating"));

		return ReviewService.addReview(new Review(u,d, rating, comment));
	}

	public static boolean upReview(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		return ReviewService.upReview((ReviewService.getReviewById(r_id)));
	}

	public static boolean downReview(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		return ReviewService.downReview((ReviewService.getReviewById(r_id)));
	}
	
	public static boolean deleteReview(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		return ReviewService.deleteReview(r_id);
	}
}
