package com.example.pankaj.gtmdemo.activities;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.pankaj.gtmdemo.Constants;
import com.example.pankaj.gtmdemo.tagmanager.GoogleTagsManager;

/**
 * Created by pankaj on 8/4/15.
 */
public class BaseActivity extends ActionBarActivity {

    protected GoogleTagsManager mGoogleTagsManager = null;
    protected Constants mConstants = null;

    private void init(){
        mGoogleTagsManager = GoogleTagsManager.getSingleton();
        mConstants = Constants.getSingleton();
    }

    protected void eventPush(ComponentName componentName){
        PackageManager packageManager = getPackageManager();
        try {
           ActivityInfo info = packageManager.getActivityInfo(componentName, 0);

            mGoogleTagsManager.pushEvent(this, "openScreen", "screenName", info.name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
}
