package com.cstructor.androidinterfaces;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CrossfadeActivity extends AppCompatActivity {
    private static final String CLASSNAME = CrossfadeActivity.class.getSimpleName();

    private View uxTextView;
    private View uxProgressBar;
    private int animationDuration;
    private boolean contentLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade);

        uxTextView = findViewById(R.id.uxTextView);
        uxProgressBar = findViewById(R.id.uxProgressBar);

        // Initially hide the content view.
        uxTextView.setVisibility(View.GONE);

        // Retrieve and cache the system's animation time.
        animationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
        animationDuration = 2000;
        Log.d(CLASSNAME, "mAnimationDuration:" + animationDuration);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                contentLoaded = !contentLoaded;
                Log.d(CLASSNAME, "mContentLoaded:" +contentLoaded);
                showContentOrLoadingIndicator(contentLoaded);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void showContentOrLoadingIndicator(boolean contentLoaded) {
        // Decide which view to hide and which to show.
        final View showView = contentLoaded ? uxTextView : uxProgressBar;
        final View hideView = contentLoaded ? uxProgressBar : uxTextView;

        // Set the "show" view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        showView.setAlpha(0f);
        showView.setVisibility(View.VISIBLE);

        // Animate the "show" view to 100% opacity, and clear any animation listener set on
        // the view. Remember that listeners are not limited to the specific animation
        // describes in the chained method calls. Listeners are set on the
        // ViewPropertyAnimator object for the view, which persists across several
        // animations.
        showView.animate()
                .alpha(1f)
                .setDuration(animationDuration)
                .setListener(null);

        // Animate the "hide" view to 0% opacity. After the animation ends, set its visibility
        // to GONE as an optimization step (it won't participate in layout passes, etc.)
        hideView.animate()
                .alpha(0f)
                .setDuration(animationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        hideView.setVisibility(View.GONE);
                    }
                });
    }
}

