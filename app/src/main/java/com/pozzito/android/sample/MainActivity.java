package com.pozzito.android.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pozzito.android.sdk.PozzitoSdk;
import com.pozzito.android.sdk.UserParams;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";

    private static final String EMAIL = "mail@maildomain.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startSupport = (Button) findViewById(R.id.btn_start_support);
        startSupport.setOnClickListener(this);


        // Add information about your user
        UserParams userParams = new UserParams.Builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();

        // Create user
        PozzitoSdk.getInstance().createUser(userParams);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_support:
                PozzitoSdk.getInstance().startSupport(MainActivity.this);

                break;
        }
    }
}