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
public interface RSAPrivateJWK extends RSAJWK, PrivateJWK {

	public Base64URLUInt getPrivateExponent();
	public Base64URLUInt getFirstPrimeFactor();
	public Base64URLUInt getSecondPrimeFactor();
	public Base64URLUInt getFirstFactorCRTExponent();
	public Base64URLUInt getSecondFactorCRTExponent();
	public Base64URLUInt getFirstCRTCoefficient();
	public OtherPrimesInfo[] getOtherPrimes();
	
	public static interface OtherPrimesInfo {
		
		public Base64URLUInt getPrimeFactor();
		public Base64URLUInt getFactorCRTExponent();
		public Base64URLUInt getFactorCoefficient();
	}
}
