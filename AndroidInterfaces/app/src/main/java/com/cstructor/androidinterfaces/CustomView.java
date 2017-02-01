package com.cstructor.androidinterfaces;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;

public class CustomView extends View {
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        //canvas.rotate(-30.0f);
        canvas.scale(4f, 4f);
        //canvas.skew(.1f, .3f);
        canvas.translate(30f,10f);

        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setAntiAlias(true);

        Log.d("antialias", Boolean.toString(paint.isAntiAlias()));

        paint.setColor(Color.RED);
        canvas.drawText("Android", 25, 30, paint);


        paint.setColor(Color.CYAN);
        canvas.drawText("Android", 0,0, paint);

        Path path = new Path();
        path.addArc(new RectF(10,50,90,200), 240, 90);
        canvas.drawTextOnPath("Android", path, 0,0, paint);

        float[] pos = new float[] {
                20,80,
                29,83,
                36,80,
                46,83,
                52,80,
                62,83,
                68,80
        };
        paint.setColor(Color.GREEN);
        canvas.drawPosText("Android", pos, paint);
    }
}

