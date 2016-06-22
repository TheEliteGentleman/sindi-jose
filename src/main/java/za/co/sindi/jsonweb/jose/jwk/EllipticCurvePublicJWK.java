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
public interface EllipticCurvePublicJWK extends EllipticCurveJWK, PublicJWK {

	public Base64URLUInt getCoordinateX();
	public Base64URLUInt getCoordinateY();
}
