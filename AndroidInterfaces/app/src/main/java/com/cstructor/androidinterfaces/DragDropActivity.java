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
    @Bind(R.id.imageViewTo2) public ImageView imageViewTo2;

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
                View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);

                // Start dragging
                v.startDrag(dragData, dragShadow, null, 0);

                // Hide the view that is being dragged from
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        imageViewTo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("DragDropActivity", "onLongClick");

                ClipData dragData = ClipData.newPlainText("icon", "ic_android");

                // Create a drag shadow
                View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);

                // Start dragging
                v.startDrag(dragData, dragShadow, null, 0);

                // Hide the view that is being dragged from
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        imageViewTo2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("DragDropActivity", "onLongClick");

                ClipData dragData = ClipData.newPlainText("icon", "ic_android");

                // Create a drag shadow
                View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);

                // Start dragging
                v.startDrag(dragData, dragShadow, null, 0);

                // Hide the view that is being dragged from
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        TouchDragEventListener touchDragEventListener = new TouchDragEventListener();

        imageViewTo.setOnDragListener(touchDragEventListener);
        imageViewTo2.setOnDragListener(touchDragEventListener);
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

                    ImageView imageView = (ImageView)v;

                    // Set the android icon on the destination ImageView
                    imageView.setImageResource(R.drawable.ic_android);

                    // Force ImageView to redraw
                    imageView.invalidate();

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
