/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public interface JWSignature {

	public JWSAlgorithm getAlgorithm();
	public void update(byte[] data) throws JWSignatureException;
	public void update(byte[] data, int offset, int length) throws JWSignatureException;
	public byte[] sign() throws JWSignatureException;
}
