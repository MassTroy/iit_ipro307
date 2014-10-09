package iit.ipro497.thermal.model;

import iit.ipro497.domain.data.TemperatureUnit;

public class FormData {
	private static final Double DEFAULT_START_F = 65.0;
	private static final Double DEFAULT_START_C = 20.0;
	
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
		if (startTemp != null)
			return startTemp;
		else if (minTemp != null && maxTemp != null)
			return (minTemp + maxTemp) / 2.0;
		else if (maxTemp != null)
			return maxTemp;
		else if (minTemp != null)
			return minTemp;
		else if (unit == TemperatureUnit.Celsius)
			return DEFAULT_START_C;
		else
			return DEFAULT_START_F;
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

	public void validate() {
		// TODO Auto-generated method stub
	}
}
