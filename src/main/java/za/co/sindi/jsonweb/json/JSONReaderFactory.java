/**
 * 
 */
package za.co.sindi.jsonweb.json;

import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * @author Bienfait Sindi
 * @since 09 April 2016
 *
 */
public interface JSONReaderFactory {

    public JSONReader createReader(Reader reader);

    public JSONReader createReader(InputStream in);

    public JSONReader createReader(InputStream in, Charset charset);
}
