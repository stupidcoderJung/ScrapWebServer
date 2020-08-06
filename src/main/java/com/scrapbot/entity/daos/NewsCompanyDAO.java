package com.scrapbot.entity.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;

import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.entity.entities.NewsCompany;
import com.scrapbot.hibernate.HibernateCfg;


public class NewsCompanyDAO {
	
	private Transaction transaction;

	public void saveNewsCompany(NewsCompany entity) {
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

	public void updateNewsCompany(NewsCompany entity) {
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

	public List<NewsCompany> getNewsCompanies() {
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			return session.createCriteria(NewsCompany.class).addOrder(Order.asc("id")).list();
			// return session.createQuery("from Product", Product.class).list();
		}
	}


	



	@SuppressWarnings("finally")
	public NewsCompany findByPkey(int pkey) {
		Transaction transaction = null;
		NewsCompany code = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			code = session.find(NewsCompany.class, pkey);
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

	public void delNewsCompany(NewsCompany entity) {
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
//		put("국민일보","005");
//		put("서울신문","081");
//		put("세계일보","022");
//		put("한겨레","028");
//		put("한국일보","469");
//		put("이데일리","018");
//		put("파이낸셜뉴스","014");
//		put("디지털타임스","029");
//		put("전자신문","030");
//		put("머니투데이","008");
//		put("조선일보","023");
//		put("중앙일보","025");
//		put("동아일보","020");
//		put("매일경제","009");
//		put("한국경제","015");    
//		put("서울경제","011");    
//		put("경향신문","032");
	NewsCompanyDAO  companyDAO = new NewsCompanyDAO();
	NewsCompany entity = new NewsCompany();
	entity.setCompanyName("국민일보");
	entity.setCompanyIdOnNaver("005");
	companyDAO.saveNewsCompany(entity);
	}
	
}
