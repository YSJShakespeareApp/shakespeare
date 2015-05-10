package ysj.shakespeare;

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
    private String history;
    private String shakespeare;
    private ArrayList<String> images = new ArrayList<String>();


    public Site (int ID,String name, LatLng latlng){
        this.ID = ID;
        this.name = name;
        this.latlng = latlng;
        this.images = new ArrayList<String>();
    }

    public Site(){

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

    public void setName(String name){
        this.name = name;
    }

    public void setLatLng(LatLng latlng){
        this.latlng = latlng;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public void setShakespeare(String shakespeare) {
        this.shakespeare = shakespeare;
    }
    public String getHistory() {
        return history;
    }
    public String getShakespeare() {
        return shakespeare;
    }
    public String getImage(int image){
        return images.get(image);
    }
    public int getSize(){
        return images.size();
    }
    public String toString(){ return this.name; }
    public void addImage(String image){
        images.add(image);
    }


}
