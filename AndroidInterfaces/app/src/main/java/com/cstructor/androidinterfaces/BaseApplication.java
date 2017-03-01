package com.cstructor.androidinterfaces;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class BaseApplication extends Application
{
    protected static Context context;
    protected static PackageInfo packageInfo;
    protected static BaseApplication baseApplication;

    @Override
    public void onCreate()
    {
        try
        {

            baseApplication = this;

            context = getApplicationContext();

            PackageManager manager = context.getPackageManager();
            String packageName = context.getPackageName();

            packageInfo = manager.getPackageInfo(packageName, 0);

            Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        }
        catch (Exception e)
        {
            // ignore
        }
    }

    public static Context getContext()
    {
        return context;
    }

    public static PackageInfo getPackageInfo()
    {
        return packageInfo;
    }

    public static BaseApplication getApplication(){
        return baseApplication;
    }
}

