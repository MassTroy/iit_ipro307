package iit.ipro497.thermal.persistence.dao;
// Generated Oct 8, 2014 3:19:24 PM by Hibernate Tools 4.0.0

import iit.ipro497.thermal.persistence.IntersectionCoord;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Home object for domain model class IntersectionCoord.
 * @see .IntersectionCoord
 * @author Hibernate Tools
 */
public class IntersectionCoordDAO {

	private static final Log log = LogFactory.getLog(IntersectionCoordDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(IntersectionCoord transientInstance) {
		log.debug("persisting IntersectionCoord instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(IntersectionCoord persistentInstance) {
		log.debug("removing IntersectionCoord instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public IntersectionCoord merge(IntersectionCoord detachedInstance) {
		log.debug("merging IntersectionCoord instance");
		try {
			IntersectionCoord result = (IntersectionCoord) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IntersectionCoord findById(Long id) {
		log.debug("getting IntersectionCoord instance with id: " + id);
		try {
			IntersectionCoord instance = (IntersectionCoord) sessionFactory.getCurrentSession().get(IntersectionCoord.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
