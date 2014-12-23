package it.awta.awtagest;

// Generated 8-feb-2011 1.13.48 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
/**
 * Home object for domain model class Scuola.
 * @see it.awta.awtagest.Scuola
 * @author Hibernate Tools
 */
public class ScuolaHome {

	private static final Log log = LogFactory.getLog(ScuolaHome.class);

	//private final SessionFactory sessionFactory = getSessionFactory();
	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Scuola transientInstance) {
		log.debug("persisting Scuola instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Scuola instance) {
		log.debug("attaching dirty Scuola instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Scuola instance) {
		log.debug("attaching clean Scuola instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Scuola persistentInstance) {
		log.debug("deleting Scuola instance");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
			session.close();
		} catch (RuntimeException re) {
			session.close();
			log.error("delete failed", re);
			throw re;
		}
	}

	public Scuola merge(Scuola detachedInstance) {
		log.debug("merging Scuola instance");
		Session session = sessionFactory.openSession();
		try {
			Scuola result = (Scuola) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public void update(Scuola detachedInstance) {
		log.debug("merging Scuola instance");
		Session session = sessionFactory.openSession();
		try {
			session.update(detachedInstance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public Scuola findById(java.lang.Integer id) {
		log.debug("getting Scuola instance with id: " + id);
		Session session = sessionFactory.openSession();
		try {
			Scuola instance = (Scuola) session.get("it.awta.awtagest.Scuola", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}

	public List<Scuola> findAll(){
		log.debug("finding all Scuola");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Scuola.class);
			crit.addOrder(Order.asc("scNome"));
			List<Scuola> results = null;
			results = (List<Scuola>) crit.list();
			log.debug("find All successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public void deleteScuola(Scuola persistentInstance){
		log.debug("deleting Scuola instance");
		Session session = sessionFactory.openSession();
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	/*
	 * 
	 * nel catch
      if (tx != null && tx.isActive()) {
        try {
		// Second try catch as the rollback could fail as well
          tx.rollback();
        } catch (HibernateException e1) {
          logger.debug("Error rolling back transaction");
        }
			// throw again the first exception
        throw e;
	 */
}
