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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.uxTextView) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        String text = getStringFromRaw(this);

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

    @OnClick(R.id.uxLocale)
    public void jazz(View view){
        Intent intent = new Intent(this, LocaleActivity.class);

        startActivity(intent);
    }

    @OnClick(R.id.uxFeatures)
    public void bar(View view){
        Intent intent = new Intent(this, FeatureActivity.class);

        startActivity(intent);
    }

    @OnClick(R.id.uxDrawable)
    public void foo(View view){
        Intent intent = new Intent(this, DrawableActivity.class);

        startActivity(intent);
    }
}
