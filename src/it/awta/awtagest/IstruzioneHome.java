package it.awta.awtagest;

// Generated 14-mar-2011 23.50.11 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Istruzione.
 * @see it.awta.awtagest.Istruzione
 * @author Hibernate Tools
 */
public class IstruzioneHome {

	private static final Log log = LogFactory.getLog(IstruzioneHome.class);

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

	public void persist(Istruzione transientInstance) {
		log.debug("persisting Istruzione instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Istruzione instance) {
		log.debug("attaching dirty Istruzione instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Istruzione instance) {
		log.debug("attaching clean Istruzione instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Istruzione persistentInstance) {
		log.debug("deleting Istruzione instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Istruzione merge(Istruzione detachedInstance) {
		log.debug("merging Istruzione instance");
		try {
			Istruzione result = (Istruzione) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Istruzione findById(it.awta.awtagest.IstruzioneId id) {
		log.debug("getting Istruzione instance with id: " + id);
		try {
			Istruzione instance = (Istruzione) sessionFactory
					.getCurrentSession().get("it.awta.awtagest.Istruzione", id);
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

	public List<Istruzione> findAll() {
		log.debug("finding Istruzione instance by example");
		Session session = sessionFactory.openSession();
		try {
			List<Istruzione> results = (List<Istruzione>) session.createCriteria("it.awta.awtagest.Istruzione").list();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
