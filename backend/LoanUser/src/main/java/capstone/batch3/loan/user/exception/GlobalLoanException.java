package capstone.batch3.loan.user.exception;

public class GlobalLoanException extends RuntimeException {

	private static final long serialVersionUID = 2822360230501440966L;
	private String errorCode;
	private String errorMessage;

	public GlobalLoanException() {
	}

	public GlobalLoanException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
