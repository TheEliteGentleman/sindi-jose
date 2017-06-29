/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.Base64URLBytes;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwk.KeyOperation;
import za.co.sindi.jsonweb.jose.jwk.PublicKeyUse;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWK;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWKObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultSymmetricJWKObjectBuilder extends SymmetricJWKObjectBuilder {
	
	private JWKSymmetricKey symmetricJWK;

	/**
	 * 
	 */
	public DefaultSymmetricJWKObjectBuilder() {
		super();
		// TODO Auto-generated constructor stub
		symmetricJWK = new JWKSymmetricKey();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setPublicKeyUse(za.co.sindi.jsonweb.jose.jwk.PublicKeyUse)
	 */
	@Override
	public SymmetricJWKObjectBuilder setPublicKeyUse(PublicKeyUse publicKeyUse) {
		// TODO Auto-generated method stub
		symmetricJWK.setPublicKeyUse(publicKeyUse);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addKeyOperation(za.co.sindi.jsonweb.jose.jwk.KeyOperation)
	 */
	@Override
	public SymmetricJWKObjectBuilder addKeyOperation(KeyOperation keyOperation) {
		// TODO Auto-generated method stub
		symmetricJWK.addKeyOperation(keyOperation);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyOperations(za.co.sindi.jsonweb.jose.jwk.KeyOperation[])
	 */
	@Override
	public SymmetricJWKObjectBuilder setKeyOperations(KeyOperation[] keyOperations) {
		// TODO Auto-generated method stub
		symmetricJWK.setKeyOperations(keyOperations);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setAlgorithm(za.co.sindi.jsonweb.jose.jwa.Algorithm)
	 */
	@Override
	public SymmetricJWKObjectBuilder setAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		symmetricJWK.setAlgorithm(algorithm);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyId(java.lang.String)
	 */
	@Override
	public SymmetricJWKObjectBuilder setKeyId(String keyId) {
		// TODO Auto-generated method stub
		symmetricJWK.setKeyId(keyId);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX590URI(java.net.URI)
	 */
	@Override
	public SymmetricJWKObjectBuilder setX590URI(URI uri) {
		// TODO Auto-generated method stub
		symmetricJWK.setX590URI(uri);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addX509Certificate(java.security.cert.X509Certificate)
	 */
	@Override
	public SymmetricJWKObjectBuilder addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		symmetricJWK.addX509Certificate(x509Certificate);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	@Override
	public SymmetricJWKObjectBuilder setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		symmetricJWK.setX509CertificateChains(x509CertificateChains);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	@Override
	public SymmetricJWKObjectBuilder setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
		symmetricJWK.setX509CertificateSHA1Thumbprint(x509CertificateSHA1Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	@Override
	public SymmetricJWKObjectBuilder setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
		symmetricJWK.setX509CertificateSHA1Thumbprint(x509CertificateSHA256Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public SymmetricJWK build() {
		// TODO Auto-generated method stub
		return symmetricJWK;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.SymmetricJWKObjectBuilder#setKeyValue(za.co.sindi.jsonweb.Base64URLBytes)
	 */
	@Override
	public SymmetricJWKObjectBuilder setKeyValue(Base64URLBytes keyValue) {
		// TODO Auto-generated method stub
		symmetricJWK.setKeyValue(keyValue);
		return this;
	}
}
