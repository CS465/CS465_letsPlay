package com.cs465.letsplay.fragmentClass.fragmentFindEvent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentFindEvent_map extends Fragment
{
    private Button btnNext;
    private FragmentManager fManager;

    private EditText editLocation;
    private Button btnSearch;

    private WebView webViewMap ;


    private Float latitude = 0f;
    private Float longitude = 0f;
    private Integer zoom = 5;
    private String locationName;

    public FragmentFindEvent_map()
    {
        // Required empty public constructor
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_find_events_map, container, false);

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location_picker);

        if (savedInstanceState!=null) {
            latitude = savedInstanceState.getFloat("latitude");
            longitude = savedInstanceState.getFloat("longitude");
            zoom = savedInstanceState.getInt("zoom");
            locationName = savedInstanceState.getString("locationName");
        }

        // LOCATION PICKER WEBVIEW SETUP
        webViewMap = (WebView) v.findViewById(R.id.FEM_webViewMap);
        webViewMap.setScrollContainer(false);
        webViewMap.getSettings().setDomStorageEnabled(true);
        webViewMap.getSettings().setJavaScriptEnabled(true);
        webViewMap.addJavascriptInterface(new LocationPickerJSInterface(), "AndroidFunction");

        webViewMap.loadUrl("file:///android_asset/locationPickerPage/event.html");

        webViewMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    webViewMap.loadUrl("javascript:activityInitialize(" + latitude + "," + longitude + "," + zoom + ")");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1231,-88.23634,'UI Ice Arena','406 East Armory Ave, Champaign, IL')");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1431,-88.19634,'CRCE','201 E Peabody Dr, Champaign. IL')");
                    webViewMap.loadUrl("javascript:activityAddMarker(40.1431,-88.22634,'The Rec Room Illini Union','1401 W Green St, Champaign, IL')");

                }
            }
        });

        // EVENT HANDLER FOR PERFORMING SEARCH IN WEBVIEW


        return v;
    }

    public class LocationPickerJSInterface {
        @JavascriptInterface
        public void getValues(String latitude, String longitude, String zoom, String locationName){
            FragmentFindEvent_map.this.latitude = Float.parseFloat(latitude);
            FragmentFindEvent_map.this.longitude = Float.parseFloat(longitude);
            FragmentFindEvent_map.this.zoom = Integer.parseInt(zoom);
            FragmentFindEvent_map.this.locationName = locationName;


        }

    }

}