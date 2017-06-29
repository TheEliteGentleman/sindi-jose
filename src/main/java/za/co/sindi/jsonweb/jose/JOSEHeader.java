/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.Set;

import za.co.sindi.jsonweb.JWObject;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;

/**
 * @author Bienfait Sindi
 * @since 12 May 2016
 *
 */
public interface JOSEHeader<JWA extends Algorithm> extends JWObject {
	
	public JWA getAlgorithm();
	
	public URI getJWKSetURI();
//	public void setJWKSetURI(final URI jwkSetURI);
	
	public PublicJWK getJSONWebKey();
//	public void setJSONWebKey(final PublicJWK jsonWebKey);
	
	public String getKeyId();
//	public void setKeyId(final String keyId);
	
	public URI getX509URI();
//	public void setX590URI(final URI uri);
	
//	public void addX509Certificate(final X509Certificate x509Certificate);
	public X509Certificate[] getX509CertificateChains();
//	public void setX509CertificateChains(final X509Certificate[] x509CertificateChains);
	
	public String getX509CertificateSHA1Thumbprint();
//	public void setX509CertificateSHA1Thumbprint(final String x509CertificateSHA1Thumbprint);
	
	public String getX509CertificateSHA256Thumbprint();
//	public void setX509CertificateSHA256Thumbprint(final String x509CertificateSHA256Thumbprint);
	
	public MediaType getType();
//	public void setType(final MediaType type);
	
	public MediaType getContentType();
//	public void setContentType(final MediaType contentType);
	
//	public void addCriticalHeader(final String criticalHeader);
	public String[] getCriticalHeaders();
//	public void setCriticalHeaders(final String[] criticalHeaders);

	public Set<String> getRegisteredHeaderNames();
	public Set<String> getPrivateHeaderNames();
}
