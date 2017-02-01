package com.cstructor.android250b;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("content");
        uriBuilder.authority("com.cstructor.androidinterfaces.provider.Planet");
        uriBuilder.appendPath("planet");
        //uriBuilder.appendPath("3");

        Uri uri = uriBuilder.build();

        Log.d(MainActivity.class.toString(), uri.toString());

        String type = getContentResolver().getType(uri);

        Log.d(MainActivity.class.toString(), type);
        try {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            for (boolean hasItem = cursor.moveToFirst(); hasItem; hasItem= cursor.moveToNext()){
                Log.d("Data", cursor.getString(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String[] params = {"arg1", "arg2"};
            int deletedRows = getContentResolver().delete(uri, "where p1=? and p2=?", params);
            Log.d(MainActivity.class.toString(), "Deleted rows=" + deletedRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





















