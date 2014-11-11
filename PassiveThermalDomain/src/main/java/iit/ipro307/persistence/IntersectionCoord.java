package iit.ipro307.persistence;

// Generated Oct 8, 2014 3:19:23 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Intersection coordinates are a list of good intersections of highways which can be used as waypoints
 * to provide variety to the routes returned by google
 */
@Entity
@Table(name = "intersection_coord")
public class IntersectionCoord implements Serializable {
	private static final long serialVersionUID = 2330739226231893695L;

	private long intersectionId;
	private String name;
	private double latitude;
	private double longitude;

	private Set<WeatherCache> weatherCaches = new HashSet<WeatherCache>(0);

	IntersectionCoord() {
	}

	public IntersectionCoord(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "intersection_id", unique = true, nullable = false, updatable = false)
	public Long getIntersectionId() {
		return this.intersectionId;
	}

	void setIntersectionId(Long intersectionId) {
		this.intersectionId = intersectionId;
	}

	@Column(name = "name", nullable = false, length = 64, updatable = false)
	public String getName() {
		return this.name;
	}

	void setName(String name) {
		this.name = name.toLowerCase();
	}

	@Column(name = "latitude", nullable = false, precision = 10, scale = 0, updatable = false)
	public double getLatitude() {
		return this.latitude;
	}

	void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false, precision = 10, scale = 0, updatable = false)
	public double getLongitude() {
		return this.longitude;
	}

	void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "intersectionCoord")
	public Set<WeatherCache> getWeatherCaches() {
		return this.weatherCaches;
	}

	void setWeatherCaches(Set<WeatherCache> weatherCaches) {
		this.weatherCaches = weatherCaches;
	}

}
