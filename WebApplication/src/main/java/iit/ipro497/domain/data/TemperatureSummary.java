package iit.ipro497.domain.data;

public class TemperatureSummary {
	private final TemperatureUnit tempUnit;
	private final double minTemp;
	private final double maxTemp;
	private final double finalTemp;
	private final double averageTemp;
	
	public TemperatureSummary(TemperatureUnit tempUnit, double minTemp, double maxTemp, double finalTemp, double averageTemp) {
		this.tempUnit = tempUnit;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.finalTemp = finalTemp;
		this.averageTemp = averageTemp;
	}

	public TemperatureUnit getTempUnit() {
		return tempUnit;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public double getFinalTemp() {
		return finalTemp;
	}

	public double getAverageTemp() {
		return averageTemp;
	}

	@Override
	public String toString() {
		return "TemperatureSummary [tempUnit=" + tempUnit + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", finalTemp=" + finalTemp
				+ ", averageTemp=" + averageTemp + "]";
	}

}
