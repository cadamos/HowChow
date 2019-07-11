package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Review;
import util.HibernateUtil;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public List<Review> selectAllReviews() {
		Session session = HibernateUtil.getSession();
		List<Review> reviews = null;

		try {
			reviews = session.createQuery("FROM Review").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return reviews;
	}

	@Override
	public Review selectReviewById(int r_id) {
		Session session = HibernateUtil.getSession();
		Review review = null;
		try {
			review = (Review) session.get(Review.class, r_id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return review;

	}

	@Override
	public boolean insertReview(Review r) {
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
	public boolean updateReview(Review r) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();

			session.merge(r);

			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return false;
	}

	@Override
	public boolean deleteReview(int r_id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Review.class, r_id));
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}

}
