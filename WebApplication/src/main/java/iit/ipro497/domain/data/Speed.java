package iit.ipro497.domain.data;

import common.util.SpeedConverter;

public class Speed {
	private final double metersPerSecond;

	public Speed(double metersPerSecond) {
		this.metersPerSecond = metersPerSecond;
	}

	public double getMetersPerSecond() {
		return metersPerSecond;
	}

	public double getMilePerHour() {
		return SpeedConverter.metersPerSecondToMilesPerHour(metersPerSecond);
	}

	public double getKilometersPerHour() {
		return SpeedConverter.metersPerSecondToKiloMetersPerHour(metersPerSecond);
	}

	@Override
	public String toString() {
		return "Speed [metersPerSecond=" + metersPerSecond + "]";
	}
	
}
