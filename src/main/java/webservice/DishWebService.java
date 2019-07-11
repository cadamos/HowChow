package webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dish;
import model.Review;
import model.Tag;
import service.DishService;

public class DishWebService {

	public static void selectDishById (HttpServletRequest request, HttpServletResponse response) {
		
		int dId = Integer.parseInt(request.getParameter("d_id"));
		Dish d = DishService.selectDishById(dId);
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(d);
			response.getWriter().append(json).close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void insertDish (HttpServletRequest request, HttpServletResponse response) {
		
		ObjectMapper om = new ObjectMapper();
		String img = request.getParameter("img");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			tags = om.readValue(request.getParameter("tags"),om.getTypeFactory().constructCollectionType(ArrayList.class, Tag.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String restaurant = request.getParameter("restaurant");
		Dish d = new Dish(img,name,description,tags,restaurant);
		DishService.insertDish(d);
		
		try {
			response.getWriter().append("New dish added to database.").close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	public static void updateDish (HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		String img = request.getParameter("img");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		
		try {
			tags = om.readValue(request.getParameter("tagsAssoc"),om.getTypeFactory().constructCollectionType(ArrayList.class, Tag.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Review> reviews = new ArrayList<Review>();
		try {
			reviews = om.readValue(request.getParameter("reviewsAssoc"),om.getTypeFactory().constructCollectionType(ArrayList.class, Review.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String restaurant = request.getParameter("restaurant");
		Dish d = new Dish(img,name,description,tags,reviews,restaurant);
		DishService.updateDish(d);
		
		try {
			response.getWriter().append("Dish " + d.getD_id() + "updated.").close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void deleteDishById (HttpServletRequest request, HttpServletResponse response) {
		int dId = Integer.parseInt(request.getParameter("d_id"));
		DishService.deleteDishById(dId);
		
		try {
			response.getWriter().append("Dish " + dId + "deleted from system.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void selectAllDishes (HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		ArrayList<Dish> allDishes = DishService.selectAllDishes();
		
		try {
			String json = om.writeValueAsString(allDishes);
			response.getWriter().append(json).close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void selectDishesByTags (HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper om = new ObjectMapper();
		ArrayList<Tag> tags = new ArrayList<Tag>();
		
		try {
			tags = om.readValue(request.getParameter("tags"),om.getTypeFactory().constructCollectionType(ArrayList.class, Tag.class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Dish> dishes = DishService.selectDishesByTags(tags);
		
		try {
			String json = om.writeValueAsString(dishes);
			response.getWriter().append(json).close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}