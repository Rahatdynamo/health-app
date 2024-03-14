package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SemiCircleProgressBar semiCircleProgressBar = findViewById(R.id.semiCircleProgressBar);


        ObjectAnimator animator = ObjectAnimator.ofFloat(semiCircleProgressBar, "progress", 0, 40);
        animator.setDuration(2000);
        animator.start();
    }
}