/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLUInt;

/**
 * @author Bienfait Sindi
 * @since 20 May 2017
 *
 */
public abstract class EllipticCurveJWKObjectBuilder implements JWKObjectBuilder<EllipticCurveJWK, EllipticCurveJWKObjectBuilder> {

	public abstract EllipticCurveJWKObjectBuilder setCurve(ECCurve curve);
	
	//For Private Key
	public abstract EllipticCurveJWKObjectBuilder setPrivateKey(Base64URLUInt privateKey);
	
	//For Public Key
	public abstract EllipticCurveJWKObjectBuilder setCoordinateX(Base64URLUInt coordinateX);
	public abstract EllipticCurveJWKObjectBuilder setCoordinateY(Base64URLUInt coordinateY);
}
