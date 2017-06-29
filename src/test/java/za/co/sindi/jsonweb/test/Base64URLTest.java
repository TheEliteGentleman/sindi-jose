/**
 * 
 */
package za.co.sindi.jsonweb.test;

import net.sf.json.JSONObject;
import za.co.sindi.codec.Strings;
import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.jsonweb.util.Base64URLUtils;

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
		
//		Base64URLCodec codec = new Base64URLCodec();
		try {
//			System.out.println(new String(Base64URLUtils.encode(value.getBytes(StandardCharsets.UTF_8))));
//			System.out.println(new String(Base64URLUtils.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9".getBytes()), StandardCharsets.UTF_8));
			
			System.out.println(Strings.asUTF8String(Base64URLUtils.base64UrlEncode(Strings.toUTF8Bytes(value))));
			System.out.println(Strings.asUTF8String(Base64URLUtils.base64UrlDecode(Strings.toUTF8Bytes("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9"))));
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
