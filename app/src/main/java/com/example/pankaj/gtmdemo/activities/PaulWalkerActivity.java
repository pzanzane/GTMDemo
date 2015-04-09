package com.example.pankaj.gtmdemo.activities;

import android.os.Bundle;

import com.example.pankaj.gtmdemo.R;

/**
 * Created by pankaj on 8/4/15.
 */
public class PaulWalkerActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paulwalker);
        eventPush(getComponentName());
    }
}
