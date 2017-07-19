/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.jose.MediaType;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public class DefaultJWSObjectBuilder implements JWSObjectBuilder {
	
	private JWSHeader jwsHeader = new JWSHeader();
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public JWSJOSEHeader build() {
		// TODO Auto-generated method stub
		return jwsHeader;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSObjectBuilder#setAlgorithm(za.co.sindi.jsonweb.jose.jws.JWSAlgorithm)
	 */
	@Override
	public JWSObjectBuilder setAlgorithm(JWSAlgorithm algorithm) {
		// TODO Auto-generated method stub
		jwsHeader.setAlgorithm(algorithm);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setJWKSetURI(java.net.URI)
	 */
	@Override
	public JWSObjectBuilder setJWKSetURI(URI jwkSetURI) {
		// TODO Auto-generated method stub
		jwsHeader.setJWKSetURI(jwkSetURI);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setJSONWebKey(za.co.sindi.jsonweb.jose.jwk.PublicJWK)
	 */
	@Override
	public JWSObjectBuilder setJSONWebKey(PublicJWK jsonWebKey) {
		// TODO Auto-generated method stub
		jwsHeader.setJSONWebKey(jsonWebKey);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setKeyId(java.lang.String)
	 */
	@Override
	public JWSObjectBuilder setKeyId(String keyId) {
		// TODO Auto-generated method stub
		jwsHeader.setKeyId(keyId);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setX590URI(java.net.URI)
	 */
	@Override
	public JWSObjectBuilder setX590URI(URI uri) {
		// TODO Auto-generated method stub
		jwsHeader.setX590URI(uri);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#addX509Certificate(java.security.cert.X509Certificate)
	 */
	@Override
	public JWSObjectBuilder addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		jwsHeader.addX509Certificate(x509Certificate);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	@Override
	public JWSObjectBuilder setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		jwsHeader.setX509CertificateChains(x509CertificateChains);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	@Override
	public JWSObjectBuilder setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
		jwsHeader.setX509CertificateSHA1Thumbprint(x509CertificateSHA1Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	@Override
	public JWSObjectBuilder setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
		jwsHeader.setX509CertificateSHA256Thumbprint(x509CertificateSHA256Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setType(za.co.sindi.jsonweb.jose.MediaType)
	 */
	@Override
	public JWSObjectBuilder setType(MediaType type) {
		// TODO Auto-generated method stub
		jwsHeader.setType(type);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setContentType(za.co.sindi.jsonweb.jose.MediaType)
	 */
	@Override
	public JWSObjectBuilder setContentType(MediaType contentType) {
		// TODO Auto-generated method stub
		jwsHeader.setContentType(contentType);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#addCriticalHeader(java.lang.String)
	 */
	@Override
	public JWSObjectBuilder addCriticalHeader(String criticalHeader) {
		// TODO Auto-generated method stub
		jwsHeader.addCriticalHeader(criticalHeader);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWSObjectBuilder#setCriticalHeaders(java.lang.String[])
	 */
	@Override
	public JWSObjectBuilder setCriticalHeaders(String[] criticalHeaders) {
		// TODO Auto-generated method stub'
		jwsHeader.setCriticalHeaders(criticalHeaders);
		return this;
	}
}
