/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface EllipticCurveJWK extends JWK {

	public ECCurve getCurve();
}
