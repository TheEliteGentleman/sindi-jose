/**
 * 
 */
package za.co.sindi.jsonweb.json;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface JSONGeneratorFactory {

	public JSONGenerator createGenerator(Writer writer);
	
	public JSONGenerator createGenerator(OutputStream out);
	
	public JSONGenerator createGenerator(OutputStream out, Charset charset);
}
