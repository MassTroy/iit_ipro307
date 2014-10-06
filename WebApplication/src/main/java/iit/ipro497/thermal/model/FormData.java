package iit.ipro497.thermal.model;

public class FormData {
	String origin;
	String destination;
	Double startTemp;
	TemperatureUnit unit;
	Double minTemp;
	Double maxTemp;
	
	public FormData() {
	}

	public FormData(String origin, String destination, Double startTemp, TemperatureUnit unit,
			Double minTemp, Double maxTemp) {
		this.origin = origin;
		this.destination = destination;
		this.startTemp = startTemp;
		this.unit = unit;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getStartTemp() {
		return startTemp;
	}

	public void setStartTemp(Double startTemp) {
		this.startTemp = startTemp;
	}

	public TemperatureUnit getUnit() {
		return unit;
	}

	public void setUnit(TemperatureUnit unit) {
		this.unit = unit;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	@Override
	public String toString() {
		return "FormData [origin=" + origin + ", destination=" + destination + ", startTemp="
				+ startTemp + ", unit=" + unit + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp
				+ "]";
	}
}
