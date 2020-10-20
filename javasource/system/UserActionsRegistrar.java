package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(googleauthenticator.actions.CreateCredentials.class);
    registrator.registerUserAction(googleauthenticator.actions.EndSession.class);
    registrator.registerUserAction(googleauthenticator.actions.InDevMode.class);
    registrator.registerUserAction(googleauthenticator.actions.IsCodeValid.class);
    registrator.registerUserAction(googleauthenticator.actions.LogAttemptKillSessionThrowException.class);
    registrator.registerUserAction(googleauthenticator.actions.OverrideLoginAction.class);
    registrator.registerUserAction(googleauthenticator.actions.ReLoginCurrentUser.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
