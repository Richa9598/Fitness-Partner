package com.richa.fitness_partner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.richa.fitness_partner.R;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SpalshScreenActivity extends AppCompatActivity {
    GifImageView gif;
    GifDrawable gifviwer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        gif = findViewById(R.id.gif);
        gifviwer = (GifDrawable) gif.getDrawable();
        gifviwer.setLoopCount(1);
        gifviwer.start();

        gifviwer.addAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationCompleted(int loopNumber) {

                Intent intent = new Intent(SpalshScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}