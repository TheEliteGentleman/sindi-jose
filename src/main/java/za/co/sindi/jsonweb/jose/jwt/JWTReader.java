/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

import java.io.Reader;

import za.co.sindi.jsonweb.jose.JOSEHeader;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 09 June 2016
 *
 */
public interface JWTReader {

	public <ALG extends Algorithm, HEADER extends JOSEHeader<ALG>> JWT<ALG, HEADER> read(Reader reader);
}
