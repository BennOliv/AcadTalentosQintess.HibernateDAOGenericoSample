package com.qintess.desafio0104.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.desafio0104.Util.HibernateConfig;

@SuppressWarnings("unchecked")
public class Dao<T> {
	public void salva(T t) {
		Transaction transacao = null;
		Session session = null;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			
			transacao = session.beginTransaction();
			
			session.save(t);
			
			transacao.commit();
			
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
		} finally {
			session.close();
		}
	}
	
	public List<T> buscaTodos(Class<T> clazz){
		Transaction transacao = null;
		Session session = null;
		List<T> ret = null;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			
			transacao = session.beginTransaction();
			
			ret = (List<T>) session.createQuery("FROM "+ clazz.getName()).list();
			
			transacao.commit();
			return ret; 
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public T buscaPorId(Class<T> clazz, int id) {
		Transaction transacao = null;
		Session session = null;
		T ret = null;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			
			transacao = session.beginTransaction();
						
			ret = (T) session.get(clazz.getName(), id);
			
			session.getTransaction().commit();
			
			return ret;
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public void atualiza(Class<T> clazz, T t, int id) {
		Transaction transacao = null;
		Session session = null;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			transacao = session.beginTransaction();
			
			T doBD = (T) session.get(clazz.getName(), id);
			
			doBD = t;
			
			session.save(doBD);
			transacao.commit();
			
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
		} finally {
			session.close();
		}
	}
	
	public void deleta(T t) {
		Transaction transacao = null;
		Session session = null;
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			transacao = session.beginTransaction();
			
			session.delete(t);
			
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
		} finally {
			session.close();
		}
	}
}
