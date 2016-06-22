/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.io.IOException;
import java.io.Reader;

import net.sf.json.JSONSerializer;
import za.co.sindi.common.utils.IOUtils;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONReader;

/**
 * @author Bienfait Sindi
 * @since 09 April 2016
 *
 */
public class DefaultJSONReader implements JSONReader {

	private final String jsonString;
	
	/**
	 * @param reader
	 * @throws IOException 
	 */
	public DefaultJSONReader(Reader reader) throws IOException {
		super();
		PreConditions.checkArgument(reader != null, "A reader cannot be null.");
		jsonString = IOUtils.toString(reader);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONReader#readJSONObject()
	 */
	public JSONObject readJSONObject() {
		// TODO Auto-generated method stub
		return new DefaultJSONObject((net.sf.json.JSONObject) JSONSerializer.toJSON(jsonString));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONReader#readJSONArray()
	 */
	public JSONArray readJSONArray() {
		// TODO Auto-generated method stub
		return new DefaultJSONArray((net.sf.json.JSONArray) JSONSerializer.toJSON(jsonString));
	}
}
