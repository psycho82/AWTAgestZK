package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Sezione.
 * @see it.awta.awtagest.Sezione
 * @author Hibernate Tools
 */
public class SezioneHome {

	private static final Log log = LogFactory.getLog(SezioneHome.class);

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

	public void persist(Sezione transientInstance) {
		log.debug("persisting Sezione instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Sezione instance) {
		log.debug("attaching dirty Sezione instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sezione instance) {
		log.debug("attaching clean Sezione instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Sezione persistentInstance) {
		log.debug("deleting Sezione instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sezione merge(Sezione detachedInstance) {
		log.debug("merging Sezione instance");
		try {
			Sezione result = (Sezione) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sezione findById(java.lang.String id) {
		log.debug("getting Sezione instance with id: " + id);
		try {
			Sezione instance = (Sezione) sessionFactory.getCurrentSession()
					.get("it.awta.awtagest.Sezione", id);
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

	public List<Sezione> findByExample(Sezione instance) {
		log.debug("finding Sezione instance by example");
		try {
			List<Sezione> results = (List<Sezione>) sessionFactory
					.getCurrentSession()
					.createCriteria("it.awta.awtagest.Sezione")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List<Sezione> findByGrado(Sezione instance) {
		log.debug("finding Sezione instance by example");
		try {
			List<Sezione> results = (List<Sezione>) sessionFactory
					.getCurrentSession()
					.createCriteria("it.awta.awtagest.Sezione")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
