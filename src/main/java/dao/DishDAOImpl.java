package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;

import model.Dish;
import util.HibernateUtil;

public class DishDAOImpl implements DishDAO {

	@Override
	public Dish selectDishById(int id) {
		Session session = HibernateUtil.getSession();
		Dish dish = null;
		
		try {
			
			dish = (Dish) session.get(Dish.class, id);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		
		return dish;
	}
	
	@Override
	public List<Dish> selectAllDishes() {
		Session session = HibernateUtil.getSession();
		List<Dish> allDishes = new ArrayList<Dish>();
		
		try {
			
			allDishes = session.createCriteria(Dish.class).list();
			
		} catch( HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		return allDishes;
	}


	@Override
	public List<Dish> selectDishesByTag(Tag t) {
		Session session = HibernateUtil.getSession();
		List<Dish> dishes = new ArrayList<Dish>();
		
		try {
			
			List<Dish> allDishes = session.createCriteria(Dish.class).list();
			for (Dish d: allDishes) {
				if (d.getTagsAssoc().contains(t)) {
					dishes.add(d);
				}
				
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			session.close();
		}
		
		return dishes;
	}
	

	@Override
	public int insertDish(Dish d) {
		Session session = HibernateUtil.getSession(); // Connects to DB.
		int id = 0;
		
		try {
			
			session.beginTransaction();
			id = Integer.parseInt(session.save(d).toString());
			session.getTransaction().commit();
			
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public void updateDish(Dish change) {
		Session session = HibernateUtil.getSession();
		
		try {
			
			session.beginTransaction();
			session.saveOrUpdate(change); 
			session.getTransaction().commit();
			
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDishById(int id) {
		Session session = HibernateUtil.getSession();
		
		try {
			
			session.beginTransaction();
			session.delete(session.get(Dish.class, id));
			session.getTransaction().commit();
			
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}

	
}
