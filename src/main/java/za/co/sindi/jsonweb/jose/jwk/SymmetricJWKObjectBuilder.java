/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLBytes;

/**
 * @author Bienfait Sindi
 * @since 20 May 2017
 *
 */
public abstract class SymmetricJWKObjectBuilder implements JWKObjectBuilder<SymmetricJWK, SymmetricJWKObjectBuilder> {

	public abstract SymmetricJWKObjectBuilder setKeyValue(Base64URLBytes keyValue);
}
