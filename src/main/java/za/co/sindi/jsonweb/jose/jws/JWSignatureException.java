/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.SignatureException;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public class JWSignatureException extends SignatureException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8413277440560239086L;

	/**
	 * 
	 */
	public JWSignatureException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param msg
	 */
	public JWSignatureException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JWSignatureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JWSignatureException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
