/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo;

/**
 * @author Bienfait Sindi
 * @since 20 May 2017
 *
 */
public abstract class RSAJWKObjectBuilder implements JWKObjectBuilder<RSAJWK, RSAJWKObjectBuilder> {

	public abstract RSAJWKObjectBuilder setModulus(Base64URLUInt modulus);
	public abstract RSAJWKObjectBuilder setPublicExponent(Base64URLUInt publicExponent);
	
	//For Private Key
	public abstract RSAJWKObjectBuilder setPrivateExponent(Base64URLUInt privateExponent);
	public abstract RSAJWKObjectBuilder setFirstPrimeFactor(Base64URLUInt firstPrimeFactor);
	public abstract RSAJWKObjectBuilder setSecondPrimeFactor(Base64URLUInt secondPrimeFactor);
	public abstract RSAJWKObjectBuilder setFirstFactorCRTExponent(Base64URLUInt firstFactorCRTExponent);
	public abstract RSAJWKObjectBuilder setSecondFactorCRTExponent(Base64URLUInt secondFactorCRTExponent);
	public abstract RSAJWKObjectBuilder setFirstCRTCoefficient(Base64URLUInt firstCRTCoefficient);
	public abstract RSAJWKObjectBuilder setOtherPrimes(OtherPrimesInfo[] otherPrimes);
	
	public static final class OtherPrimesInfoBuilder {
		
		private Base64URLUInt primeFactor;
		private Base64URLUInt factorCRTExponent;
		private Base64URLUInt factorCoefficient;
		
		public OtherPrimesInfoBuilder setPrimeFactor(Base64URLUInt primeFactor) {
			this.primeFactor = primeFactor;
			return this;
		}
		
		public OtherPrimesInfoBuilder setFactorCRTExponent(Base64URLUInt factorCRTExponent) {
			this.factorCRTExponent = factorCRTExponent;
			return this;
		}
		
		public OtherPrimesInfoBuilder setFactorCoefficient(Base64URLUInt factorCoefficient) {
			this.factorCoefficient = factorCoefficient;
			return this;
		}
		
		public OtherPrimesInfo build() {
			return new OtherPrimesInfoImpl(primeFactor, factorCRTExponent, factorCoefficient);
		}
	}
	
	private static class OtherPrimesInfoImpl implements OtherPrimesInfo {
		
		private Base64URLUInt primeFactor;
		private Base64URLUInt factorCRTExponent;
		private Base64URLUInt factorCoefficient;
		
		/**
		 * @param primeFactor
		 * @param factorCRTExponent
		 * @param factorCoefficient
		 */
		private OtherPrimesInfoImpl(Base64URLUInt primeFactor, Base64URLUInt factorCRTExponent, Base64URLUInt factorCoefficient) {
			super();
			this.primeFactor = primeFactor;
			this.factorCRTExponent = factorCRTExponent;
			this.factorCoefficient = factorCoefficient;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo#getPrimeFactor()
		 */
		@Override
		public Base64URLUInt getPrimeFactor() {
			// TODO Auto-generated method stub
			return primeFactor;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo#getFactorCRTExponent()
		 */
		@Override
		public Base64URLUInt getFactorCRTExponent() {
			// TODO Auto-generated method stub
			return factorCRTExponent;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo#getFactorCoefficient()
		 */
		@Override
		public Base64URLUInt getFactorCoefficient() {
			// TODO Auto-generated method stub
			return factorCoefficient;
		}
	}
}
