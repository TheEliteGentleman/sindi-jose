/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwk.KeyOperation;
import za.co.sindi.jsonweb.jose.jwk.PublicKeyUse;
import za.co.sindi.jsonweb.jose.jwk.RSAJWK;
import za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultRSAJWKObjectBuilder extends RSAJWKObjectBuilder {

	private JWKRSAKey rsaJWK;
	
	/**
	 * 
	 */
	public DefaultRSAJWKObjectBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setPublicKeyUse(za.co.sindi.jsonweb.jose.jwk.PublicKeyUse)
	 */
	@Override
	public RSAJWKObjectBuilder setPublicKeyUse(PublicKeyUse publicKeyUse) {
		// TODO Auto-generated method stub
		rsaJWK.setPublicKeyUse(publicKeyUse);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addKeyOperation(za.co.sindi.jsonweb.jose.jwk.KeyOperation)
	 */
	@Override
	public RSAJWKObjectBuilder addKeyOperation(KeyOperation keyOperation) {
		// TODO Auto-generated method stub
		rsaJWK.addKeyOperation(keyOperation);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyOperations(za.co.sindi.jsonweb.jose.jwk.KeyOperation[])
	 */
	@Override
	public RSAJWKObjectBuilder setKeyOperations(KeyOperation[] keyOperations) {
		// TODO Auto-generated method stub
		rsaJWK.setKeyOperations(keyOperations);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setAlgorithm(za.co.sindi.jsonweb.jose.jwa.Algorithm)
	 */
	@Override
	public RSAJWKObjectBuilder setAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		rsaJWK.setAlgorithm(algorithm);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyId(java.lang.String)
	 */
	@Override
	public RSAJWKObjectBuilder setKeyId(String keyId) {
		// TODO Auto-generated method stub
		rsaJWK.setKeyId(keyId);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX590URI(java.net.URI)
	 */
	@Override
	public RSAJWKObjectBuilder setX590URI(URI uri) {
		// TODO Auto-generated method stub
		rsaJWK.setX590URI(uri);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addX509Certificate(java.security.cert.X509Certificate)
	 */
	@Override
	public RSAJWKObjectBuilder addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		rsaJWK.addX509Certificate(x509Certificate);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	@Override
	public RSAJWKObjectBuilder setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		rsaJWK.setX509CertificateChains(x509CertificateChains);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	@Override
	public RSAJWKObjectBuilder setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
		rsaJWK.setX509CertificateSHA1Thumbprint(x509CertificateSHA1Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	@Override
	public RSAJWKObjectBuilder setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
		rsaJWK.setX509CertificateSHA256Thumbprint(x509CertificateSHA256Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public RSAJWK build() {
		// TODO Auto-generated method stub
		return rsaJWK;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setModulus(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setModulus(Base64URLUInt modulus) {
		// TODO Auto-generated method stub
		rsaJWK.setModulus(modulus);
		return null;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setPublicExponent(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setPublicExponent(Base64URLUInt publicExponent) {
		// TODO Auto-generated method stub
		rsaJWK.setPublicExponent(publicExponent);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setPrivateExponent(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setPrivateExponent(Base64URLUInt privateExponent) {
		// TODO Auto-generated method stub
		rsaJWK.setPrivateExponent(privateExponent);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setFirstPrimeFactor(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setFirstPrimeFactor(Base64URLUInt firstPrimeFactor) {
		// TODO Auto-generated method stub
		rsaJWK.setFirstPrimeFactor(firstPrimeFactor);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setSecondPrimeFactor(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setSecondPrimeFactor(Base64URLUInt secondPrimeFactor) {
		// TODO Auto-generated method stub
		rsaJWK.setSecondPrimeFactor(secondPrimeFactor);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setFirstFactorCRTExponent(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setFirstFactorCRTExponent(Base64URLUInt firstFactorCRTExponent) {
		// TODO Auto-generated method stub
		rsaJWK.setFirstFactorCRTExponent(firstFactorCRTExponent);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setSecondFactorCRTExponent(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setSecondFactorCRTExponent(Base64URLUInt secondFactorCRTExponent) {
		// TODO Auto-generated method stub
		rsaJWK.setSecondFactorCRTExponent(secondFactorCRTExponent);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setFirstCRTCoefficient(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public RSAJWKObjectBuilder setFirstCRTCoefficient(Base64URLUInt firstCRTCoefficient) {
		// TODO Auto-generated method stub
		rsaJWK.setFirstCRTCoefficient(firstCRTCoefficient);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder#setOtherPrimes(za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK.OtherPrimesInfo[])
	 */
	@Override
	public RSAJWKObjectBuilder setOtherPrimes(OtherPrimesInfo[] otherPrimes) {
		// TODO Auto-generated method stub
		rsaJWK.setOtherPrimes(otherPrimes);
		return this;
	}

}
