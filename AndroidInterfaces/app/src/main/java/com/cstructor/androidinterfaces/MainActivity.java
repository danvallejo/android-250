package com.cstructor.androidinterfaces;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

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

        RandomRequest randomRequest = new RandomRequest();
        randomRequest.setJsonRpc("2.0");
        randomRequest.setMethod("generateIntegers");
        randomRequest.setId("123");
        randomRequest.getParams().setApiKey("fdb7ff0d-b1cb-4a30-8743-22575e20be9b");
        randomRequest.getParams().setN(6);
        randomRequest.getParams().setMin(1);
        randomRequest.getParams().setMax(49);
        randomRequest.getParams().setReplacement(true);

        String postRequest = new Gson().toJson(randomRequest);

        new PostDataTask(this, postRequest).execute("https://api.random.org/json-rpc/1/invoke");
    }

    class PostDataTask extends AsyncTask<String, Void, String> {
        private String result;
        private Activity activity;
        private String postRequest;

        public PostDataTask(Activity activity, String postRequest){
            this.activity = activity;
            this.postRequest = postRequest;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(activity, result, Toast.LENGTH_LONG).show();

            RandomResponse response = new Gson().fromJson(result, RandomResponse.class);
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                WebHelper webHelper = new WebHelper(urls[0]);

                result = webHelper.PostQuery(new HashMap<String, String>(), "",
                        postRequest, "application/json");

                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
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

    @OnClick(R.id.uxContact)
    public void contact(View view){
        Intent intent = new Intent(this, ContactActivity.class);

        startActivity(intent);
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
