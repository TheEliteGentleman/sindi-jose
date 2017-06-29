/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.net.URI;
import java.security.cert.X509Certificate;

import za.co.sindi.jsonweb.JWObject;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public interface JWK extends JWObject {

	public KeyType getKeyType();
//	public void setKeyType(final KeyType keyType);
	
	public PublicKeyUse getPublicKeyUse();
//	public void setPublicKeyUse(final PublicKeyUse publicKeyUse);

//	public void addKeyOperation(final KeyOperation keyOperation);
	public KeyOperation[] getKeyOperations();
//	public void setKeyOperations(final KeyOperation[] keyOperations);
	
	public Algorithm getAlgorithm();
//	public void setAlgorithm(final Algorithm algorithm);
	
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
}
