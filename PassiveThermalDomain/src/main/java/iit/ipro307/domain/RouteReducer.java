package iit.ipro307.domain;

import iit.ipro307.domain.data.GeoCoordinate;
import iit.ipro307.domain.data.Route;
import iit.ipro307.domain.data.RouteSegment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PrefixLogger;

/**
 * Reduce a route into fewer pieces by combining short segments into larger segments
 * @author Troy Mass
 */
@Service
public class RouteReducer {
	@Autowired
	private PrefixLogger log;

	public Route reduceRoute(Route route, long minMeters) {
		log.debug("Reducing route segments: startingSegments=" + route.getSegments().size());
		List<RouteSegment> reducedSegments = new ArrayList<RouteSegment>();

		long distanceMeters = 0;
		long durationSeconds = 0;
		GeoCoordinate startLocation = null;
		GeoCoordinate endLocation = null;
		Date startTime = null;
		Date endTime = null;

		for (RouteSegment segment : route.getSegments()) {
			// add to sums
			distanceMeters += segment.getDistance();
			durationSeconds += segment.getDuration();
			if (startLocation == null)
				startLocation = segment.getStartLocation();
			if (startTime == null)
				startTime = segment.getStartTime();
			endLocation = segment.getEndLocation();
			endTime = segment.getEndTime();

			// if the combined segment is big enough
			if (distanceMeters > minMeters) {
				RouteSegment newSegment = new RouteSegment(distanceMeters, durationSeconds, startLocation, endLocation, startTime, endTime);
				log.trace("Reduced segment: newSegment=" + newSegment);
				reducedSegments.add(newSegment);

				// reset for next pass
				distanceMeters = 0;
				durationSeconds = 0;
				startLocation = null;
			}
		}

		// add final segment
		if (distanceMeters > 0 && durationSeconds > 0 && startLocation != null && endLocation != null) {
			RouteSegment newSegment = new RouteSegment(distanceMeters, durationSeconds, startLocation, endLocation, startTime, endTime);
			log.trace("Reduced segment: newSegment=" + newSegment);
			reducedSegments.add(newSegment);
		}

		log.debug("Reducing route segments: endingSegments=" + reducedSegments.size());
		return new Route(route, reducedSegments);
	}

}
