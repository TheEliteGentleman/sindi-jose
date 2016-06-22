/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 09 April 2016
 *
 */
public class DefaultJSONArray implements JSONArray {

	private net.sf.json.JSONArray jsonArray;
	
	/**
	 * @param jsonArray
	 */
	public DefaultJSONArray(net.sf.json.JSONArray jsonArray) {
		super();
		PreConditions.checkArgument(jsonArray != null, "JSONArray may not be null.");
		this.jsonArray = jsonArray;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getJSONObject(int)
	 */
	public JSONObject getJSONObject(int index) {
		// TODO Auto-generated method stub
		return new DefaultJSONObject(jsonArray.getJSONObject(index));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getJSONArray(int)
	 */
	public JSONArray getJSONArray(int index) {
		// TODO Auto-generated method stub
		return new DefaultJSONArray(jsonArray.getJSONArray(index));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getString(int)
	 */
	public String getString(int index) {
		// TODO Auto-generated method stub
		return jsonArray.getString(index);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getString(int, java.lang.String)
	 */
	public String getString(int index, String defaultValue) {
		// TODO Auto-generated method stub
		return jsonArray.optString(index, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getInt(int)
	 */
	public int getInt(int index) {
		// TODO Auto-generated method stub
		return jsonArray.getInt(index);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getInt(int, int)
	 */
	public int getInt(int index, int defaultValue) {
		// TODO Auto-generated method stub
		return jsonArray.optInt(index, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getBoolean(int)
	 */
	public boolean getBoolean(int index) {
		// TODO Auto-generated method stub
		return jsonArray.getBoolean(index);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#getBoolean(int, boolean)
	 */
	public boolean getBoolean(int index, boolean defaultValue) {
		// TODO Auto-generated method stub
		return jsonArray.optBoolean(index, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#isEmpty()
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return jsonArray.isEmpty();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#isNull(int)
	 */
	public boolean isNull(int index) {
		// TODO Auto-generated method stub
		return jsonArray.get(index) == null;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#size()
	 */
	public int size() {
		// TODO Auto-generated method stub
		return jsonArray.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return jsonArray.toString();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArray#unwrap()
	 */
	public Object unwrap() {
		// TODO Auto-generated method stub
		return jsonArray;
	}
}
