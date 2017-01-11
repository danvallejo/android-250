package com.cstructor.androidinterfaces;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class FeatureActivity extends AppCompatActivity {
    private TextView mTextView;
    private boolean hasCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        mTextView = (TextView) findViewById(R.id.textView);

        StringBuilder sb = new StringBuilder();

        // 1. Get the Device Information
        sb.append("Manufacturer: " + Build.MANUFACTURER);
        sb.append("\nModel: " + Build.MODEL);
        sb.append("\nAPI Level: " + Build.VERSION.SDK_INT);

        // 2. Check to see if we are running in an emulator
        boolean isEmulator = false;
        if(Build.PRODUCT.equalsIgnoreCase("google_sdk")||
                Build.MODEL.contains("Emulator") ||
                Build.MODEL.contains("Android SDK"))  {
            isEmulator = true;
        }
        sb.append("\nIs in emulator: " + isEmulator);

        // 3. Get the Language
        Locale defaultLocale = Locale.getDefault();
        sb.append("\nLocale: " + defaultLocale.getDisplayLanguage());

        // 4. Determine if Facebook is installed
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            sb.append("\nFacebook is installed");
        } catch (PackageManager.NameNotFoundException e) {
            sb.append("\nFacebook is not installed");
        }

        // 5. Check to see if we have a camera hardware
        PackageManager packageManager = getPackageManager();
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            sb.append("\nDevice has camera");
            hasCamera = true;
        } else {
            sb.append("\nDevice has no camera");
            hasCamera = false;
        }

        // Display information in TextView
        mTextView.setText(sb.toString());
    }
}

