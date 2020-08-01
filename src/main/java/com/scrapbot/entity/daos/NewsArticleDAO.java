package com.scrapbot.entity.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;

import com.scrapbot.entity.entities.NewsArticle;
import com.scrapbot.hibernate.HibernateCfg;


public class NewsArticleDAO {
	
	private Transaction transaction;

	public void saveNews(NewsArticle entity) {
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

	public void updateNews(NewsArticle entity) {
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

	public List<NewsArticle> getNews() {
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {
			return session.createCriteria(NewsArticle.class).addOrder(Order.asc("id")).list();
			// return session.createQuery("from Product", Product.class).list();
		}
	}


	



	@SuppressWarnings("finally")
	public NewsArticle findByPkey(int pkey) {
		Transaction transaction = null;
		NewsArticle code = null;
		try (Session session = HibernateCfg.getFactoryInstance().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			code = session.find(NewsArticle.class, pkey);
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

	public void delNews(NewsArticle entity) {
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
//	public static void main(String[] args) {
//		
//		NewsArticleDAO dao = new NewsArticleDAO();
////		NewsArticle article = new NewsArticle();
////		article.setNewcompany("동아일보");
////		article.setPagenumber("A1");
////		article.setTitle("정지원지존되다.");
////		article.setTopornot(true);
////		dao.saveNews(article);
//		dao.getNews().forEach(e-> System.out.println(e.getTitle()));
//	}
}
