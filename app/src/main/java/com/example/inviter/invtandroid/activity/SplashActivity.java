package com.example.inviter.invtandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inviter.invtandroid.R;
import com.example.inviter.invtandroid.config.AppConfig;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final int splashDisplayLength = 2000;
        final SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        final boolean isAppFirstTime = sharedPreferences.getBoolean(AppConfig.SHARED_PREFERENCE_KEY_IS_APP_FIRST_TIME, true);
        final boolean isLogin = sharedPreferences.getBoolean(AppConfig.SHARED_PREFERENCE_KEY_IS_LOGIN, false);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (isLogin){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    finish();
                    SplashActivity.this.startActivity(intent);
                }
                else if (isAppFirstTime){
                    sharedPreferences
                            .edit()
                            .putBoolean(AppConfig.SHARED_PREFERENCE_KEY_IS_APP_FIRST_TIME, false)
                            .apply();
                    finish();
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
                }
                else{
                    finish();
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
                }
                overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
            }
        }, splashDisplayLength);
    }
}
