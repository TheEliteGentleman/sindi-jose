/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import net.sf.json.JSONException;
import za.co.sindi.jsonweb.json.JSONReader;
import za.co.sindi.jsonweb.json.JSONReaderFactory;

/**
 * @author Bienfait Sindi
 * @since 10 April 2016
 *
 */
public class DefaultJSONReaderFactory implements JSONReaderFactory {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONReaderFactory#createReader(java.io.Reader)
	 */
	public JSONReader createReader(Reader reader) {
		// TODO Auto-generated method stub
		try {
			return new DefaultJSONReader(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JSONException(e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONReaderFactory#createReader(java.io.InputStream)
	 */
	public JSONReader createReader(InputStream in) {
		// TODO Auto-generated method stub
		try {
			return new DefaultJSONReader(new InputStreamReader(in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JSONException(e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONReaderFactory#createReader(java.io.InputStream, java.nio.charset.Charset)
	 */
	public JSONReader createReader(InputStream in, Charset charset) {
		// TODO Auto-generated method stub
		try {
			return new DefaultJSONReader(new InputStreamReader(in, charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JSONException(e);
		}
	}
}
