package com.example.doannd.lazadaofme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.doannd.lazadaofme.R;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivity_splash);

        // using handler to delay code execution 3s
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                 startActivity(new Intent(SplashActivity.this, MainActivity.class));
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
