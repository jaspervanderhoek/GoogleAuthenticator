// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package googleauthenticator.proxies.constants;

import com.mendix.core.Core;

public class Constants
{
	// These are the constants for the GoogleAuthenticator module

	/**
	* This will be the prefix of your entry in the Google Authenticator app.
	* If your constant reads: MyApp   In google authenticator you will see "MyApp (MxAdmin)"
	* 
	*/
	public static java.lang.String getNameTemplate()
	{
		return (java.lang.String)Core.getConfiguration().getConstantValue("GoogleAuthenticator.NameTemplate");
	}
}