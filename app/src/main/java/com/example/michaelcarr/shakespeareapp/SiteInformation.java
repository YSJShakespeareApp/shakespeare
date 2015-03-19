package com.example.michaelcarr.shakespeareapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by michael.carr on 13/03/15.
 */
public class SiteInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteinformation);

        TextView name = (TextView)findViewById(R.id.title);
        name.setText(getIntent().getStringExtra("name"));

        TextView info = (TextView)findViewById(R.id.info);
        info.setText(getIntent().getStringExtra("history"));
        info.append(getIntent().getStringExtra("shakespeare"));


    }



}
