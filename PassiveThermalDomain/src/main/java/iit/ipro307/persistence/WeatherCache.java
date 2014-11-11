package iit.ipro307.persistence;

// Generated Oct 8, 2014 3:19:23 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Weather data should be cached using this table but only for good intersection coordinates.
 */
@Entity
@Table(name = "weather_cache")
public class WeatherCache implements Serializable {
	private static final long serialVersionUID = -8491452161329569976L;

	private Long weatherCacheId;
	private IntersectionCoord intersectionCoord;
	private Date dateUpdated;

	WeatherCache() {
	}

	public WeatherCache(IntersectionCoord intersectionCoord, Date dateUpdated) {
		this.intersectionCoord = intersectionCoord;
		this.dateUpdated = dateUpdated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "weather_cache_id", unique = true, nullable = false, updatable = false)
	public Long getWeatherCacheId() {
		return this.weatherCacheId;
	}

	void setWeatherCacheId(Long weatherCacheId) {
		this.weatherCacheId = weatherCacheId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coord_id", unique = true, nullable = false, updatable = false)
	public IntersectionCoord getIntersectionCoord() {
		return this.intersectionCoord;
	}

	void setIntersectionCoord(IntersectionCoord intersectionCoord) {
		this.intersectionCoord = intersectionCoord;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_updated", nullable = false, length = 19)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
