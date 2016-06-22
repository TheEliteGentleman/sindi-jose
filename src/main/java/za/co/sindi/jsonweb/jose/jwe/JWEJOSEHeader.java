/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import za.co.sindi.jsonweb.jose.JOSEHeader;

/**
 * @author Bienfait Sindi
 * @since 16 May 2016
 *
 */
public interface JWEJOSEHeader extends JOSEHeader<JWEAlgorithm> {

	public EncryptionAlgorithm getEncryptionAlgorithm();
	
	public CompressionAlgorithm getCompressionAlgorithm();
	public void setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm);
}
