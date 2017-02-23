##PozzitoSDK for Android##


Pozzito SDK Android allows quick integration of Pozzito customer support in your app. For more information visit [Pozzito website](https://pozzito.com/)

### Sample app ###
This app shows how to use Pozzito SDK. For more detailed explanation, please read Usage section.

### Installation ###
Pozzito SDK requires device with minimum Android API version 16.

Add Pozzito repository in your current repositories in project's root build.gradle:

    allprojects {
    	repositories {
			...
    		maven { url "https://s3-eu-west-1.amazonaws.com/pozzito-maven/release/" }
			...
    }

Add dependency in your applications build.gradle:


    dependencies {
    	compile 'com.pozzito.android:pozzito-sdk:1.0.0'
	    compile 'com.pozzito.android:pozzito-sdk-api:1.0.0'
    }

### Permission ###
Add this permission to your Manifest:

    <uses-permission android:name="android.permission.INTERNET" />

### Usage ###
To start using Pozzito SDK in your application, initialize Pozzito SDK in your onCreate() method in your Application class.

    @Override
    public void onCreate() {
        super.onCreate();
        PozzitoSdk.init(this, "your api key", "your app id", enableLog);
        //...
    }

First parameter is application context. Next two parameters are API KEY and APP ID parameters. Last parameter is boolean which enables or disables logging.

When the information about your user becomes available to you (for example when your user logs in into your app), you can provide those informations with following method:

    UserParams userParams = new UserParams.Builder()
    	.firstName("First Name")
    	.lastName("Last Name")
    	.email("mail@maildomain.com")
		.build();

    PozzitoSdk.getInstance().createUser(userParams);

If you don't know any information about your user (for example, if your app do not require login), you can create anonymous user:

    PozzitoSdk.getInstance().createAnonymousUser();

If you want to clear information about user, call:

    PozzitoSdk.getInstance().clearUser();
After clearing user you can create a new user once again.

And finally, to start Pozzito support, call:

    PozzitoSdk.getInstance().startSupport();

Note:

If you do not provide any user information prior to starting support, Pozzito will automatically require user information by showing registration form, or it will create anonymous user, depending on your settings.