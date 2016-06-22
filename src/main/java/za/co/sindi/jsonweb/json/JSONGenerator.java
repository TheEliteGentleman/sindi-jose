/**
 * 
 */
package za.co.sindi.jsonweb.json;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface JSONGenerator {

	public JSONGenerator writeStartObject();
	public JSONGenerator writeStartObject(String name);
	public JSONGenerator writeStartArray();
	public JSONGenerator writeStartArray(String name);
	public JSONGenerator writeEndObject();
	public JSONGenerator writeEndArray();
	public JSONGenerator write(String name, char value);
	public JSONGenerator write(String name, byte value);
	public JSONGenerator write(String name, short value);
	public JSONGenerator write(String name, int value);
	public JSONGenerator write(String name, double value);
	public JSONGenerator write(String name, long value);
	public JSONGenerator write(String name, float value);
	public JSONGenerator write(String name, BigInteger value);
	public JSONGenerator write(String name, BigDecimal value);
	public JSONGenerator write(String name, Object value);
	public JSONGenerator write(String name, String value);
}
