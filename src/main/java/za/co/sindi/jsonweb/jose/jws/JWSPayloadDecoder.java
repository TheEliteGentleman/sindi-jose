/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 * 
 */
public interface JWSPayloadDecoder<T> {

	public T decode(final byte[] rawBytes);
}
