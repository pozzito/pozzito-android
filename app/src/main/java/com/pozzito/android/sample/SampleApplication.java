package com.pozzito.android.sample;

import android.app.Application;

import com.pozzito.android.sdk.PozzitoSdk;

/**
 * Created by fmatijevic on 20.2.2017..
 */

public class SampleApplication extends Application {
    private static final String POZZITO_API_KEY = "your_api_key";
    private static final String POZZITO_APP_ID = "your_app_id";


    private static final boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        PozzitoSdk.init(this, POZZITO_API_KEY, POZZITO_APP_ID, isDebug);
    }
}
