/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

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
public interface JWSObjectBuilder extends JWObjectBuilder<JWSJOSEHeader> {
	
	public JWSObjectBuilder setAlgorithm(final JWSAlgorithm algorithm);

	public JWSObjectBuilder setJWKSetURI(final URI jwkSetURI);
	
	public JWSObjectBuilder setJSONWebKey(final PublicJWK jsonWebKey);
	
	public JWSObjectBuilder setKeyId(final String keyId);
	
	public JWSObjectBuilder setX590URI(final URI uri);
	
	public JWSObjectBuilder addX509Certificate(final X509Certificate x509Certificate);
	public JWSObjectBuilder setX509CertificateChains(final X509Certificate[] x509CertificateChains);
	
	public JWSObjectBuilder setX509CertificateSHA1Thumbprint(final String x509CertificateSHA1Thumbprint);
	
	public JWSObjectBuilder setX509CertificateSHA256Thumbprint(final String x509CertificateSHA256Thumbprint);
	
	public JWSObjectBuilder setType(final MediaType type);
	
	public JWSObjectBuilder setContentType(final MediaType contentType);
	
	public JWSObjectBuilder addCriticalHeader(final String criticalHeader);
	public JWSObjectBuilder setCriticalHeaders(final String[] criticalHeaders);
}
