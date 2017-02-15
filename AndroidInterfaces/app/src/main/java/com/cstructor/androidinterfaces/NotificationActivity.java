package com.cstructor.androidinterfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ButterKnife.bind(this);

        Intent contactIntent = new Intent(this, ContactActivity.class);
        Intent drawablesIntent = new Intent(this, DrawableActivity.class);

        PendingIntent contactPendingIntent = PendingIntent.getActivity(this, 0, contactIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent drawablesPendingIntent = PendingIntent.getActivity(this, 0, drawablesIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Action firstAction = new Notification.Action.Builder(R.drawable.ic_menu_gallery, "Contact", contactPendingIntent).build();
        Notification.Action secondAction = new Notification.Action.Builder(R.drawable.ic_menu_manage, "Drawables", drawablesPendingIntent).build();

        Notification notification = new Notification.Builder(this)
                .setContentTitle("Missed Call")
                .setContentText("Dave Barry")
                //.setLargeIcon(bitmap)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setPriority(Notification.PRIORITY_HIGH)
                //.setContentIntent(callLogIntent)
                //.addAction(firstAction)
                //.addAction(secondAction)
                .setStyle(new Notification.BigTextStyle().bigText("This is the text\nAnd another line")) // optional
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    @OnClick(R.id.uxClearNotification)
    public void onClearNotifications(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }

    int messages;

    @OnClick(R.id.uxUpdateNotifiation)
    public void onUpdateNotifications(View view) {
        Notification notification = new Notification.Builder(this)
                .setStyle(new Notification.BigTextStyle().bigText("This is the text\nAnd another line")) // optional
                .setNumber(++messages)
                .setSmallIcon(R.drawable.ic_android)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}

