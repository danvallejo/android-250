package com.cstructor.androidinterfaces;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        final ImageView spaceshipImage = (ImageView) findViewById(R.id.spaceshipImage);
        spaceshipImage.setVisibility(View.VISIBLE);


        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);

        //spaceshipImage.startAnimation(hyperspaceJumpAnimation);


        ValueAnimator animation = ValueAnimator.ofInt(0, 1000);
        animation.setDuration(1000);
        animation.setInterpolator(new BounceInterpolator());

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                spaceshipImage.setY(((int)animation.getAnimatedValue()) / 2);
                Log.d("onAnimationUpdate", animation.getAnimatedValue().toString());
            }
        });

        Log.d("onCreate", "start");
        animation.start();
    }
}

