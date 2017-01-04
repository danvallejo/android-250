package com.cstructor.androidinterfaces;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
    }

    public void onTransition(View view){
        ImageView image = (ImageView) findViewById(R.id.transitionView);

        TransitionDrawable drawable = (TransitionDrawable) image.getDrawable();

        drawable.startTransition(1500);
    }

    public void onRevealClip(View view){
        ImageView image = (ImageView) findViewById(R.id.clipDrawableView);

        ClipDrawable drawable = (ClipDrawable) image.getDrawable();

        int level = drawable.getLevel();

        if (level >= 10000)
        {
            level = 0;
        }

        drawable.setLevel(level + 1000);
    }
}
