/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

import za.co.sindi.jsonweb.jose.JOSEHeader;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 09 June 2016
 *
 */
public interface JWTBuilder<ALG extends Algorithm, HEADER extends JOSEHeader<ALG>> {

	public JWT<ALG, HEADER> build();
}
