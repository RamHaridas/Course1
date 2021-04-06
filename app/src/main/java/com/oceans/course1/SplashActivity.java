package com.oceans.course1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private boolean isLogin;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean("isLogin",false);
        email = sharedPreferences.getString("email","");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isLogin){
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class); // path
                    startActivity(intent);
                }
            }
        },3000);
    }
}