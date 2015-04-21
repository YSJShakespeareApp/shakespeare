package com.example.michaelcarr.shakespeareapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by michael.carr on 13/03/15.
 */
public class SiteInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteinformation);

        ArrayList images = new ArrayList<ImageView>();
        images.add(findViewById(R.id.imageShakespeare));
        images.add(findViewById(R.id.imageHistory));

        Site selected = Sites.get(SiteInformation.this).getAllSites().get(getIntent().getIntExtra("index",0));



        TextView name = (TextView)findViewById(R.id.title);
        name.setText(selected.getName());

        TextView history = (TextView)findViewById(R.id.history);
        history.setText(selected.getHistory());

        TextView shakespeare = (TextView)findViewById(R.id.shakespeare);
        shakespeare.setText(selected.getShakespeare());


        for (int i = 0; i < selected.getSize(); i++) {
            int imageID = getResources().getIdentifier(selected.getImage(i), "drawable", getPackageName());
            ((ImageView) images.get(i)).setImageDrawable(getResources().getDrawable(imageID));
        }
    }



}
