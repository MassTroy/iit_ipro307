package iit.ipro497.thermal.persistence.dao;
// Generated Oct 8, 2014 3:19:24 PM by Hibernate Tools 4.0.0

import iit.ipro497.thermal.persistence.WeatherCache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Home object for domain model class WeatherCache.
 * @see .WeatherCache
 * @author Hibernate Tools
 */
@Repository
public class WeatherCacheDAO {

	private static final Log log = LogFactory.getLog(WeatherCacheDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(WeatherCache transientInstance) {
		log.debug("persisting WeatherCache instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WeatherCache persistentInstance) {
		log.debug("removing WeatherCache instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WeatherCache merge(WeatherCache detachedInstance) {
		log.debug("merging WeatherCache instance");
		try {
			WeatherCache result = (WeatherCache) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WeatherCache findById(Long id) {
		log.debug("getting WeatherCache instance with id: " + id);
		try {
			WeatherCache instance = (WeatherCache) sessionFactory.getCurrentSession().get(WeatherCache.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
