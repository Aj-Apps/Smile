package com.ajapps.climatecars.smile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Logo extends Activity {

    ImageButton logo;
    Button camera;
    Animation animationSlideInLeft, animationSlideInRight, animationSlideInUp;
    ImageView curSlidingImageButton;
    ImageButton curSlidingButton;
    TextView curSlidingText;
    TextView clim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_logo);

        logo = (ImageButton) findViewById(R.id.imageButton);


        animationSlideInLeft = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);
        animationSlideInUp = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom);

        animationSlideInLeft.setDuration(1000);
        animationSlideInUp.setDuration(1500);

        animationSlideInLeft.setAnimationListener(animationSlideInLeftListener);


        curSlidingButton = logo;
        logo.startAnimation(animationSlideInLeft);
        logo.setVisibility(View.VISIBLE);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        a.setFillAfter(true);
        a.reset();


        Thread loading = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent main = new Intent(Logo.this, Main.class);
                    startActivity(main);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
                Logo.this.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

            }
        };

        loading.start();
    }

    @Override
    public void onBackPressed() {
        Logo.this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        logo.clearAnimation();

    }
    Animation.AnimationListener animationSlideInLeftListener;
}
