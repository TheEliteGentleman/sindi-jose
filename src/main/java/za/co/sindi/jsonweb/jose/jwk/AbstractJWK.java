/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.AbstractJWObject;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONBuilderFactory;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONBuilderFactory;
import za.co.sindi.jsonweb.util.URLUtils;
import za.co.sindi.jsonweb.util.X509CertificateUtils;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public abstract class AbstractJWK extends AbstractJWObject implements JWK {

	private KeyType keyType;
	private PublicKeyUse publicKeyUse;
	private List<KeyOperation> keyOperations;
	private Algorithm algorithm;
	private String keyId;
	private URI x509URI;
	private List<X509Certificate> x509CertificateChains;
	private String x509CertificateSHA1Thumbprint;
	private String x509CertificateSHA256Thumbprint;
	
	/**
	 * @param keyType
	 */
	protected AbstractJWK(KeyType keyType) {
		super();
		PreConditions.checkArgument(keyType != null, "No " + JWKConstants.JWK_KEY_TYPE + " was specified.");
		this.keyType = keyType;
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.JWObject#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.JWK_KEY_TYPE), "No JWK parameter '" + Constants.JWK_KEY_TYPE + "' found.");
//		
////		setKeyType(KeyType.of(jsonObject.getString(Constants.JWK_KEY_TYPE)));
//		keyType = KeyType.of(jsonObject.getString(Constants.JWK_KEY_TYPE));
//		
//		if (!jsonObject.isNull(Constants.JWK_PUBLIC_KEY_USE)) {
//			setPublicKeyUse(PublicKeyUse.of(jsonObject.getString(Constants.JWK_PUBLIC_KEY_USE)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_KEY_OPERATIONS)) {
//			JSONArray jsonArray = jsonObject.getJSONArray(Constants.JWK_KEY_OPERATIONS);
//			if (!jsonArray.isEmpty()) {
//				for (int i = 0; i < jsonArray.size(); i++) {
//					addKeyOperation(KeyOperation.of(jsonArray.getString(i)));
//				}
//			}
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_ALGORITHM)) {
//			setAlgorithm(Algorithms.getAlgorithm(jsonObject.getString(Constants.JWK_ALGORITHM)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_KEY_ID)) {
//			setKeyId(jsonObject.getString(Constants.JWK_KEY_ID));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_X509_URL)) {
//			setX590URI(URI.create(jsonObject.getString(Constants.JWK_X509_URL)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_X509_CERTIFICATE_CHAIN)) {
//			JSONArray jsonArray = jsonObject.getJSONArray(Constants.JWK_X509_CERTIFICATE_CHAIN);
//			if (!jsonArray.isEmpty()) {
//				CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//				for (int i = 0; i < jsonArray.size(); i++) {
//					addX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(new Base64URLBytes(jsonArray.getString(i)).getActualValue())));
//				}
//			}
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT)) {
//			setX509CertificateSHA1Thumbprint(jsonObject.getString(Constants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT)) {
//			setX509CertificateSHA1Thumbprint(jsonObject.getString(Constants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT));
//		}
//		
////		readFully(jsonObject);
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObject#toJSONObject()
	 */
	public JSONObject toJSONObject() throws Exception {
		// TODO Auto-generated method stub
		JSONBuilderFactory factory = new DefaultJSONBuilderFactory();
		JSONObjectBuilder jsonObjectBuilder = factory.createJSONObjectBuilder();
		
		jsonObjectBuilder.add(JWKConstants.JWK_KEY_TYPE, getKeyType().toString());
		
		PublicKeyUse keyUse = getPublicKeyUse();
		if (keyUse != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_PUBLIC_KEY_USE, keyUse.toString());
		}
		
		KeyOperation[] operations = getKeyOperations();
		if (operations != null) {
			JSONArrayBuilder jsonArrayBuilder = factory.createJSONArrayBuilder();
			for (KeyOperation operation : operations) {
				jsonArrayBuilder.add(operation.toString());
			}
			
			jsonObjectBuilder.add(JWKConstants.JWK_KEY_OPERATIONS, jsonArrayBuilder);
		}
		
		Algorithm algorithm = getAlgorithm();
		if (algorithm != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_ALGORITHM, algorithm.getJwaAlgorithmName());
		}
		
		String keyId = getKeyId();
		if (keyId != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_KEY_ID, keyId);
		}
		
		URI x509URI = getX509URI();
		if (x509URI != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_X509_URL, x509URI.toString());
		}
		
		X509Certificate[] x509CertificateChains = getX509CertificateChains();
		if (x509CertificateChains != null) {
			JSONArrayBuilder jsonArrayBuilder = factory.createJSONArrayBuilder();
			for (X509Certificate x509CertificateChain : x509CertificateChains) {
				jsonArrayBuilder.add(X509CertificateUtils.base64Encode(x509CertificateChain));
			}
			
			jsonObjectBuilder.add(JWKConstants.JWK_X509_CERTIFICATE_CHAIN, jsonArrayBuilder);
		}
		
		String x509SHA1Thumbprint = getX509CertificateSHA1Thumbprint();
		if (x509SHA1Thumbprint != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT, x509SHA1Thumbprint);
		}
		
		String x509SHA256Thumbprint = getX509CertificateSHA256Thumbprint();
		if (x509SHA256Thumbprint != null) {
			jsonObjectBuilder.add(JWKConstants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT, x509SHA256Thumbprint);
		}
		
		populateJSONObject(jsonObjectBuilder);
		return jsonObjectBuilder.build();
	}
	

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getKeyType()
	 */
	public KeyType getKeyType() {
		// TODO Auto-generated method stub
//		return (KeyType) getParameter(Constants.JWK_KEY_TYPE);\
		return keyType;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getPublicKeyUse()
	 */
	public PublicKeyUse getPublicKeyUse() {
		// TODO Auto-generated method stub
//		return (PublicKeyUse) getParameter(Constants.JWK_PUBLIC_KEY_USE);
		return publicKeyUse;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setPublicKeyUse(za.co.sindi.jsonweb.jose.jwk.PublicKeyUse)
	 */
	public void setPublicKeyUse(PublicKeyUse publicKeyUse) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JWK_PUBLIC_KEY_USE, publicKeyUse);
		this.publicKeyUse = publicKeyUse;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#addKeyOperation(za.co.sindi.jsonweb.jose.jwk.KeyOperation)
	 */
	public void addKeyOperation(KeyOperation keyOperation) {
		// TODO Auto-generated method stub
		if (keyOperation != null) {
//			@SuppressWarnings("unchecked")
//			List<KeyOperation> keyOperations = (List<KeyOperation>) getParameter(Constants.JWK_KEY_OPERATIONS);
			if (keyOperations == null) {
				keyOperations = new ArrayList<KeyOperation>();
			}
			
			keyOperations.add(keyOperation);
//			setParameter(Constants.JWK_KEY_OPERATIONS, keyOperations);
		} /*else {
			setParameter(Constants.JWK_KEY_OPERATIONS, null);
		}*/
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getKeyOperations()
	 */
	public KeyOperation[] getKeyOperations() {
		// TODO Auto-generated method stub
//		@SuppressWarnings("unchecked")
//		List<KeyOperation> keyOperations = (List<KeyOperation>) getParameter(Constants.JWK_KEY_OPERATIONS);
		if (keyOperations == null) {
			return null;
		}
		
		return keyOperations.toArray(new KeyOperation[keyOperations.size()]);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setKeyOperations(za.co.sindi.jsonweb.jose.jwk.KeyOperation[])
	 */
	public void setKeyOperations(KeyOperation[] keyOperations) {
		// TODO Auto-generated method stub
//		if (keyOperations != null) {
//			List<KeyOperation> operations = new ArrayList<KeyOperation>();
//			operations.addAll(Arrays.asList(keyOperations));
//			setParameter(Constants.JWK_KEY_OPERATIONS, operations);
//		} else {
//			setParameter(Constants.JWK_KEY_OPERATIONS, null);
//		}
		if (keyOperations != null) {
			if (this.keyOperations == null) {
				this.keyOperations = new ArrayList<KeyOperation>();
			}
			
			this.keyOperations.addAll(Arrays.asList(keyOperations));
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getAlgorithm()
	 */
	public Algorithm getAlgorithm() {
		// TODO Auto-generated method stub
//		return (Algorithm) getParameter(Constants.JWK_ALGORITHM);
		return algorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setAlgorithm(za.co.sindi.jsonweb.jose.jwa.Algorithm)
	 */
	public void setAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JWK_ALGORITHM, algorithm);
		this.algorithm = algorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getKeyId()
	 */
	public String getKeyId() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JWK_KEY_ID);
		return keyId;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setKeyId(java.lang.String)
	 */
	public void setKeyId(String keyId) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JWK_KEY_ID, keyId);
		this.keyId = keyId;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getX509URI()
	 */
	public URI getX509URI() {
		// TODO Auto-generated method stub
//		return (URI) getParameter(Constants.JWK_X509_URL);
		return x509URI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setX590URI(java.net.URI)
	 */
	public void setX590URI(URI x509URI) {
		// TODO Auto-generated method stub
		if (x509URI != null) {
			PreConditions.checkSate(URLUtils.exists(x509URI), "X.509 URI " + x509URI.toString() + " does not exist.");
			PreConditions.checkState("https".equalsIgnoreCase(x509URI.getScheme()), "X.509 URI " + x509URI.toString() + " is not a secured HTTP protocol https.");
		}
//		setParameter(Constants.JWK_X509_URL, uri);
		this.x509URI = x509URI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#addX509Certificate(java.security.cert.X509Certificate)
	 */
	public void addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		if (x509Certificate != null) {
//			@SuppressWarnings("unchecked")
//			List<X509Certificate> x509CertificateChains = (List<X509Certificate>) getParameter(Constants.JWK_X509_CERTIFICATE_CHAIN);
			if (x509CertificateChains == null) {
				x509CertificateChains = new ArrayList<X509Certificate>();
			}
			
			x509CertificateChains.add(x509Certificate);
		} /*else {
			setParameter(Constants.JWK_X509_CERTIFICATE_CHAIN, null);
		}*/
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getX509CertificateChains()
	 */
	public X509Certificate[] getX509CertificateChains() {
		// TODO Auto-generated method stub
//		@SuppressWarnings("unchecked")
//		List<X509Certificate> x509CertificateChains = (List<X509Certificate>) getParameter(Constants.JWK_X509_CERTIFICATE_CHAIN);
		if (x509CertificateChains != null) {
			return x509CertificateChains.toArray(new X509Certificate[x509CertificateChains.size()]);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
	public void setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		if (x509CertificateChains != null) {
			if (this.x509CertificateChains == null) {
				this.x509CertificateChains = new ArrayList<X509Certificate>();
			}
			this.x509CertificateChains.addAll(Arrays.asList(x509CertificateChains));
//			setParameter(Constants.JWK_X509_CERTIFICATE_CHAIN, this.x509CertificateChains);
		} /*else {
			setParameter(Constants.JWK_X509_CERTIFICATE_CHAIN, null);
		}*/
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getX509CertificateSHA1Thumbprint()
	 */
	public String getX509CertificateSHA1Thumbprint() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT);
		return x509CertificateSHA1Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
	public void setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT, x509CertificateSHA1Thumbprint);
		this.x509CertificateSHA1Thumbprint = x509CertificateSHA1Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#getX509CertificateSHA256Thumbprint()
	 */
	public String getX509CertificateSHA256Thumbprint() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JWK_X509_CERTIFICATE_SHA256_THUMBPRINT);
		return x509CertificateSHA256Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWK#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
	public void setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT, x509CertificateSHA256Thumbprint);
		this.x509CertificateSHA256Thumbprint = x509CertificateSHA256Thumbprint;
	}
	
//	protected abstract void readFully(final JSONObject jsonObject) throws Exception;
	protected abstract void populateJSONObject(final JSONObjectBuilder jsonObjectBuilder);
}
