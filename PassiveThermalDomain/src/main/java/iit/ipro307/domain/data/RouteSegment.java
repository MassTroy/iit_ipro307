package iit.ipro307.domain.data;

import java.util.Date;

import com.google.maps.api.directions.Step;

public class RouteSegment {
	private final long distanceMeters;
	private final long durationSeconds;
	private final GeoCoordinate startLocation;
	private final GeoCoordinate endLocation;
	private final Date startTime;
	private final Date endTime;

	public RouteSegment(long distanceMeters, long durationSeconds, GeoCoordinate startLocation, GeoCoordinate endLocation, Date startTime, Date endTime) {
		this.distanceMeters = distanceMeters;
		this.durationSeconds = durationSeconds;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public RouteSegment(Step step, Date startTime, Date endTime) {
		this.distanceMeters = step.getDistance().getValue();
		this.durationSeconds = step.getDuration().getValue();
		this.startLocation = new GeoCoordinate(step.getStartLocation());
		this.endLocation = new GeoCoordinate(step.getEndLocation());
		this.startTime = startTime;
		this.endTime = endTime;
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

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "RouteSegment [distanceMeters=" + distanceMeters + ", durationSeconds=" + durationSeconds + ", startLocation="
				+ startLocation + ", endLocation=" + endLocation + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
