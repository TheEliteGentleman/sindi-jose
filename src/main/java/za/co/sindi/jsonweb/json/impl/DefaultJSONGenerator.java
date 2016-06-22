/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

import net.sf.json.util.JSONBuilder;
import za.co.sindi.jsonweb.json.JSONGenerator;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public class DefaultJSONGenerator implements JSONGenerator {

	private JSONBuilder jsonBuilder;
	
	/**
	 * 
	 */
	public DefaultJSONGenerator(Writer writer) {
		super();
		// TODO Auto-generated constructor stub
		jsonBuilder = new JSONBuilder(writer);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeStartObject()
	 */
	public JSONGenerator writeStartObject() {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.object();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeStartObject(java.lang.String)
	 */
	public JSONGenerator writeStartObject(String name) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).object();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeStartArray()
	 */
	public JSONGenerator writeStartArray() {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.array();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeStartArray(java.lang.String)
	 */
	public JSONGenerator writeStartArray(String name) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).array();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeEndObject()
	 */
	public JSONGenerator writeEndObject() {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.endObject();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#writeEndArray()
	 */
	public JSONGenerator writeEndArray() {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.endArray();
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, char)
	 */
	public JSONGenerator write(String name, char value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, byte)
	 */
	public JSONGenerator write(String name, byte value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, short)
	 */
	public JSONGenerator write(String name, short value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, int)
	 */
	public JSONGenerator write(String name, int value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, double)
	 */
	public JSONGenerator write(String name, double value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, long)
	 */
	public JSONGenerator write(String name, long value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, float)
	 */
	public JSONGenerator write(String name, float value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, java.math.BigInteger)
	 */
	public JSONGenerator write(String name, BigInteger value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, java.math.BigDecimal)
	 */
	public JSONGenerator write(String name, BigDecimal value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, java.lang.Object)
	 */
	public JSONGenerator write(String name, Object value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONGenerator#write(java.lang.String, java.lang.String)
	 */
	public JSONGenerator write(String name, String value) {
		// TODO Auto-generated method stub
		jsonBuilder = jsonBuilder.key(name).value(value);
		return this;
	}
}
