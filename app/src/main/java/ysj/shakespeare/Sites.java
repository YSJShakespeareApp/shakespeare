package ysj.shakespeare;

/**
 * Created by michael.carr on 12/03/15.
 */

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Sites {

    public Sites(Context context) {
        list = new ArrayList<Site>();
        markers = new LinkedHashMap<Marker, Site>();

        /* XXX: load this in from XML/whatever */


        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = context.getAssets().open("sites.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
        {
            list = null;
            int eventType = parser.getEventType();
            Site currentSite = null;
            double templat = 0;
            double templng = 0;
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tag = null;
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList();
                        break;
                    case XmlPullParser.START_TAG:
                        tag = parser.getName();
                        if (tag.equals("site")){
                            currentSite = new Site();
                        } else if (currentSite != null){
                            if (tag.equals("name")){
                                currentSite.setName(parser.nextText());
                            } else if (tag.equals("lat")) {
                                templat = Double.valueOf(parser.nextText());
                            } else if (tag.equals("lng")) {
                                templng = Double.valueOf(parser.nextText());
                                currentSite.setLatLng(new LatLng(templat,templng));
                            } else if (tag.equals("history")){
                                currentSite.setHistory(parser.nextText());
                            } else if (tag.equals("historyImage")){
                                currentSite.addImage(parser.nextText());
                            }
                            else if (tag.equals("shakespeare")) {
                                currentSite.setShakespeare(parser.nextText());
                            }
                            else if (tag.equals("shakespeareImage")){
                                currentSite.addImage(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tag = parser.getName();
                        if (tag.equalsIgnoreCase("site") && currentSite != null){
                            list.add(currentSite);
                        }
                }
                eventType = parser.next();
            }

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
