/**
 * 
 */
package za.co.sindi.jsonweb;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public interface Value<V, JSON> {

	public V getActualValue();
	public JSON getJSONValue();
}
