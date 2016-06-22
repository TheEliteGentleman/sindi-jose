/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

import za.co.sindi.jsonweb.jose.JOSEHeader;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 09 June 2016
 *
 */
public interface JWT<ALG extends Algorithm, HEADER extends JOSEHeader<ALG>> {

	public HEADER getJOSEHeader();
	
	public JWTClaims getJWTClaims();
}
