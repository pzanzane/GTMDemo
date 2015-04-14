package com.example.pankaj.gtmdemo.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pankaj on 14/4/15.
 */
public class InstallReferral extends BroadcastReceiver {

    private static final String REFERRER = "referrer";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.hasExtra(REFERRER))
        {
            Log.d("WASTE","REFERRER::"+intent.getExtras().getString(REFERRER));
            com.google.android.gms.tagmanager.InstallReferrerReceiver tagManagerInstallReferrer
                    = new com.google.android.gms.tagmanager.InstallReferrerReceiver();
            tagManagerInstallReferrer.onReceive(context,intent);

        }

    }
}
