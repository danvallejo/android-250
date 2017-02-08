package com.cstructor.androidinterfaces;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DragDropActivity extends AppCompatActivity {
    @Bind(R.id.imageViewFrom) public ImageView imageViewFrom;
    @Bind(R.id.imageViewTo) public ImageView imageViewTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);

        ButterKnife.bind(this);

        imageViewFrom.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("DragDropActivity", "onLongClick");

                ClipData dragData = ClipData.newPlainText("icon", "ic_android");

                // Create a drag shadow
                View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(imageViewFrom);

                // Start dragging
                v.startDrag(dragData, dragShadow, null, 0);

                // Hide the view that is being dragged from
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        imageViewTo.setOnDragListener(new TouchDragEventListener());
    }

    protected class TouchDragEventListener implements View.OnDragListener {
        boolean dropped = false;

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("onDrag", "ACTION_DRAG_STARTED");
                    return true;
                case DragEvent.ACTION_DRAG_LOCATION:
                    Log.d("onDrag", "ACTION_DRAG_LOCATION");
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d("onDrag", "ACTION_DROP");
                    // Set the android icon on the destination ImageView
                    imageViewTo.setImageResource(R.drawable.ic_android);

                    // Force ImageView to redraw
                    imageViewTo.invalidate();

                    dropped = true;
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("onDrag", "ACTION_DRAG_ENDED");
                    if (!dropped) {
                        imageViewFrom.setVisibility(View.VISIBLE);
                    }
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("onDrag", "ACTION_DRAG_ENTERED");
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("onDrag", "ACTION_DRAG_EXITED");
                    return true;
                default:
                    return true;
            }
        }
    }
}
