package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

              SharedPreferences sharedPreferences = getSharedPreferences(SignInActivity.PREFS,MODE_PRIVATE);
                Boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
                Boolean hasLoggedOut = sharedPreferences.getBoolean("hasLoggedOut",false);


                if(hasLoggedIn){
                    Intent intent = new Intent(Splash_Screen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (hasLoggedOut){
                    Intent intent = new Intent(Splash_Screen.this,SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(Splash_Screen.this,SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000
        );
    }
}