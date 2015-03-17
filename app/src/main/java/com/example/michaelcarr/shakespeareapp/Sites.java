package com.example.michaelcarr.shakespeareapp;

/**
 * Created by michael.carr on 12/03/15.
 */

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;


public class Sites {

    public Sites(Context context) {
        list = new ArrayList<Site>();
        markers = new LinkedHashMap<Marker, Site>();

        /* XXX: load this in from XML/whatever */
        Site s = new Site(1, "Monk Bar - Richard III", new LatLng(53.96234, -1.07935));
        s.addInfo(context.getApplicationContext().getResources().getStringArray(R.array.site_information)[0]);
        s.addInfo(context.getApplicationContext().getResources().getStringArray(R.array.site_information)[1]);
        //s.addImage();
        list.add(s);
    }

    void setMarkerForSite(Marker m, Site s) {
        markers.put(m, s);
    }

    ArrayList<Site> getAllSites() {
        return list;
    }

    Site getSite(Marker marker) {
        return markers.get(marker);
    }

    private ArrayList<Site> list;
    private LinkedHashMap<Marker, Site> markers;

    public static Sites get(Context context) {
        if (sites == null) {
            sites = new Sites(context);
        }
        return sites;
    }

    private static Sites sites;
}
