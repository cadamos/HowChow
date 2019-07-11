package dao;

import java.util.List;

import model.Dish;
import model.Tag;

public interface DishDAO {

	public Dish selectDishById (int id);
	public List<Dish> selectAllDishes(); 
	public List<Dish> selectDishesByTag (Tag t);
	public int insertDish (Dish d);
	public void updateDish (Dish d);
	public void deleteDishById (int id);
	
}
