/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLUInt;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public interface RSAJWK extends JWK {

	public Base64URLUInt getModulus();
	public Base64URLUInt getPublicExponent();
}
