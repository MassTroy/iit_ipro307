package iit.ipro497.domain.data;

import com.google.maps.api.directions.Step;

public class RouteSegment {
	private final long distanceMeters;
	private final long durationSeconds;
	private final GeoCoordinate startLocation;
	private final GeoCoordinate endLocation;

	public RouteSegment(long distanceMeters, long durationSeconds, GeoCoordinate startLocation, GeoCoordinate endLocation) {
		this.distanceMeters = distanceMeters;
		this.durationSeconds = durationSeconds;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public RouteSegment(Step step) {
		this.distanceMeters = step.getDistance().getValue();
		this.durationSeconds = step.getDuration().getValue();
		this.startLocation = new GeoCoordinate(step.getStartLocation());
		this.endLocation = new GeoCoordinate(step.getEndLocation());
	}

	public long getDistance() {
		return distanceMeters;
	}

	public long getDuration() {
		return durationSeconds;
	}

	public GeoCoordinate getStartLocation() {
		return startLocation;
	}

	public GeoCoordinate getEndLocation() {
		return endLocation;
	}

	@Override
	public String toString() {
		return "RoutePoint [distance=" + distanceMeters + ", duration=" + durationSeconds + ", startLocation=" + startLocation + ", endLocation="
				+ endLocation + "]";
	}

}
