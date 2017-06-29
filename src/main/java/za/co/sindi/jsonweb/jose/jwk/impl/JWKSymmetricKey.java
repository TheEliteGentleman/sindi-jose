/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.security.GeneralSecurityException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwk.AbstractSymmetricJWK;
import za.co.sindi.jsonweb.jose.jwk.SecretJWK;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWK;

/**
 * @author Bienfait Sindi
 * @since 29 April 2016
 *
 */
public class JWKSymmetricKey extends AbstractSymmetricJWK implements SymmetricJWK, SecretJWK {

	/**
	 * 
	 */
	public JWKSymmetricKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	/**
//	 * @param keyValue
//	 */
//	public JWKSymmetricKey(Base64URLBytes keyValue) {
//		super(keyValue);
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @param keyValue
//	 * @param algorithm
//	 */
//	public JWKSymmetricKey(Base64URLBytes keyValue, Algorithm algorithm) {
//		super(keyValue, algorithm);
//		// TODO Auto-generated constructor stub
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.SecretJWK#toJCASecretKey()
	 */
	@Override
	public SecretKey toJCASecretKey() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		Algorithm algorithm = getAlgorithm();
		if (algorithm != null) {
			String jcaAlgorithmName = algorithm.getJcaAlgorithmName();
			if (!Strings.isNullOrEmpty(jcaAlgorithmName)) {
				return new SecretKeySpec(getKeyValue().getActualValue(), jcaAlgorithmName);
			}
		}
		
		return new SecretKeySpec(getKeyValue().getActualValue(), "AES"); //Just a guess...
	}
}
