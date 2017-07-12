/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.AbstractJWObjectReader;
import za.co.sindi.jsonweb.Base64URLBytes;
import za.co.sindi.jsonweb.jose.jwa.Algorithms;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public abstract class AbstractJWKObjectReader<T extends JWK, B extends JWKObjectBuilder<T,B>> extends AbstractJWObjectReader<T> implements JWKObjectReader<T> {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.AbstractJWObjectReader#readObjectFully(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	protected T readObjectFully(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkState(jsonObject.containsKey(JWKConstants.JWK_KEY_TYPE) && !jsonObject.isNull(JWKConstants.JWK_KEY_TYPE), "No JWK parameter '" + JWKConstants.JWK_KEY_TYPE + "' found.");
		
		B builder = createJWKObjectBuilder();
//		builder.setKeyType(KeyType.of(jsonObject.getString(Constants.JWK_KEY_TYPE))); //Not Necessary...
		
		if (jsonObject.containsKey(JWKConstants.JWK_PUBLIC_KEY_USE) && !jsonObject.isNull(JWKConstants.JWK_PUBLIC_KEY_USE)) {
			builder.setPublicKeyUse(PublicKeyUse.of(jsonObject.getString(JWKConstants.JWK_PUBLIC_KEY_USE)));
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_KEY_OPERATIONS) && !jsonObject.isNull(JWKConstants.JWK_KEY_OPERATIONS)) {
			JSONArray jsonArray = jsonObject.getJSONArray(JWKConstants.JWK_KEY_OPERATIONS);
			if (!jsonArray.isEmpty()) {
				for (int i = 0; i < jsonArray.size(); i++) {
					builder.addKeyOperation(KeyOperation.of(jsonArray.getString(i)));
				}
			}
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_ALGORITHM) && !jsonObject.isNull(JWKConstants.JWK_ALGORITHM)) {
			builder.setAlgorithm(Algorithms.getAlgorithm(jsonObject.getString(JWKConstants.JWK_ALGORITHM)));
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_KEY_ID) && !jsonObject.isNull(JWKConstants.JWK_KEY_ID)) {
			builder.setKeyId(jsonObject.getString(JWKConstants.JWK_KEY_ID));
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_X509_URL) && !jsonObject.isNull(JWKConstants.JWK_X509_URL)) {
			builder.setX590URI(URI.create(jsonObject.getString(JWKConstants.JWK_X509_URL)));
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_X509_CERTIFICATE_CHAIN) && !jsonObject.isNull(JWKConstants.JWK_X509_CERTIFICATE_CHAIN)) {
			JSONArray jsonArray = jsonObject.getJSONArray(JWKConstants.JWK_X509_CERTIFICATE_CHAIN);
			if (!jsonArray.isEmpty()) {
				CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
				for (int i = 0; i < jsonArray.size(); i++) {
					builder.addX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(new Base64URLBytes(jsonArray.getString(i)).getActualValue())));
				}
			}
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT) && !jsonObject.isNull(JWKConstants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT)) {
			builder.setX509CertificateSHA1Thumbprint(jsonObject.getString(JWKConstants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT));
		}
		
		if (jsonObject.containsKey(JWKConstants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT) && !jsonObject.isNull(JWKConstants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT)) {
			builder.setX509CertificateSHA1Thumbprint(jsonObject.getString(JWKConstants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT));
		}
		
		build(builder, jsonObject);
		return builder.build();
	}
	
	protected abstract B createJWKObjectBuilder();
	protected abstract void build(B jwkObjectBuilder, JSONObject jsonObject) throws Exception;
}
