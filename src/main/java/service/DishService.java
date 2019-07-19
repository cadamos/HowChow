package service;

import java.util.ArrayList;
import java.util.Collections;

import dao.DishDAOImpl;
import model.Dish;
import model.Tag;

public class DishService {

	public static DishDAOImpl dd = new DishDAOImpl();
	
	public static Dish selectDishById(int id) {
		return dd.selectDishById(id);
	}
	
	public static ArrayList<Dish> selectAllDishes() {
		ArrayList<Dish> allDishes = (ArrayList<Dish>) dd.selectAllDishes();
		Collections.sort(allDishes);
		return allDishes;
	}
	
	public static ArrayList<Dish> selectDishesByTags(ArrayList<Tag> tags) {
		ArrayList<Dish> dishes = (ArrayList<Dish>) dd.selectDishesByTags(tags);
		Collections.sort(dishes);
		return dishes;
	}
	
	public static int insertDish(Dish d) {
		return dd.insertDish(d);
	}
	
	public static void updateDish(Dish change) {
		dd.updateDish(change);
	}
	
	public static void deleteDishById(int id) {
		dd.deleteDishById(id);
	}
}
