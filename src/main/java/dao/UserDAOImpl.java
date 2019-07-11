package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insertUser(User u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();
			id = Integer.parseInt(session.save(u).toString());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public List<User> selectAllUsers() {
		Session session = HibernateUtil.getSession();
		List<User> users = null;
		
		try {
			users = session.createQuery("FROM User").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}
	
	@Override
	public User selectUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		User user = null;
		
		try {
			List<User> users = session.createQuery("FROM User").list();
			for (User u : users) {
				if (u.getUsername().equalsIgnoreCase(username)) {
					user = u;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User selectUserById(int id) {
		Session session = HibernateUtil.getSession();
		User user = null;
		
		try {
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public void updateUser(User u) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			session.merge(u);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteUserById(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(User.class, id));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User u = selectUserByUsername(username);
		
		try {
			tx = session.beginTransaction();
			session.delete(u);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
