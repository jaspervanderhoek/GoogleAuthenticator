// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package googleauthenticator.actions;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

/**
 * This action generates a secret key and the URL which can be represented with a QR code in the Google Authenticator app.
 * 
 * * Issuer name is the name shown in Google Authenticator app.
 * 
 * * Username is the name shown in Google Authenticator app.
 *     
 * * Credentials object
 *     An object is required as input parameter and must contain the following attribute:
 *         - ga_SecretKey : String(200)
 *         - ga_OtpAuthURL : String(unlimited)
 *    
 * 
 * The secretkey has to be used to authenticate a validation code generated by the Google Authenticator App.
 */
public class CreateCredentials extends CustomJavaAction<String>
{
	private String Issuer;
	private String UserName;
	private IMendixObject CredentialsToSet;

	public CreateCredentials(IContext context, String Issuer, String UserName, IMendixObject CredentialsToSet)
	{
		super(context);
		this.Issuer = Issuer;
		this.UserName = UserName;
		this.CredentialsToSet = CredentialsToSet;
	}

	@Override
	public String executeAction() throws Exception
	{
		// BEGIN USER CODE
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		final GoogleAuthenticatorKey key = gAuth.createCredentials();
		
		StringBuilder q = new StringBuilder("secret=" );
		q.append(key.getKey());
		if(Issuer != null && !Issuer.isEmpty()) {
			q.append("&");
			q.append("issuer=");
			q.append(this.Issuer);
		}
		
	    URI uri = new URI("otpauth", null, "totp", -1, "/" + this.Issuer +":" + UserName ,q.toString(), null);
		
		CredentialsToSet.setValue(getContext(), "ga_SecretKey", key.getKey());	
				
		return uri.toASCIIString();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "CreateCredentials";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
