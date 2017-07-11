/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

import java.security.GeneralSecurityException;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface CryptographicAlgorithm<JWA extends Algorithm> {

	public JWA getAlgorithm();
//	public void init(final Key key) throws GeneralSecurityException;
	public void update(byte[] input) throws GeneralSecurityException;
	public void update(byte[] input, int offset, int length) throws GeneralSecurityException;
//	public void update(ByteBuffer input) throws GeneralSecurityException;
//	public byte[] compute() throws GeneralSecurityException;
}
