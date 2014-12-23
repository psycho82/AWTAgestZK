package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Scuola.
 * @see it.awta.awtagest.Scuola
 * @author Hibernate Tools
 */
public class ScuolaHome {

	private static final Log log = LogFactory.getLog(ScuolaHome.class);

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
	public List<Scuola> findAll(){
		log.debug("finding all Scuola");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Scuola.class);
			crit.addOrder(Order.asc("scComune"));
			List<Scuola> results = (List<Scuola>) crit.list();
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
	public List<String> findAllComuni(){
		log.debug("finding all Comuni");
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("getAllComuni");
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
	public List<Scuola> findExcept(int no){
		log.debug("finding all Scuola");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Scuola.class);
			crit.addOrder(Order.asc("scNome"));
			Criterion except = Restrictions.ne("scId", no);
			crit.add(except);
			List<Scuola> results = (List<Scuola>) crit.list();
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
	public Scuola findScuolaByComune(String comune){
		log.debug("finding all Scuola");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Scuola.class);
			crit.addOrder(Order.asc("scNome"));
			Criterion except = Restrictions.ne("scComune", comune);
			crit.add(except);
			Scuola result = (Scuola) crit.uniqueResult();
			return result;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public List<Scuola> findScuoleByComune(String comune){
		log.debug("finding all Scuola");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Scuola.class);
			crit.addOrder(Order.asc("scNome"));
			Criterion criterio = Restrictions.eq("scComune", comune);
			crit.add(criterio);
			List<Scuola> results = (List<Scuola>) crit.list();
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
