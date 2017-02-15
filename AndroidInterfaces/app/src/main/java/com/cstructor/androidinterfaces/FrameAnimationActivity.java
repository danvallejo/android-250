package com.cstructor.androidinterfaces;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        ImageView mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
        ((AnimationDrawable) mImageViewFilling.getBackground())
                .start();

        ImageView mImageViewEmptying = (ImageView) findViewById(R.id.imageview_animation_list_emptying);
        ((AnimationDrawable) mImageViewEmptying.getBackground())
                .start();

        final ImageView mImageViewSelector = (ImageView) findViewById(R.id.imageview_animated_selector);
        ((AnimationDrawable) mImageViewFilling.getBackground())
                .start();

        mImageViewSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewSelector.setActivated(!mImageViewSelector.isActivated());
            }
        });
    }
}
