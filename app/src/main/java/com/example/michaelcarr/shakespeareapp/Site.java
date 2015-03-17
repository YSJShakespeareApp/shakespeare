package com.example.michaelcarr.shakespeareapp;

import android.media.Image;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by michael.carr on 12/03/15.
 */
public class Site implements Serializable {
    private int ID;
    private String name;
    private LatLng latlng;
    private ArrayList<String> text;
    private ArrayList<ImageView> images;


    public Site (int ID,String name, LatLng latlng){
        this.ID = ID;
        this.name = name;
        this.latlng = latlng;
        this.text = new ArrayList<String>();
        this.images = new ArrayList<ImageView>();
    }

    public void addInfo(String info){
        this.text.add(info);
    }

    public void addImage(ImageView image){
        this.images.add(image);
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public LatLng getLatLng(){
        return this.latlng;
    }

    public ArrayList<String> getAllInfo(){
        return this.text;
    }

    public ArrayList<ImageView> getAllImages(){
        return this.images;
    }

    public String getInfo(int pos){
        return this.text.get(pos);
    }

    public ImageView getImage(int pos){
        return this.images.get(pos);
    }
}
