package com.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.notes.R;

public class SplashScreen extends AppCompatActivity {

    private Handler splashScreenHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationView();
        getSupportActionBar().hide();
        runHandler();
    }

    private void initializationView(){
        setContentView(R.layout.activity_splash_screen);
    }

    private void runHandler(){
        splashScreenHandler = new Handler();
        splashScreenHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);
    }
}