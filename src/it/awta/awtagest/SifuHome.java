package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 * Home object for domain model class Sifu.
 * @see it.awta.awtagest.Sifu
 * @author Hibernate Tools
 */
public class SifuHome {

	private static final Log log = LogFactory.getLog(SifuHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Sifu transientInstance) {
		log.debug("persisting Sifu instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Sifu instance) {
		log.debug("attaching dirty Sifu instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sifu instance) {
		log.debug("attaching clean Sifu instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Sifu persistentInstance) {
		log.debug("deleting Sifu instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sifu merge(Sifu detachedInstance) {
		log.debug("merging Sifu instance");
		try {
			Sifu result = (Sifu) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sifu findById(int id) {
		log.debug("getting Sifu instance with id: " + id);
		try {
			Sifu instance = (Sifu) sessionFactory.getCurrentSession().get(
					"it.awta.awtagest.Sifu", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sifu> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Sifu.class);
			crit.addOrder(Order.asc("sifuCognome"));
			List<Sifu> results = (List<Sifu>) crit.list();
			//List<Sifu> results = (List<Sifu>) session.createCriteria("it.awta.awtagest.Sifu").list();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public void update(Sifu detachedInstance) {
		log.debug("updating Sifu instance");
		Session session = sessionFactory.openSession();
		try {
			session.update(detachedInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public void deleteSifu(Sifu persistentInstance){
		log.debug("deleting Sifu instance");
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
	public List<Sifu> findExcept(int no){
		log.debug("finding all Sifu");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Sifu.class);
			crit.addOrder(Order.asc("sifuCognome"));
			Criterion except = Restrictions.ne("sifuId", no);
			crit.add(except);
			List<Sifu> results = (List<Sifu>) crit.list();
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
}
