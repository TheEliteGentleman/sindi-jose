/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.jose.MediaType;
import za.co.sindi.jsonweb.jose.jwe.CompressionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.EncryptionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader;
import za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public class DefaultJWEObjectBuilder implements JWEObjectBuilder {
	
	private JWEHeader jweHeader;
	
	/**
	 * @param algorithm
	 * @param encryptionAlgorithm
	 */
	public DefaultJWEObjectBuilder(JWEAlgorithm algorithm, EncryptionAlgorithm encryptionAlgorithm) {
		jweHeader = new JWEHeader(algorithm, encryptionAlgorithm);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public JWEJOSEHeader build() {
		// TODO Auto-generated method stub
		return jweHeader;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setJWKSetURI(java.net.URI)
	 */
	@Override
	public JWEObjectBuilder setJWKSetURI(URI jwkSetURI) {
		// TODO Auto-generated method stub
		jweHeader.setJWKSetURI(jwkSetURI);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setJSONWebKey(za.co.sindi.jsonweb.jose.jwk.PublicJWK)
	 */
	@Override
	public JWEObjectBuilder setJSONWebKey(PublicJWK jsonWebKey) {
		// TODO Auto-generated method stub
		jweHeader.setJSONWebKey(jsonWebKey);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setKeyId(java.lang.String)
	 */
	@Override
	public JWEObjectBuilder setKeyId(String keyId) {
		// TODO Auto-generated method stub
		jweHeader.setKeyId(keyId);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setX590URI(java.net.URI)
	 */
	@Override
	public JWEObjectBuilder setX590URI(URI uri) {
		// TODO Auto-generated method stub
		jweHeader.setX590URI(uri);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#addX509Certificate(java.security.cert.X509Certificate)
	 */
	@Override
	public JWEObjectBuilder addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		jweHeader.addX509Certificate(x509Certificate);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	@Override
	public JWEObjectBuilder setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		jweHeader.setX509CertificateChains(x509CertificateChains);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	@Override
	public JWEObjectBuilder setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
		jweHeader.setX509CertificateSHA1Thumbprint(x509CertificateSHA1Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	@Override
	public JWEObjectBuilder setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
		jweHeader.setX509CertificateSHA256Thumbprint(x509CertificateSHA256Thumbprint);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setType(za.co.sindi.jsonweb.jose.MediaType)
	 */
	@Override
	public JWEObjectBuilder setType(MediaType type) {
		// TODO Auto-generated method stub
		jweHeader.setType(type);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setContentType(za.co.sindi.jsonweb.jose.MediaType)
	 */
	@Override
	public JWEObjectBuilder setContentType(MediaType contentType) {
		// TODO Auto-generated method stub
		jweHeader.setContentType(contentType);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#addCriticalHeader(java.lang.String)
	 */
	@Override
	public JWEObjectBuilder addCriticalHeader(String criticalHeader) {
		// TODO Auto-generated method stub
		jweHeader.addCriticalHeader(criticalHeader);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setCriticalHeaders(java.lang.String[])
	 */
	@Override
	public JWEObjectBuilder setCriticalHeaders(String[] criticalHeaders) {
		// TODO Auto-generated method stub'
		jweHeader.setCriticalHeaders(criticalHeaders);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder#setCompressionAlgorithm(za.co.sindi.jsonweb.jose.jwe.CompressionAlgorithm)
	 */
	@Override
	public JWEObjectBuilder setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
		// TODO Auto-generated method stub
		jweHeader.setCompressionAlgorithm(compressionAlgorithm);
		return this;
	}
}
