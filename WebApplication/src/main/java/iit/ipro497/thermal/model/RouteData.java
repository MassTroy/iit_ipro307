package iit.ipro497.thermal.model;

public class RouteData {
	String title;
	String arrivalTime;
	String duration;
	Long miles;
	TemperatureUnit tempUnit;
	Double minTemp;
	Double maxTemp;
	Double finalTemp;
	Double averageTemp;

	public RouteData() {
	}

	public RouteData(String title, String arrivalTime, String duration, Long miles, TemperatureUnit tempUnit, Double minTemp,
			Double maxTemp, Double finalTemp, Double averageTemp) {
		this.title = title;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.miles = miles;
		this.tempUnit = tempUnit;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.finalTemp = finalTemp;
		this.averageTemp = averageTemp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getMiles() {
		return miles;
	}

	public void setMiles(Long miles) {
		this.miles = miles;
	}

	public TemperatureUnit getTempUnit() {
		return tempUnit;
	}

	public void setTempUnit(TemperatureUnit tempUnit) {
		this.tempUnit = tempUnit;
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

	public Double getFinalTemp() {
		return finalTemp;
	}

	public void setFinalTemp(Double finalTemp) {
		this.finalTemp = finalTemp;
	}

	public Double getAverageTemp() {
		return averageTemp;
	}

	public void setAverageTemp(Double averageTemp) {
		this.averageTemp = averageTemp;
	}

	@Override
	public String toString() {
		return "RouteData [title=" + title + ", arrivalTime=" + arrivalTime + ", duration=" + duration + ", miles=" + miles + ", tempUnit="
				+ tempUnit + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", finalTemp=" + finalTemp + ", averageTemp=" + averageTemp
				+ "]";
	}
}
