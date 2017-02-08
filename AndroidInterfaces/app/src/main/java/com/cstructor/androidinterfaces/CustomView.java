package com.cstructor.androidinterfaces;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.content.res.TypedArray;

public class CustomView extends View {
    private boolean showText;
    private int textPos;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomView,
                0, 0);

        try {
            showText = a.getBoolean(R.styleable.CustomView_showText, false);
            textPos = a.getInteger(R.styleable.CustomView_labelPosition, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        Log.d("ontouch", String.format("x=%f y=%f", event.getX(), event.getY()));

        if (action == MotionEvent.ACTION_DOWN) {
            return true;
        }
        if (action == MotionEvent.ACTION_MOVE) {
            width = (int) event.getX();
            height = (int) event.getY();
            invalidate();
        }

        return super.onTouchEvent(event);
    }

    private int height = 50;
    private int width = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xffff0000);

        canvas.drawOval(0, 0, width, height, paint);

        if (showText) {
            String text = "Android 250";

            paint.setColor(0xff000000);
            paint.setAntiAlias(true);
            paint.setTextSize(30);

            int canvasWidth = canvas.getWidth();

            float textWidth = paint.measureText(text);

            float xPos = 0;

            if (textPos == 0) {
                xPos = 0;
            } else if (textPos == 1) {
                xPos = (canvasWidth - textWidth) / 2;
            } else if (textPos == 2) {
                xPos = (int) (canvasWidth - textWidth);
            }

            canvas.drawText(text, xPos, 100, paint);
        }
    }
}

