package com.scrapbot.entity.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;

import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.entity.entities.NewsCompany;
import com.scrapbot.entity.entities.User;
import com.scrapbot.hibernate.HibernateCfg;


public class UserDAO {
	
	private Transaction transaction;

	public void saveUser(User entity) {
		this.transaction = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
		
			session.save(entity);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void getColums() {
		this.transaction = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			// start a transaction

			ClassMetadata classMetadata = HibernateCfg.getFactoryInstance().getClassMetadata(NewsArticle.class);
			String[] propertyNames = classMetadata.getPropertyNames();
			for (String s : propertyNames) {
				// system.out.println(s);
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateUser(User entity) {
		Transaction transaction = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(entity);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<User> getUser() {
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			return session.createCriteria(User.class).addOrder(Order.asc("id")).list();
			// return session.createQuery("from Product", Product.class).list();
		}
	}


	



	@SuppressWarnings("finally")
	public User findByPkey(int pkey) {
		Transaction transaction = null;
		User code = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			code = session.find(User.class, pkey);
			// commit transaction
			if (code != null) {
				 System.out.println(code.toString());

			} else {
				System.out.println("nothing");
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			return code;
		}

	}

	public void delUser(User entity) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.delete(entity);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		NewsCompanyDAO newsCompanyDAO = new NewsCompanyDAO();
		
		User entity= new User();
		entity.setKakaoID("0001");
		
		ArrayList<String> list= (ArrayList<String>) entity.getKeywords();
		list.add("장마");
		entity.setKeywords(list);
		HashSet<NewsCompany> companies = new HashSet<>();
		newsCompanyDAO.getNewsCompanies().forEach(e->{
			System.out.println(e.getCompanyName());
			companies.add(e);
		});
		entity.setNewsCompanySet(companies);
		entity.setGrade("플레티넘");
		dao.saveUser(entity);
	}
}
