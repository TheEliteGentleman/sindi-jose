/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import za.co.sindi.jsonweb.jose.JOSEException;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 *
 */
public class JWSException extends JOSEException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1266178394439649932L;

	/**
	 * 
	 */
	public JWSException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public JWSException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JWSException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JWSException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JWSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
