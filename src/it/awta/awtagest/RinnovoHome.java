package it.awta.awtagest;

// Generated 16-apr-2011 16.31.09 by Hibernate Tools 3.4.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Rinnovo.
 * @see it.awta.awtagest.Rinnovo
 * @author Hibernate Tools
 */
public class RinnovoHome {

	private static final Log log = LogFactory.getLog(RinnovoHome.class);

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

	public void persist(Rinnovo transientInstance) {
		log.debug("persisting Rinnovo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rinnovo instance) {
		log.debug("attaching dirty Rinnovo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rinnovo instance) {
		log.debug("attaching clean Rinnovo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rinnovo persistentInstance) {
		log.debug("deleting Rinnovo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rinnovo merge(Rinnovo detachedInstance) {
		log.debug("merging Rinnovo instance");
		try {
			Rinnovo result = (Rinnovo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rinnovo findById(java.lang.Integer id) {
		log.debug("getting Rinnovo instance with id: " + id);
		try {
			Rinnovo instance = (Rinnovo) sessionFactory.getCurrentSession()
					.get("it.awta.awtagest.Rinnovo", id);
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

	public List findByExample(Rinnovo instance) {
		log.debug("finding Rinnovo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("it.awta.awtagest.Rinnovo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public void insert(Rinnovo detachedInstance) {
		log.debug("merging Rinnovo instance");
		Session session = sessionFactory.openSession();
		try {
			session.save(detachedInstance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
}
