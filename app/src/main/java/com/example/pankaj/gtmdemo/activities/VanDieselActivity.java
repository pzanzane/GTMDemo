package com.example.pankaj.gtmdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pankaj.gtmdemo.R;

//am broadcast -a com.android.vending.INSTALL_REFERRER --es "referrer" "utm_source%3Dmaza_source%26utm_medium%3Dmaza_medium%26utm_term%3Dmaza_term%26utm_content%3Dmaza_content%26utm_campaign%3DTest"

public class VanDieselActivity extends BaseActivity implements View.OnClickListener{


    private Button mBtn = null;

    private void initView(){
        mBtn = (Button)findViewById(R.id.button);
        mBtn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        eventPush(getComponentName());

    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

            Intent intent = new Intent(this,PaulWalkerActivity.class);
            startActivity(intent);

    }
}
