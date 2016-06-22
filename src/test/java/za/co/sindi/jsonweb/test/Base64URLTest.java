/**
 * 
 */
package za.co.sindi.jsonweb.test;

import java.nio.charset.StandardCharsets;

import net.sf.json.JSONObject;
import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.jsonweb.util.Base64URLCodec;

/**
 * @author Bienfait Sindi
 * @since 05 April 2016
 *
 */
public class Base64URLTest {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("typ", "JWT");
		json.put("alg", "HS256");
		String value = json.toString();
		
		Base64URLCodec codec = new Base64URLCodec();
		try {
			System.out.println(new String(codec.encode(value.getBytes(StandardCharsets.UTF_8))));
			System.out.println(new String(codec.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9".getBytes()), StandardCharsets.UTF_8));
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
