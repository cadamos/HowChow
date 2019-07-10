package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Tag;
import util.HibernateUtil;

public class TagDAOImpl implements TagDAO {

	@Override
	public int insertTag(Tag t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			id = Integer.parseInt(session.save(t).toString());
			tx.commit();
		} catch (HibernateException  e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}

		return id;
	}

	@Override
	public List<Tag> selectAllTags() {
		Session session = HibernateUtil.getSession();
		List<Tag> tags = null;
		
		try {
			tags = session.createQuery("FROM Tags").list();
		} catch (HibernateException  e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}


		return tags;
	}

	@Override
	public Tag selectTagById(int id) {
		Session session = HibernateUtil.getSession();
		Tag tag = null;
		
		try {
			tag = (Tag) session.get(Tag.class, id);
		} catch (HibernateException  e) {
			e.printStackTrace();
		}finally {
			session.close();
		}


		return tag;
	}

	@Override
	public void updateTag(Tag t) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.beginTransaction();
			session.merge(t);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
;
		}finally {
			session.close();
		}

		
	}

	@Override
	public void deleteTagById(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			session.beginTransaction();
			session.delete(session.get(Tag.class, id));
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}finally {
			session.close();
		}

	}

	@Override
	public void deleteTagByName(String name) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			session.beginTransaction();
			session.delete(session.get(Tag.class, name));
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}finally {
			session.close();
		}
		
	}

}
