// This file was generated by Mendix Modeler 6.0.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package test.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;

public class Microflows
{
	// These are the microflows for the Test module
	public static void iVK_IsCodeValid(IContext context, test.proxies.ValidityCheck _validityCheck)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ValidityCheck", _validityCheck == null ? null : _validityCheck.getMendixObject());
			Core.execute(context, "Test.IVK_IsCodeValid", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_NewUser(IContext context, test.proxies.Credential _credential)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Credential", _credential == null ? null : _credential.getMendixObject());
			Core.execute(context, "Test.IVK_NewUser", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_ShowCheckCode(IContext context, test.proxies.Credential _credential)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Credential", _credential == null ? null : _credential.getMendixObject());
			Core.execute(context, "Test.IVK_ShowCheckCode", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}