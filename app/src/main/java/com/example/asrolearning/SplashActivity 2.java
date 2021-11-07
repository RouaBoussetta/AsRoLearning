package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;
    Animation topAnim,bottomAnim;
    ImageView img1,img2;
    TextView slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        MediaPlayer mp=MediaPlayer.create(getApplicationContext(),R.raw.sound);
        mp.start();

        img1=findViewById(R.id.part1);
        img2=findViewById(R.id.part2);
        slogan=findViewById(R.id.slogan);

        img1.setAnimation(bottomAnim);
        img2.setAnimation(topAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,UserRegister.class);
                startActivity(intent);
                mp.stop();
                finish();
            }
        },SPLASH_SCREEN);
    }
}