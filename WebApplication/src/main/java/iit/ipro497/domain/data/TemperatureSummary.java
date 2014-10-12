package iit.ipro497.domain.data;

public class TemperatureSummary {
	private final Temperature minTemp;
	private final Temperature maxTemp;
	private final Temperature finalTemp;
	private final Temperature averageTemp;

	public TemperatureSummary(Temperature minTemp, Temperature maxTemp, Temperature finalTemp, Temperature averageTemp) {
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.finalTemp = finalTemp;
		this.averageTemp = averageTemp;
	}

	public Temperature getMinTemp() {
		return minTemp;
	}

	public Temperature getMaxTemp() {
		return maxTemp;
	}

	public Temperature getFinalTemp() {
		return finalTemp;
	}

	public Temperature getAverageTemp() {
		return averageTemp;
	}

	@Override
	public String toString() {
		return "TemperatureSummary [minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", finalTemp=" + finalTemp
				+ ", averageTemp=" + averageTemp + "]";
	}

}
