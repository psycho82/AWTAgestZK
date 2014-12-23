package it.awta.awtagest;

// Generated 15-mar-2011 0.22.02 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 * Home object for domain model class Istruttore.
 * @see it.awta.awtagest.Istruttore
 * @author Hibernate Tools
 */
public class IstruttoreHome {

	private static final Log log = LogFactory.getLog(IstruttoreHome.class);

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

	public Istruttore merge(Istruttore detachedInstance) {
		log.debug("merging Istruttore instance");
		Session session = sessionFactory.openSession();
		try {
			Istruttore result = (Istruttore) session.merge(detachedInstance);
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
	public List<Istruttore> findAll(){
		log.debug("finding all Istruttore");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Istruttore.class);
			crit.addOrder(Order.asc("istCognome"));
			List<Istruttore> results = (List<Istruttore>) crit.list();
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
	public List<Istruttore> findExcept(int no){
		log.debug("finding all Istruttore");
		Session session = sessionFactory.openSession();
		try {
			Criteria crit = session.createCriteria(it.awta.awtagest.Istruttore.class);
			crit.addOrder(Order.asc("istCognome"));
			Criterion except = Restrictions.ne("istId", no);
			crit.add(except);
			List<Istruttore> results = (List<Istruttore>) crit.list();
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
	
	public void deleteIstruttore(Istruttore persistentInstance){
		log.debug("deleting Istruttore instance");
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
	public void update(Istruttore detachedInstance) {
		log.debug("merging Istruttore instance");
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
	
}
