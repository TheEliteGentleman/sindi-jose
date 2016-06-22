/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Bienfait Sindi
 * @since 17 May 2016
 *
 */
public interface Serializer {

	public void serialize(Writer writer) throws IOException;
}
