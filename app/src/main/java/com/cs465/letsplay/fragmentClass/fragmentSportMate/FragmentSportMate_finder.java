package com.cs465.letsplay.fragmentClass.fragmentSportMate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/29/2015.
 */
public class FragmentSportMate_finder  extends Fragment
{

    private WebView webViewMap ;
    private Float latitude = 0f;
    private Float longitude = 0f;
    private Integer zoom = 5;
    private String locationName;


    public FragmentSportMate_finder()
    {
        // Required empty public constructor
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_sport_mate_finder, container, false);

        // LOCATION PICKER WEBVIEW SETUP
        webViewMap = (WebView) v.findViewById(R.id.SMF_webViewMap);
        webViewMap.setScrollContainer(false);
        webViewMap.getSettings().setDomStorageEnabled(true);
        webViewMap.getSettings().setJavaScriptEnabled(true);

        webViewMap.loadUrl("file:///android_asset/locationPickerPage/search.html");

        webViewMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    webViewMap.loadUrl("javascript:activityInitialize(" + latitude + "," + longitude + "," + zoom + ")");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1231,-88.23634,'Piyush','Football,Cricket')");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1431,-88.19634,'Shivam','Football,Cricket')");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1431,-88.22634,'Kevin','Table Tennis')");

                }
            }
        });


        return v;

    }

    public class LocationPickerJSInterface {
        @JavascriptInterface
        public void getValues(String latitude, String longitude, String zoom, String locationName){
            FragmentSportMate_finder.this.latitude = Float.parseFloat(latitude);
            FragmentSportMate_finder.this.longitude = Float.parseFloat(longitude);
            FragmentSportMate_finder.this.zoom = Integer.parseInt(zoom);
            FragmentSportMate_finder.this.locationName = locationName;

        }

    }


}

