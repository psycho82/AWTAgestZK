package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Home object for domain model class Soggetto.
 * @see it.awta.awtagest.Soggetto
 * @author Hibernate Tools
 */
public class SoggettoHome {

	private static final Log log = LogFactory.getLog(SoggettoHome.class);

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
	public List<Soggetto> findAll(){
		log.debug("finding all Soggetto");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Soggetto.class);
			crit.addOrder(Order.asc("sgCognome"));
			List<Soggetto> results = null;
			results = (List<Soggetto>) crit.list();
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
	public List<Soggetto> findAllNoDeleted(){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("findAllNoDeleted");
			List<Soggetto> results = (List<Soggetto>)query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public void deleteSoggetto(Soggetto persistentInstance){
		log.debug("deleting Soggetto instance");
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
	public void update(Soggetto detachedInstance) {
		log.debug("merging Soggeto instance");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.update(detachedInstance);
			log.debug("merge successful");
			session.getTransaction().commit();
		} catch (RuntimeException re) {
			session.getTransaction().rollback();
			log.error("merge failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public Soggetto merge(Soggetto detachedInstance) {
		log.debug("merging Soggetto instance");
		Session session = sessionFactory.openSession();
		try {
			Soggetto result = (Soggetto) session.merge(detachedInstance);
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
	public void insert(Soggetto detachedInstance) {
		log.debug("merging Soggetto instance");
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
	public List<Soggetto> findBySog(Soggetto sg){
		log.debug("finding by Soggetto");
		Session session = sessionFactory.openSession();
		try {
			List<Soggetto> results = (List<Soggetto>) session.createCriteria("it.awta.awtagest.Soggetto").add(create(sg)).list();
			//Criteria crit = session.createCriteria(it.awta.awtagest.Soggetto.class);
			//crit.addOrder(Order.asc("sgCognome"));
			//List<Soggetto> results = (List<Soggetto>) crit.list();
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
	public List<Soggetto> findByCognome(String cognome){
		log.debug("finding Soggetto by cognome");
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(it.awta.awtagest.Soggetto.class);
		Criterion cognomeToFind = Restrictions.eq("sgCognome", cognome);
		crit.add(cognomeToFind);
		crit.addOrder(Order.asc("sgCognome"));
		List<Soggetto> results = (List<Soggetto>)crit.list();
		return results;
	}
	public Soggetto findByCode(Soggetto sg){
		log.debug("finding by Soggetto");
		Session session = sessionFactory.openSession();
		try {
			Soggetto result = (Soggetto) session.createCriteria("it.awta.awtagest.Soggetto").add(create(sg)).uniqueResult();
			return result;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public List<String> getAllCognomi(){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("getAllCognomi");
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
	public List<Soggetto> findAllNoRinnovoByData(Date start){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("findAllNoRinnovoByData");
			query.setParameter("data", start);
			List<Soggetto> results = (List<Soggetto>)query.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}finally{
			session.flush();
		    session.close();
		}
	}
	public List<Soggetto> findAllSiRinnovoByData(Date start){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("findAllSiRinnovoByData");
			query.setParameter("data", start);
			List<Soggetto> results = (List<Soggetto>)query.list();
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
