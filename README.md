# GoogleAuthenticator Connector
 
## Introduction

This connector enables you to setup two-factor authentication for your users. This is achieved by creating a separate role and isolating the user after the regular user/password authentication. No additional development effort is required when setting up this module. This module only works with the built-in authentication, but with minimal (java) code this can easily be adapted to be compatible with any other form of authentication.


## Setup steps:
1. Added the microflow AfterStartup to your startup microflow
2. Replace your home pages with the microflow Nav_HomePage. You must use this microflow as the home page for all roles.   Add a subflow at the end of this microflow which can evaluate the pages to open.
3. Change the NameTemplate Constant, this will be the name of the app that shows in your authenticator app.
4. Add the required UI components to reset the authenticator. Either add the page UsersWithGoogleAuthSetup to the menu or include the AccountEditSnippet in your account edit page. Both allow your admin user to remove an GoogleAuth link.
5. Add the 'Admin' module rules to your admin user. 
6. Create an userrole with the name: AuthUser. and only assign the module role 'AuthUser' to it. Nothing else, this role is used by the module to lock down the authentication process.   The after startup microflow retrieves this role and passes it to Java, you might need to change this retrieve activity.
   DO NOT add the role 'AuthUser' to any user! 
   NEVER Assign the role 'Tester' to any of your module roles. this is an god-admin user that is only used for testing and troubleshooting. 


## How it works
When a user signs in there is a Java action that has overriden the standard login process. When a user enters a valid username and password, it will prep for the two-factor auth. It sets up the GAuth entity.

First it copies the users original roles to this entity as a backup.
Then it will reset the users roles, and only assign user role: 'AuthUser' 

Continuing with the login process, if the user has the AuthUser role it will lookup the GAuth data. 
If GAuth has never been setup it will show a QR code to add to the Google Auth app, and a box to confirm the setup by entering the current code in their app.  If correct all info is stored.

After successful setup of the new GAuth link, or validation of an existing code, the user clicks a nanoflow button. This will trigger a microflow to reset the userroles from the user back to the original, once that's done the NanoFlow will refresh the page and the user has successfully authenticated.

In development there is a separate page that is shown that allows the user to skip two-factor auth locally. This page and the MF explicitly checks if DevMode is on/off, so locally you can sign on without having to enter the code every time. 
The module does require 2FA to be setup before it allows skipping. 


## Example
The GitHub project of this module contains a working example.

## Dependencies
- Mx8.10 or higher
- Not compatible with any of the other SSO modules
- googleauth-1.1.4.jar
- commons-codec-1.11.jar
- httpclient-4.5.6.jar

## Collaboration on this connector

Development of this connector is done through a git project on Github.

This connector uses the GoogleAuth library. https://github.com/wstrange/GoogleAuth/

## License

This connector is licensed under the Apache v2 license.

## Copyright & Disclaimer GoogleAuth java library
Please find the Copyright notice in the disclaimer on https://github.com/wstrange/GoogleAuth/ or in the GoogleAuthenticator module.

  [1]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/CreateCredentials.PNG
  [2]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/ValidateUserInput.PNG
  [3]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/Actions.PNG
