/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.json.JSONNull;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 11 April 2016
 *
 */
public class DefaultJSONArrayBuilder implements JSONArrayBuilder {

	private net.sf.json.JSONArray jsonArray;
	
	/**
	 * 
	 */
	public DefaultJSONArrayBuilder() {
		super();
		// TODO Auto-generated constructor stub
		jsonArray = new net.sf.json.JSONArray();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(java.lang.Object)
	 */
	public JSONArrayBuilder add(Object value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(java.lang.String)
	 */
	public JSONArrayBuilder add(String value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(java.math.BigDecimal)
	 */
	public JSONArrayBuilder add(BigDecimal value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(java.math.BigInteger)
	 */
	public JSONArrayBuilder add(BigInteger value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(int)
	 */
	public JSONArrayBuilder add(int value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(long)
	 */
	public JSONArrayBuilder add(long value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(double)
	 */
	public JSONArrayBuilder add(double value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(boolean)
	 */
	public JSONArrayBuilder add(boolean value) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#addNull()
	 */
	public JSONArrayBuilder addNull() {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(JSONNull.getInstance());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	public JSONArrayBuilder add(JSONObjectBuilder builder) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(((DefaultJSONObject)builder.build()).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(za.co.sindi.jsonweb.json.JSONArrayBuilder)
	 */
	public JSONArrayBuilder add(JSONArrayBuilder builder) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(((DefaultJSONArray)builder.build()).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public JSONArrayBuilder add(JSONObject json) {
		// TODO Auto-generated method stub
		jsonArray = jsonArray.element(((DefaultJSONObject)json).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#add(za.co.sindi.jsonweb.json.JSONArray)
	 */
	@Override
	public JSONArrayBuilder add(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		this.jsonArray = this.jsonArray.element(((DefaultJSONArray)jsonArray).unwrap());
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONArrayBuilder#build()
	 */
	public JSONArray build() {
		// TODO Auto-generated method stub
		return new DefaultJSONArray(jsonArray);
	}
}
