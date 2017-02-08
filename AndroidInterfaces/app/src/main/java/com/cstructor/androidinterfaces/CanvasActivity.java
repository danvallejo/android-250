package com.cstructor.androidinterfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;

public class CanvasActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener{
    private GestureDetectorCompat mDetector;
    private CustomView customView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // context, listener
        mDetector = new GestureDetectorCompat(this,this);
        customView = (CustomView) findViewById(R.id.uxView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        // You need to call the detector!
        mDetector.onTouchEvent(event);

        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("CanvasActivity", "onDown:" + e.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("CanvasActivity", "onShowPress:" + e.toString());

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("CanvasActivity", "onSingleTapUp:" + e.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d("CanvasActivity", "onScroll: e1:" + e1.toString());
        Log.d("CanvasActivity", "onScroll: e2:" + e2.toString());
        Log.d("CanvasActivity", "onScroll: distanceX:" + distanceX);
        Log.d("CanvasActivity", "onScroll: distanceY:" + distanceY);

        customView
                .animate()
                .x(customView.getX() - distanceX) // ???
                .y(customView.getY() - distanceY) // ???
                .setDuration(0)
                .start();

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("CanvasActivity", "onLongPress:" + e.toString());

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("CanvasActivity", "onFling: e1:" + e1.toString());
        Log.d("CanvasActivity", "onFling: e2:" + e2.toString());
        Log.d("CanvasActivity", "onFling: velocityX:" + velocityX);
        Log.d("CanvasActivity", "onFling: velocityY:" + velocityY);
        return false;
    }
}

