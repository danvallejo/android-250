package com.cstructor.androidinterfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        ImageView spaceshipImage = (ImageView) findViewById(R.id.spaceshipImage);
        spaceshipImage.setVisibility(View.VISIBLE);


        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);

        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
    }
}

