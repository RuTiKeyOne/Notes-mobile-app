package com.simplenote.ershov.Activity;

import android.content.Intent;
import android.os.*;
import androidx.appcompat.app.AppCompatActivity;
import com.simplenote.ershov.R;

public class SplashScreen extends AppCompatActivity {

    private Handler splashScreenHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializationView();
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