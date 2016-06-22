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
public class DefaultJSONObject implements JSONObject {

	private net.sf.json.JSONObject jsonObject;
	
	/**
	 * @param jsonObject
	 */
	public DefaultJSONObject(net.sf.json.JSONObject jsonObject) {
		super();
		PreConditions.checkArgument(jsonObject != null, "JSONObject cannot be null.");
		this.jsonObject = jsonObject;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getJSONArray(java.lang.String)
	 */
	public JSONArray getJSONArray(String name) {
		// TODO Auto-generated method stub
		return new DefaultJSONArray(jsonObject.getJSONArray(name));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getJSONObject(java.lang.String)
	 */
	public JSONObject getJSONObject(String name) {
		// TODO Auto-generated method stub
		return new DefaultJSONObject(jsonObject.getJSONObject(name));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getBoolean(java.lang.String)
	 */
	public boolean getBoolean(String name) {
		// TODO Auto-generated method stub
		return jsonObject.getBoolean(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getBoolean(java.lang.String, boolean)
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		// TODO Auto-generated method stub
		return jsonObject.optBoolean(name, defaultValue);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getDouble(java.lang.String)
	 */
	@Override
	public double getDouble(String name) {
		// TODO Auto-generated method stub
		return jsonObject.getDouble(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getDouble(java.lang.String, double)
	 */
	@Override
	public double getDouble(String name, double defaultValue) {
		// TODO Auto-generated method stub
		return jsonObject.optDouble(name, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getInt(java.lang.String)
	 */
	public int getInt(String name) {
		// TODO Auto-generated method stub
		return jsonObject.getInt(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getInt(java.lang.String, int)
	 */
	public int getInt(String name, int defaultValue) {
		// TODO Auto-generated method stub
		return jsonObject.optInt(name, defaultValue);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getLong(java.lang.String)
	 */
	@Override
	public long getLong(String name) {
		// TODO Auto-generated method stub
		return jsonObject.getLong(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getLong(java.lang.String, long)
	 */
	@Override
	public long getLong(String name, long defaultValue) {
		// TODO Auto-generated method stub
		return jsonObject.optLong(name, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getString(java.lang.String)
	 */
	public String getString(String name) {
		// TODO Auto-generated method stub
		return jsonObject.getString(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#getString(java.lang.String, java.lang.String)
	 */
	public String getString(String name, String defaultValue) {
		// TODO Auto-generated method stub
		return jsonObject.optString(name, defaultValue);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#isNull(java.lang.String)
	 */
	public boolean isNull(String name) {
		// TODO Auto-generated method stub
		return jsonObject.get(name) == null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return jsonObject.toString();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObject#unwrap()
	 */
	public Object unwrap() {
		// TODO Auto-generated method stub
		return jsonObject;
	}
}
