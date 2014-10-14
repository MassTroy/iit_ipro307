package iit.ipro307.domain.data;

import com.google.maps.api.common.Location;

public class GeoCoordinate {
	private final double latitude;
	private final double longitude;

	public GeoCoordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public GeoCoordinate(Location location) {
		latitude = location.getLat();
		longitude = location.getLng();
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "GeoCoordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
