/**
 * 
 */
package franco.maurizio.hr.desk.com.service.exception;

/**
 * @author maurizio.franco@ymail.com
 *
 */
public class PositionCodeNotFoundException extends Exception {

//	/**
//	 * 
//	 */
//	public PositionCodeNotFoundException() {
//	}

	/**
	 * @param message
	 */
	public PositionCodeNotFoundException(String message) {
		super(message);
	}

//	/**
//	 * @param cause
//	 */
//	public PositionCodeNotFoundException(Throwable cause) {
//		super(cause);
//	}

	/**
	 * @param message
	 * @param cause
	 */
	public PositionCodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

//	/**
//	 * @param message
//	 * @param cause
//	 * @param enableSuppression
//	 * @param writableStackTrace
//	 */
//	public PositionCodeNotFoundException(String message, Throwable cause, boolean enableSuppression,
//			boolean writableStackTrace) {
//		super(message, cause, enableSuppression, writableStackTrace);
//		// TODO Auto-generated constructor stub
//	}

}
