/**
 * 
 */
package za.co.sindi.jsonweb.util;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public final class URLUtils {

	private URLUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static boolean exists(URI uri) {
		try {
			return exists(uri.toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	public static boolean exists(URL url) {
		boolean followRedirects = HttpURLConnection.getFollowRedirects();
		try {
			if (followRedirects) {
				HttpURLConnection.setFollowRedirects(false);
			}
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			return httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		} finally {
			//Reset
			if (followRedirects) {
				HttpURLConnection.setFollowRedirects(true);
			}
		}
	}
}
