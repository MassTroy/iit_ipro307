package iit.ipro497.domain.data;

import java.util.Date;
import java.util.List;

import common.util.DistanceConverter;
import common.util.RoundingUtil;

public class Route {
	private final String summary;
	private final String copyrights;
	private final Date depart;
	private final Date arrive;
	private final List<RouteSegment> segments;
	
	public Route(com.google.maps.api.directions.Route route, Date depart, Date arrive, List<RouteSegment> segments) {
		this.summary = route.getSummary();
		this.copyrights = route.getCopyrights();
		this.depart = depart;
		this.arrive = arrive;
		this.segments = segments;
	}

	public Route(Route route, List<RouteSegment> segments) {
		this.summary = route.getSummary();
		this.copyrights = route.getCopyrights();
		this.depart = route.getDepart();
		this.arrive = route.getArrive();
		this.segments = segments;
	}

	public String getSummary() {
		return summary;
	}

	public String getCopyrights() {
		return copyrights;
	}

	public Date getDepart() {
		return this.depart;
	}

	public Date getArrive() {
		return this.arrive;
	}

	public double getMiles() {
		long distanceMeters = 0;
		for (RouteSegment segment : segments) {
			distanceMeters += segment.getDistance();
		}
		return RoundingUtil.round(DistanceConverter.metersToMiles(distanceMeters), 1);
	}

	public List<RouteSegment> getSegments() {
		return segments;
	}
}
