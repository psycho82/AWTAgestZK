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

/**
 * Home object for domain model class WtEsame.
 * @see it.awta.awtagest.WtEsame
 * @author Hibernate Tools
 */
public class WtEsameHome {

	private static final Log log = LogFactory.getLog(WtEsameHome.class);

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

	public void persist(WtEsame transientInstance) {
		log.debug("persisting WtEsame instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WtEsame instance) {
		log.debug("attaching dirty WtEsame instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WtEsame instance) {
		log.debug("attaching clean WtEsame instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WtEsame persistentInstance) {
		log.debug("deleting WtEsame instance");
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			session.getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			session.getTransaction().rollback();
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}

	public WtEsame merge(WtEsame detachedInstance) {
		log.debug("merging WtEsame instance");
		try {
			WtEsame result = (WtEsame) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WtEsame findById(int id) {
		log.debug("getting WtEsame instance with id: " + id);
		try {
			WtEsame instance = (WtEsame) sessionFactory.getCurrentSession()
					.get("it.awta.awtagest.WtEsame", id);
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

	public List<WtEsame> findByData(WtEsame instance) {
		log.debug("finding WtEsame instance by example");
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from it.awta.awtagest.WtEsame where es_data = :es_data group by es_citta order by es_citta asc, es_ins_sifu asc";
			Query query = session.createQuery(hql);
			query.setDate("es_data", instance.getEsData());
			List<WtEsame> results = (List<WtEsame>) query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List<WtEsame> findBySelection(WtEsame instance) {
		log.debug("finding WtEsame instance by example");
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from it.awta.awtagest.WtEsame where es_data = :es_data and es_ins_sifu = :es_ins_sifu and es_citta = :es_citta order by es_grado asc";
			Query query = session.createQuery(hql);
			query.setDate("es_data", instance.getEsData());
			query.setString("es_ins_sifu", instance.getEsInsSifu());
			query.setString("es_citta", instance.getEsCitta());
			List<WtEsame> results = (List<WtEsame>) query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public void insert(WtEsame detachedInstance) {
		log.debug("inserting WtEsame instance");
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
	public void update(WtEsame detachedInstance) {
		log.debug("merging WtEsame instance");
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
/*	public List<WtEsame> findByExample(WtEsame instance) {
		log.debug("finding WtEsame instance by example");
		try {
			List<WtEsame> results = (List<WtEsame>) sessionFactory
					.getCurrentSession()
					.createCriteria("it.awta.awtagest.WtEsame")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}*/
	public List<WtEsame> getEsamiFromSoggetto(int id){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("getEsamiFromSoggetto");
			query.setInteger("sgid", id);
			List<WtEsame> results = (List<WtEsame>)query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public List<String> getAllCognomiEsaminatori(){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("getAllCognomiEsaminatori");
			List<String> results = (List<String>)query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public List<WtEsame> findByEsaminatore(WtEsame instance) {
		log.debug("finding WtEsame instance by example");
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from it.awta.awtagest.WtEsame where es_ins_sifu = :es_ins_sifu group by es_data order by es_data desc, es_citta asc, es_ins_sifu asc";
			Query query = session.createQuery(hql);
			query.setString("es_ins_sifu", instance.getEsInsSifu());
			List<WtEsame> results = (List<WtEsame>) query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
