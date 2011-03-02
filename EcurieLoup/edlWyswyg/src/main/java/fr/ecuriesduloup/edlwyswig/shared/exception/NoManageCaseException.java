package fr.ecuriesduloup.edlwyswig.shared.exception;

public class NoManageCaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -558886090302941774L;

	public NoManageCaseException() {
		super();
	}

	public NoManageCaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoManageCaseException(String message) {
		super(message);
	}

	public NoManageCaseException(Throwable cause) {
		super(cause);
	}

}
