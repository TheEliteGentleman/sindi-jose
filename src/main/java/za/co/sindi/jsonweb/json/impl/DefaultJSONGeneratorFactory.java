/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

import za.co.sindi.jsonweb.json.JSONGenerator;
import za.co.sindi.jsonweb.json.JSONGeneratorFactory;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public class DefaultJSONGeneratorFactory implements JSONGeneratorFactory {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGeneratorFactory#createGenerator(java.io.Writer)
	 */
	public JSONGenerator createGenerator(Writer writer) {
		// TODO Auto-generated method stub
		return new DefaultJSONGenerator(writer);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGeneratorFactory#createGenerator(java.io.OutputStream)
	 */
	public JSONGenerator createGenerator(OutputStream out) {
		// TODO Auto-generated method stub
		return new DefaultJSONGenerator(new OutputStreamWriter(out));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGeneratorFactory#createGenerator(java.io.OutputStream, java.nio.charset.Charset)
	 */
	public JSONGenerator createGenerator(OutputStream out, Charset charset) {
		// TODO Auto-generated method stub
		try {
			return new DefaultJSONGenerator(new OutputStreamWriter(out, charset.name()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
