/**
 * 
 */
package za.co.sindi.jsonweb;

/**
 * @author Bienfait Sindi
 * @since 10 May 2017
 *
 */
public interface JWObjectBuilder<T extends JWObject> {

	public T build();
}
