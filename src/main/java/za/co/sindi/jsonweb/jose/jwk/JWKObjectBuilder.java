/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.JWObjectBuilder;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 20 May 2017
 *
 */
public interface JWKObjectBuilder<T extends JWK, B extends JWKObjectBuilder<T, B>> extends JWObjectBuilder<T> {
	
//	public B setKeyType(final KeyType keyType);
	
	public B setPublicKeyUse(final PublicKeyUse publicKeyUse);

	public B addKeyOperation(final KeyOperation keyOperation);
	public B setKeyOperations(final KeyOperation[] keyOperations);
	
	public B setAlgorithm(final Algorithm algorithm);
	
	public B setKeyId(final String keyId);
	
	public B setX590URI(final URI uri);
	
	public B addX509Certificate(final X509Certificate x509Certificate);
	public B setX509CertificateChains(final X509Certificate[] x509CertificateChains);
	
	public B setX509CertificateSHA1Thumbprint(final String x509CertificateSHA1Thumbprint);
	
	public B setX509CertificateSHA256Thumbprint(final String x509CertificateSHA256Thumbprint);
}
