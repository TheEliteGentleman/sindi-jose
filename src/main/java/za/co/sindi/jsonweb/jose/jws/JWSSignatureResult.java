/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.Key;

/**
 * @author Bienfait Sindi
 * @since 10 July 2017
 *
 */
public interface JWSSignatureResult {

	public JWSJOSEHeader getProtectedJwsHeader();
	public JWSJOSEHeader getUnprotectedJwsHeader();
	public Key getKey();
	public boolean validationSucceeded();
}
