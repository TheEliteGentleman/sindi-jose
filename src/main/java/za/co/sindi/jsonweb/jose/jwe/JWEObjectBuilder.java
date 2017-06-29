/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.JWObjectBuilder;
import za.co.sindi.jsonweb.jose.MediaType;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public interface JWEObjectBuilder extends JWObjectBuilder<JWEJOSEHeader> {
	
	public JWEObjectBuilder setJWKSetURI(final URI jwkSetURI);
	
	public JWEObjectBuilder setJSONWebKey(final PublicJWK jsonWebKey);
	
	public JWEObjectBuilder setKeyId(final String keyId);
	
	public JWEObjectBuilder setX590URI(final URI uri);
	
	public JWEObjectBuilder addX509Certificate(final X509Certificate x509Certificate);
	public JWEObjectBuilder setX509CertificateChains(final X509Certificate[] x509CertificateChains);
	
	public JWEObjectBuilder setX509CertificateSHA1Thumbprint(final String x509CertificateSHA1Thumbprint);
	
	public JWEObjectBuilder setX509CertificateSHA256Thumbprint(final String x509CertificateSHA256Thumbprint);
	
	public JWEObjectBuilder setType(final MediaType type);
	
	public JWEObjectBuilder setContentType(final MediaType contentType);
	
	public JWEObjectBuilder addCriticalHeader(final String criticalHeader);
	public JWEObjectBuilder setCriticalHeaders(final String[] criticalHeaders);

	public JWEObjectBuilder setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm);
}
