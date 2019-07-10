package service;

import java.util.ArrayList;

import dao.DishDAOImpl;
import model.Dish;

public class DishService {

	public static DishDAOImpl dd = new DishDAOImpl();
	
	public static Dish selectDishById(int id) {
		return dd.selectDishById(id);
	}
	
	public static ArrayList<Dish> selectAllDishes() {
		ArrayList<Dish> allDishes = (ArrayList<Dish>) dd.selectAllDishes();
		return allDishes;
	}
	
	public static ArrayList<Dish> selectDishByTag(Tag t) {
		ArrayList<Dish> dishes = (ArrayList<Dish>) dd.selectDishesByTag(t);
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
