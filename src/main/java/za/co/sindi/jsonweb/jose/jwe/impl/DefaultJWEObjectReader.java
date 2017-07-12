/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.net.URI;

import za.co.sindi.codec.Strings;
import za.co.sindi.jsonweb.AbstractJWObjectReader;
import za.co.sindi.jsonweb.jose.Constants;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.MediaType;
import za.co.sindi.jsonweb.jose.jwa.Algorithms;
import za.co.sindi.jsonweb.jose.jwe.CompressionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.EncryptionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEConstants;
import za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader;
import za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder;
import za.co.sindi.jsonweb.jose.jwe.JWEObjectReader;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.JWKKeyTypeUtils;
import za.co.sindi.jsonweb.jose.jwk.KeyType;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.util.X509CertificateUtils;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public class DefaultJWEObjectReader extends AbstractJWObjectReader<JWEJOSEHeader> implements JWEObjectReader {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.AbstractJWObjectReader#readObjectFully(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	protected JWEJOSEHeader readObjectFully(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		JWEObjectBuilder builder = JOSE.createJWEObjectBuilder((JWEAlgorithm)Algorithms.getAlgorithm(jsonObject.getString(Constants.JOSE_HEADER_ALGORITHM)), (EncryptionAlgorithm)Algorithms.getAlgorithm(jsonObject.getString(JWEConstants.JWE_HEADER_ENCRYPTION_ALGORITHM)));
		if (jsonObject.containsKey(JWEConstants.JWE_HEADER_COMPRESSION_ALGORITHM) && !jsonObject.isNull(JWEConstants.JWE_HEADER_COMPRESSION_ALGORITHM)) {
			builder.setCompressionAlgorithm(CompressionAlgorithm.of(jsonObject.getString(JWEConstants.JWE_HEADER_COMPRESSION_ALGORITHM)));
		}
			
		if (jsonObject.containsKey(Constants.JOSE_HEADER_JWK_SET_URL) && !jsonObject.isNull(Constants.JOSE_HEADER_JWK_SET_URL)) {
			builder.setJWKSetURI(URI.create(Constants.JOSE_HEADER_JWK_SET_URL));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_JWK) && !jsonObject.isNull(Constants.JOSE_HEADER_JWK)) {
			JSONObject jwkObject = jsonObject.getJSONObject(Constants.JOSE_HEADER_JWK);
			KeyType keyType = KeyType.of(jwkObject.getString(JWKConstants.JWK_KEY_TYPE));
//			builder.setJSONWebKey((PublicJWK) JWKeys.getJWK(keyType));
			builder.setJSONWebKey((PublicJWK)JWKKeyTypeUtils.getJWKObjectReader(keyType).readObject(jwkObject));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_KEY_ID) && !jsonObject.isNull(Constants.JOSE_HEADER_KEY_ID)) {
			builder.setKeyId(jsonObject.getString(Constants.JOSE_HEADER_KEY_ID));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_X509_URL) && !jsonObject.isNull(Constants.JOSE_HEADER_X509_URL)) {
			builder.setX590URI(URI.create(jsonObject.getString(Constants.JOSE_HEADER_X509_URL)));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN) && !jsonObject.isNull(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN)) {
			JSONArray jsonArray = jsonObject.getJSONArray(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN);
			if (!jsonArray.isEmpty()) {
//				CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
				for (int i = 0; i < jsonArray.size(); i++) {
//					builder.addX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(new Base64URLBytes(jsonArray.getString(i)).getActualValue())));
					builder.addX509Certificate(X509CertificateUtils.base64Decode(Strings.toASCIIBytes(jsonArray.getString(i))));
				}
			}
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT) && !jsonObject.isNull(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT)) {
			builder.setX509CertificateSHA1Thumbprint(jsonObject.getString(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT) && !jsonObject.isNull(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT)) {
			builder.setX509CertificateSHA256Thumbprint(jsonObject.getString(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT));
		}
		
		if (jsonObject.containsKey(Constants.JOSE_HEADER_TYPE) && !jsonObject.isNull(Constants.JOSE_HEADER_TYPE)) {
			builder.setType(MediaType.from(jsonObject.getString(Constants.JOSE_HEADER_TYPE)));
		}
		
		return builder.build();
	}
}
