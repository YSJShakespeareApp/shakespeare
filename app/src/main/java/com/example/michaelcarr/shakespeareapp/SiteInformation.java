package com.example.michaelcarr.shakespeareapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
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

        TextView history = (TextView)findViewById(R.id.history);
        history.setText(getIntent().getStringExtra("history"));
        TextView shakespeare = (TextView)findViewById(R.id.shakespeare);
        shakespeare.setText(getIntent().getStringExtra("shakespeare"));

        ImageView imageHistory = (ImageView)findViewById(R.id.imageHistory);
        imageHistory.setImageDrawable(getResources().getDrawable(R.drawable.richardhistory));


        ImageView imageShakespeare = (ImageView)findViewById(R.id.imageShakespeare);
        imageShakespeare.setImageDrawable(getResources().getDrawable(R.drawable.richardshakespeare));
    }



}
