package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class WsSezione.
 * @see it.awta.awtagest.WsSezione
 * @author Hibernate Tools
 */
public class WsSezioneHome {

	private static final Log log = LogFactory.getLog(WsSezioneHome.class);

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

	public void persist(WsSezione transientInstance) {
		log.debug("persisting WsSezione instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WsSezione instance) {
		log.debug("attaching dirty WsSezione instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WsSezione instance) {
		log.debug("attaching clean WsSezione instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WsSezione persistentInstance) {
		log.debug("deleting WsSezione instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WsSezione merge(WsSezione detachedInstance) {
		log.debug("merging WsSezione instance");
		try {
			WsSezione result = (WsSezione) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WsSezione findById(int id) {
		log.debug("getting WsSezione instance with id: " + id);
		try {
			WsSezione instance = (WsSezione) sessionFactory.getCurrentSession()
					.get("it.awta.awtagest.WsSezione", id);
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

	public List<WsSezione> findByExample(WsSezione instance) {
		log.debug("finding WsSezione instance by example");
		try {
			List<WsSezione> results = (List<WsSezione>) sessionFactory
					.getCurrentSession()
					.createCriteria("it.awta.awtagest.WsSezione")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public int findFromGrado(String wssez_grado, int sg_id) {
		Session session = sessionFactory.openSession();
		log.debug("finding WsSezione instance by example");
		try {
			Query query = session.getNamedQuery("wsSezionesFromGrado");
			query.setString("wssez_grado", wssez_grado);
			query.setInteger("sg_id", sg_id);
			int tot = (Integer) query.uniqueResult();
			/*List<WsSezione> results = (List<WsSezione>) sessionFactory
					.getCurrentSession()
					.createCriteria("it.awta.awtagest.WsSezione")
					.add(create(instance)).list();
					log.debug("find by example successful, result size: "
					+ results.size());
					*/
			return tot;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public void insert(WsSezione detachedInstance) {
		log.debug("inserting WsSezione instance");
		Session session = sessionFactory.openSession();
		try {
			session.save(detachedInstance);
			log.debug("insert successful");
		} catch (RuntimeException re) {
			log.error("insert failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
}
