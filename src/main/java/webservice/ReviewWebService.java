package webservice;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dish;
import model.User;
import model.Review;
import service.DishService;
import service.ReviewService;
import service.UserService;


public class ReviewWebService {
	public static void getReviewsByDishId(HttpServletRequest request, HttpServletResponse response) {
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		ObjectMapper om = new ObjectMapper();
		try {
			// for(Request r: RequestService.userRequest(id)) {
			String json = om.writeValueAsString(ReviewService.getReviewsByDishId(d_id));
			response.getWriter().append(json).close();
			// }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean addReview(HttpServletRequest request, HttpServletResponse response) {
		String username=null;		

		Cookie cookies[] = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("username")) {
				username = cookies[i].getValue();
			}
		}
		if(username==null) {
			try {
				response.getWriter().append("No User").close();;
			} catch (IOException e) {
				e.printStackTrace();
			}
				return false;
		}
		User u= UserService.selectUserByUsername(username);
		Dish d= DishService.selectDishById(Integer.parseInt(request.getParameter("d_id")));
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		return ReviewService.addReview(new Review(u, d, rating, comment));	
	}
	
	public static boolean upReview(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		for(Review r : ReviewService.getAllReviews()) {
			if(r.getR_id()==r_id)
			{
			
				return ReviewService.upReview(r);
			}
		}
		return false;
	}
	
	public static boolean downReview(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		for(Review r : ReviewService.getAllReviews()) {
			if(r.getR_id()==r_id)
			{
			
				return ReviewService.downReview(r);
			}
		}
		return false;
	}
}
