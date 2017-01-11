package com.cstructor.androidinterfaces;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String text = getStringFromRaw(this);

        TextView textView = (TextView)findViewById(R.id.uxTextView);
        textView.setText(text);
    }

    private String getStringFromAssetFile(Activity activity) {
        try {
            AssetManager assetManager = activity.getAssets();

            InputStream inputStream = assetManager.open("files/test.txt");

            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            inputStream.close();

            String text = new String(buffer);

            Log.d("text", text);

            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getStringFromRaw(Activity activity){
        try {
            Resources res = activity.getResources();
            InputStream inputStream = res.openRawResource(R.raw.test);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            String text = new String(buffer);
            Log.d("raw", text);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void onDrawables(View view){
        Intent intent = new Intent(this, DrawableActivity.class);

        startActivity(intent);
    }
}
