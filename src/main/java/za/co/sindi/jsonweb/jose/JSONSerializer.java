/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import za.co.sindi.jsonweb.jose.jwa.Algorithm;

/**
 * @author Bienfait Sindi
 * @since 17 May 2016
 *
 */
public interface JSONSerializer<JWA extends Algorithm, JW extends JOSEHeader<JWA>> extends Serializer {

}
