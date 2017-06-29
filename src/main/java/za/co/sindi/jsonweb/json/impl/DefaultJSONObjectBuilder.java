/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.json.JSONNull;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 11 April 2016
 *
 */
public class DefaultJSONObjectBuilder implements JSONObjectBuilder {

	private net.sf.json.JSONObject jsonObject;
	
	/**
	 * 
	 */
	public DefaultJSONObjectBuilder() {
		super();
		// TODO Auto-generated constructor stub
		jsonObject = new net.sf.json.JSONObject();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, java.lang.Object)
	 */
	public JSONObjectBuilder add(String name, Object value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, java.lang.String)
	 */
	public JSONObjectBuilder add(String name, String value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, java.math.BigInteger)
	 */
	public JSONObjectBuilder add(String name, BigInteger value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, java.math.BigDecimal)
	 */
	public JSONObjectBuilder add(String name, BigDecimal value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, int)
	 */
	public JSONObjectBuilder add(String name, int value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, long)
	 */
	public JSONObjectBuilder add(String name, long value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, double)
	 */
	public JSONObjectBuilder add(String name, double value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, boolean)
	 */
	public JSONObjectBuilder add(String name, boolean value) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#addNull(java.lang.String)
	 */
	public JSONObjectBuilder addNull(String name) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, JSONNull.getInstance());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	public JSONObjectBuilder add(String name, JSONObjectBuilder builder) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, ((DefaultJSONObject)builder.build()).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, za.co.sindi.jsonweb.json.JSONArrayBuilder)
	 */
	public JSONObjectBuilder add(String name, JSONArrayBuilder builder) {
		// TODO Auto-generated method stub
		jsonObject = jsonObject.element(name, ((DefaultJSONArray)builder.build()).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public JSONObjectBuilder add(String name, JSONObject json) {
		// TODO Auto-generated method stub
		if (!Strings.isNullOrEmpty(name) && json != null) {
			jsonObject = jsonObject.element(name, ((DefaultJSONObject)json).unwrap());
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#add(java.lang.String, za.co.sindi.jsonweb.json.JSONArray)
	 */
	@Override
	public JSONObjectBuilder add(String name, JSONArray jsonArray) {
		// TODO Auto-generated method stub
		if (!Strings.isNullOrEmpty(name) && jsonArray != null) {
			jsonObject = jsonObject.element(name, ((DefaultJSONArray)jsonArray).unwrap());
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONObjectBuilder#build()
	 */
	public JSONObject build() {
		// TODO Auto-generated method stub
		return new DefaultJSONObject(jsonObject);
	}
}
