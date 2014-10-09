package iit.ipro497.thermal.exception;

public class BadRequestException extends Exception {
	private static final long serialVersionUID = -3365251562586232263L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
}
