/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface JWSVerificationCryptographicAlgorithm extends CryptographicAlgorithm<JWSAlgorithm> {

//	public JWSAlgorithm getAlgorithm();
	public void initVerify(final Key key) throws GeneralSecurityException;
//	public void update(byte[] input) throws GeneralSecurityException;
//	public void update(byte[] input, int offset, int length) throws GeneralSecurityException;
	public void update(ByteBuffer input) throws GeneralSecurityException;
	public boolean verify(final byte[] signature) throws GeneralSecurityException;
	public boolean verify(final byte[] signature, int offset, int length) throws GeneralSecurityException;
}
