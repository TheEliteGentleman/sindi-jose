/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.Key;

import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 10 July 2017
 *
 */
public interface JWSSignatureResult {

	public JWSJOSEHeader getProtectedJwsHeader();
	public JSONObject getUnprotectedJwsHeader();
	public Key getKey();
	public boolean validationSucceeded();
}
