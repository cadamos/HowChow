package daotest;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import model.Dish;
import model.Tag;
import service.DishService;

public class DishDAOTest {
	
	int id = 0;
	int id2 = 0;
	
	@BeforeSuite
	public void setUp() {
		System.out.println(DishService.selectDishById(51));
		ArrayList<Tag> tags = new ArrayList<Tag>();
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test";
		String restaurant = "Testaurant";
		Dish d = new Dish(img,name,description,tags,restaurant);
		id = DishService.insertDish(d);
		ArrayList<Tag> tags2 = new ArrayList<Tag>();
		String img2 = "https://fakeimage.com";
		String description2 = "Test description.";
		String name2 = "Test2";
		String restaurant2 = "Testaurant";
		Dish d2 = new Dish(img2,name2,description2,tags2,restaurant2);
		id2 = DishService.insertDish(d2);
		System.out.println("end of setup");
	}
	
	@Test(priority=1)
	public void selectDishById() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test";
		String restaurant = "Testaurant";
		Dish d = new Dish(id,img,name,description,tags,restaurant);
		Dish d2 = DishService.selectDishById(id);
		Assert.assertEquals(d, d2);
		System.out.println("end of test 1");
	}
	
	@Test(priority=2)
	public void insertDish() {
		int id3 = 0;
		ArrayList<Tag> tags = new ArrayList<Tag>();
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test3";
		String restaurant = "Testaurant";
		Dish d = new Dish(img,description,name,tags,restaurant);
		id3 = DishService.insertDish(d);
		Assert.assertTrue(id3 != 0);
		DishService.deleteDishById(id3);
		System.out.println("end of test 2");
	}
	
	@Test(priority=3)
	public void updateDish() {
		Tag t = new Tag("Test");
		Tag t2 = new Tag("Test2");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(t);
		tags.add(t2);
		String img = "https://fakeimage.com";
		String description = "Test description.";
		String name = "Test";
		String restaurant = "Testaurant";
		Dish d = new Dish(id,img,name,description,tags,restaurant);
		DishService.updateDish(d);
		Assert.assertEquals(d, DishService.selectDishById(id));
	}
	
	@Test(priority=4)
	public void selectAllDishes() {
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		dishes.add(DishService.selectDishById(id));
		dishes.add(DishService.selectDishById(id2));
		System.out.println(DishService.selectDishById(id));
		System.out.println(DishService.selectDishById(id2));
		ArrayList<Dish> dishes2 = DishService.selectAllDishes();
		System.out.println(dishes);
		System.out.println(dishes2);
		Assert.assertEquals(dishes2, dishes);
	}
	
	@Test(priority=5)
	public void selectDishesByTags() {
		Tag t = new Tag("Test");
		Tag t2 = new Tag("Test2");
		ArrayList<Tag> tags = new ArrayList<Tag>();
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		dishes.add(DishService.selectDishById(id));
		tags.add(t);
		tags.add(t2);
		ArrayList<Dish> dishtag = DishService.selectDishesByTags(tags);
		Assert.assertEquals(dishtag,dishes);
	}
	
	@Test(priority=6)
	public void deleteDishById() {
		DishService.deleteDishById(id2);
	}
	
	@AfterSuite
	public void tearDown() {
		DishService.deleteDishById(id);
	}
}
