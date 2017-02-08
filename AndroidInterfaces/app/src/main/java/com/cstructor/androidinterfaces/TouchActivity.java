package com.cstructor.androidinterfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class TouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("ontouch", String.format("x=%f y=%f", event.getX(), event.getY()));

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d("ontouch", "down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d("ontouch", "move");
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("ontouch", "up");
                return true;
        }
        return super.onTouchEvent(event);
    }
}
