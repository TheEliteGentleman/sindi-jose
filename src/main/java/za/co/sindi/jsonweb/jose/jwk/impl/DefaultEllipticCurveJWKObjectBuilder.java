/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwk.ECCurve;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.KeyOperation;
import za.co.sindi.jsonweb.jose.jwk.PublicKeyUse;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultEllipticCurveJWKObjectBuilder extends EllipticCurveJWKObjectBuilder {

	private JWKEllipticCurveKey ellipticCurveJWK;
	
	/**
	 * 
	 */
	public DefaultEllipticCurveJWKObjectBuilder() {
		super();
		// TODO Auto-generated constructor stub
		ellipticCurveJWK = new JWKEllipticCurveKey();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setPublicKeyUse(za.co.sindi.jsonweb.jose.jwk.PublicKeyUse)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setPublicKeyUse(PublicKeyUse publicKeyUse) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setPublicKeyUse(publicKeyUse);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addKeyOperation(za.co.sindi.jsonweb.jose.jwk.KeyOperation)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder addKeyOperation(KeyOperation keyOperation) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.addKeyOperation(keyOperation);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyOperations(za.co.sindi.jsonweb.jose.jwk.KeyOperation[])
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setKeyOperations(KeyOperation[] keyOperations) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setKeyOperations(keyOperations);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setAlgorithm(za.co.sindi.jsonweb.jose.jwa.Algorithm)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setAlgorithm(algorithm);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setKeyId(java.lang.String)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setKeyId(String keyId) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setKeyId(keyId);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX590URI(java.net.URI)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setX590URI(URI uri) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setX590URI(uri);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#addX509Certificate(java.security.cert.X509Certificate)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.addX509Certificate(x509Certificate);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setX509CertificateChains(x509CertificateChains);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setX509CertificateSHA1Thumbprint(x509CertificateSHA1Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setX509CertificateSHA256Thumbprint(x509CertificateSHA256Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public EllipticCurveJWK build() {
		// TODO Auto-generated method stub
		return ellipticCurveJWK;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder#setCurve(za.co.sindi.jsonweb.jose.jwk.ECCurve)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setCurve(ECCurve curve) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setCurve(curve);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder#setPrivateKey(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setPrivateKey(Base64URLUInt privateKey) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setPrivateKey(privateKey);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder#setCoordinateX(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setCoordinateX(Base64URLUInt coordinateX) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setCoordinateX(coordinateX);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder#setCoordinateY(za.co.sindi.jsonweb.Base64URLUInt)
	 */
	@Override
	public EllipticCurveJWKObjectBuilder setCoordinateY(Base64URLUInt coordinateY) {
		// TODO Auto-generated method stub
		ellipticCurveJWK.setCoordinateY(coordinateY);
		return this;
	}
}
