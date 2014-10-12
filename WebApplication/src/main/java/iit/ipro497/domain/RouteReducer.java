package iit.ipro497.domain;

import iit.ipro497.domain.data.GeoCoordinate;
import iit.ipro497.domain.data.Route;
import iit.ipro497.domain.data.RouteSegment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RouteReducer {

	public Route reduceRoute(Route route, long minMeters) {
		List<RouteSegment> reducedSegments = new ArrayList<RouteSegment>();

		long distanceMeters = 0;
		long durationSeconds = 0;
		GeoCoordinate startLocation = null;
		GeoCoordinate endLocation = null;

		for (RouteSegment segment : route.getSegments()) {
			// add to sums
			distanceMeters += segment.getDistance();
			durationSeconds += segment.getDuration();
			if (startLocation == null)
				startLocation = segment.getStartLocation();
			endLocation = segment.getEndLocation();

			// if the combined segment is big enough
			if (distanceMeters > minMeters) {
				RouteSegment newSegment = new RouteSegment(distanceMeters, durationSeconds, startLocation, endLocation);
				reducedSegments.add(newSegment);

				// reset for next pass
				distanceMeters = 0;
				durationSeconds = 0;
				startLocation = null;
			}
		}

		// add final segment
		if (distanceMeters > 0 && durationSeconds > 0 && startLocation != null && endLocation != null) {
			RouteSegment newSegment = new RouteSegment(distanceMeters, durationSeconds, startLocation, endLocation);
			reducedSegments.add(newSegment);
		}

		return new Route(route, reducedSegments);
	}

}
