package com.example.pankaj.gtmdemo;

import android.app.Application;

import com.example.pankaj.gtmdemo.tagmanager.GoogleTagsManager;

/**
 * Created by pankaj on 8/4/15.
 */
public class GTMDemoApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        GoogleTagsManager.getSingleton().initGoogleTagManager(this,Constants.getSingleton().GTM_CONTAINER_ID,R.raw.gtm_demo);

    }
}
