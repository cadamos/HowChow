package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Reviews;
import util.HibernateUtil;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public List<Reviews> getAllReviews() {
		Session session = HibernateUtil.getSession();
		List<Reviews> reviews = null;
		
		try {
			reviews = session.createQuery("FROM Review").list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return reviews;
	}

	@Override
	public boolean addReview(Reviews r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.persist(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateReview(Reviews r) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
		
				session.saveOrUpdate(r);


			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.getTransaction();
		}
		return false;
	}

}
