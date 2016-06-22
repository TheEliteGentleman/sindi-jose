/**
 * 
 */
package za.co.sindi.jsonweb.json;

/**
 * @author Bienfait Sindi
 * @since 10 April 2016
 *
 */
public class JSONException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2754919715394870086L;

	/**
	 * 
	 */
	public JSONException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JSONException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public JSONException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JSONException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
