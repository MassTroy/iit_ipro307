package iit.ipro307.domain.data;

public class Percentage {
	private final int percentage;
	
	public Percentage(int value) {
		this.percentage = value;
	}
	
	public Percentage(long value) {
		this.percentage = (int) value;
	}

	public int getPercentage() {
		return percentage;
	}

	public double getPercentageMultiplier() {
		return percentage / 100.0;
	}

	@Override
	public String toString() {
		return "Percentage [percentage=" + percentage + "]";
	}
}
