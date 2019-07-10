package daotest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import model.Dish;
import service.DishService;

public class DishDAOTest {
	
	@Test
	public void get_Dish_By_Id() {
		Set<Tag> tags = new HashSet<Tag>();
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test";
		String restaurant = "Testaurant";
		int id = 50000;
		Dish test = new Dish(id,img,name,description,tags,restaurant);
		DishService.insertDish(test);
		Dish test2 = DishService.selectDishById(id);
		assertTrue(test.equals(test2));
		DishService.deleteDishById(id);
	}
	
	@Test
	public void get_Dishes_By_Tag() {
		Set<Tag> tags = new HashSet<Tag>();
		int t_id = 50000;
		Tag testtag = new Tag(50000, "test tag");
		tags.add(testtag);
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test";
		String name2 = "Test 2";
		String restaurant = "Testaurant";
		int id = 50000;
		Dish test = new Dish(img,name,description,tags,restaurant);
		Dish test2 = new Dish(img,name2,description,tags,restaurant);
		ArrayList<Dish> testdishes = new ArrayList<Dish>();
		
		ArrayList<Dish> dishes = DishService.selectDishesByTag(testtag);
	}
	
}
