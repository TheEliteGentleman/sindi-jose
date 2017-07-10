/**
 * 
 */
package za.co.sindi.jsonweb.test;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import za.co.sindi.codec.Strings;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.MediaType;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSException;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSObjectBuilder;
import za.co.sindi.jsonweb.jose.jws.JWSPayloads;
import za.co.sindi.jsonweb.jose.jws.impl.GeneralJWSJSONSerialization;
import za.co.sindi.jsonweb.jose.jws.impl.JWSCompactDeserialization;
import za.co.sindi.jsonweb.jose.jws.impl.JWSCompactSerialization;
import za.co.sindi.jsonweb.util.Base64URLUtils;

/**
 * @author Bienfait Sindi
 * @since 17 May 2017
 *
 */
public class JOSETest {

	public static final String PAYLOAD_STRING = "The true sign of intelligence is not knowledge but imagination.";
	
	public static void testJWSCompactNoneSerialization() throws JWSException {
		JWSAlgorithm algorithm = JWSAlgorithm.NONE;
		JWSObjectBuilder jwsBuilder = JOSE.createJWSObjectBuilder(algorithm).setType(MediaType.JWT);
		JWSJOSEHeader header = jwsBuilder.build();
		
		JWSCompactSerialization serializer = new JWSCompactSerialization();
//			serializer.setPayloadDetached(true);
		String serializedJws = serializer.serialize(header, JWSPayloads.newPayload(PAYLOAD_STRING), null);
		System.out.println(serializedJws);
		
		//Verify and deserialize
		JWSCompactDeserialization deserializer = new JWSCompactDeserialization();
		deserializer.deserialize(serializedJws, null);
		System.out.println("Payload: " + Strings.asUTF8String(deserializer.getUnsignedJwsPayload()));
	}
	
	public static void testJWSCompactSerialization() throws JWSException {
		try {
			JWSAlgorithm algorithm = JWSAlgorithm.HS256;
			JWSObjectBuilder jwsBuilder = JOSE.createJWSObjectBuilder(algorithm).setType(MediaType.JWT);
			JWSJOSEHeader header = jwsBuilder.build();
			KeyGenerator generator = KeyGenerator.getInstance(algorithm.getJcaAlgorithmName());
			generator.init(256);
			SecretKey key = generator.generateKey(); //new SecretKeySpec(Strings.toUTF8Bytes("secret"), algorithm.getJcaAlgorithmName());
			System.out.println(Strings.asASCIIString(Base64URLUtils.base64UrlEncode(key.getEncoded())));
			JWSCompactSerialization serializer = new JWSCompactSerialization();
//			serializer.setPayloadDetached(true);
			String serializedJws = serializer.serialize(header, JWSPayloads.newPayload(PAYLOAD_STRING), key);
			System.out.println(serializedJws);
			
			//Verify and deserialize
			JWSCompactDeserialization deserializer = new JWSCompactDeserialization(JWSPayloads.newPayload(PAYLOAD_STRING));
			deserializer.deserialize(serializedJws, key);
			System.out.println("Payload: " + Strings.asUTF8String(deserializer.getUnsignedJwsPayload()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
	}
	
	public static void testJWSJSONSerialization() throws JWSException {
		try {
			JWSAlgorithm algorithm = JWSAlgorithm.HS256;
			JWSObjectBuilder jwsBuilder = JOSE.createJWSObjectBuilder(algorithm).setType(MediaType.JWT);
			JWSJOSEHeader header = jwsBuilder.build();
			KeyGenerator generator = KeyGenerator.getInstance(algorithm.getJcaAlgorithmName());
			generator.init(256);
			SecretKey key = generator.generateKey(); //new SecretKeySpec(Strings.toUTF8Bytes("secret"), algorithm.getJcaAlgorithmName());
			System.out.println(Strings.asASCIIString(Base64URLUtils.base64UrlEncode(key.getEncoded())));
			GeneralJWSJSONSerialization serializer = new GeneralJWSJSONSerialization(JWSPayloads.newPayload(PAYLOAD_STRING));
			String serializedJws = serializer.addSignature(header, null, key).serialize().toString();
			System.out.println(serializedJws);
			
			//Verify and deserialize
//			JWSCompactDeserialization deserializer = new JWSCompactDeserialization(JWSPayloads.newPayload(PAYLOAD_STRING));
//			deserializer.deserialize(serializedJws, key);
//			System.out.println("Payload: " + Strings.asUTF8String(deserializer.getUnsignedJwsPayload()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			System.out.println(Strings.asUTF8String(Base64Codec.getBase64UrlSafeCodec().encode(Strings.toASCIIBytes("foob"))));
//			System.out.println(Strings.asUTF8String(Base64Codec.getBase64UrlSafeCodec().decode(Strings.toASCIIBytes("Zm9vYg=="))));
//			System.out.println(Strings.asUTF8String(Base64Codec.getBase64UrlSafeCodec().withoutPadding().encode(Strings.toASCIIBytes("foob"))));
//			System.out.println(Strings.asUTF8String(Base64Codec.getBase64UrlSafeCodec().withoutPadding().decode(Strings.toASCIIBytes("Zm9vYg"))));
//			System.out.println(Strings.asUTF8String(Base64Codec.getBase64UrlSafeCodec().decode(Strings.toASCIIBytes("Zm9vYmE="))));
			testJWSCompactNoneSerialization();
			System.out.println();
			testJWSCompactSerialization();
			System.out.println();
			testJWSJSONSerialization();
			System.out.println();
		} catch (JWSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(Strings.asASCIIString(Base64.getUrlEncoder().withoutPadding().encode(Strings.toUTF8Bytes("foobar1234"))));
//		System.out.println((1/3) + " rem " + (1 % 3));
//		System.out.println((2/3) + " rem " + (2 % 3));
//		System.out.println((3/3) + " rem " + (3 % 3));
//		System.out.println((4/3) + " rem " + (4 % 3));
//		System.out.println((5/3) + " rem " + (5 % 3));
//		System.out.println((6/3) + " rem " + (6 % 3));
//		try {
//			JWEObjectBuilder jweBuilder = JOSE.createJWEObjectBuilder((JWEAlgorithm)Algorithms.getAlgorithm(JWAConstants.JWE_RSA_OAEP), (EncryptionAlgorithm)Algorithms.getAlgorithm(JWAConstants.JWE_ENC_A256GCM));
//			JWEJOSEHeader header = jweBuilder.build();
////			System.out.println(new String(new Base64URLCodec().encode(header.toString().getBytes(StandardCharsets.UTF_8))));
//			System.out.println(Strings.asUTF8String(Base64URLUtils.base64UrlEncode(Strings.toUTF8Bytes(header.toString()))));
//		} catch (EncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
