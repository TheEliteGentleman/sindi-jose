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
public interface EllipticCurvePrivateJWK extends EllipticCurveJWK, PrivateJWK {

	public Base64URLUInt getPrivateKey();
}
