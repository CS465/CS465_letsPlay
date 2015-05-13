package com.cs465.letsplay.fragmentClass.fragmentMyEvent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
public class FragmentMyEvent_new_3 extends Fragment
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


    public FragmentMyEvent_new_3()
    {
        // Required empty public constructor
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event_new_3_location, container, false);

        btnNext = (Button)v.findViewById(R.id.EN3_btnSelect);
        fManager = getActivity().getSupportFragmentManager();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_new_4 fragNew_4 = new FragmentMyEvent_new_4();
                fTransaction.replace(R.id.mainContent,fragNew_4);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location_picker);

        if (savedInstanceState!=null) {
            latitude = savedInstanceState.getFloat("latitude");
            longitude = savedInstanceState.getFloat("longitude");
            zoom = savedInstanceState.getInt("zoom");
            locationName = savedInstanceState.getString("locationName");
        }

        // LOCATION PICKER WEBVIEW SETUP
        webViewMap = (WebView) v.findViewById(R.id.EN3_webViewMap);
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
        editLocation = (EditText) v.findViewById(R.id.EN3_editLocation);
        btnSearch = (Button) v.findViewById(R.id.EN3_btnSearch);
        btnSearch.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                webViewMap.loadUrl("javascript:if (typeof activityPerformSearch == 'function') {activityPerformSearch(\"" + editLocation.getText().toString() + "\")}");
            }
        });



        return v;
    }

    public class LocationPickerJSInterface {
        @JavascriptInterface
        public void getValues(String latitude, String longitude, String zoom, String locationName){
            FragmentMyEvent_new_3.this.latitude = Float.parseFloat(latitude);
            FragmentMyEvent_new_3.this.longitude = Float.parseFloat(longitude);
            FragmentMyEvent_new_3.this.zoom = Integer.parseInt(zoom);
            FragmentMyEvent_new_3.this.locationName = locationName;

            getActivity().runOnUiThread(new Runnable() {

                public void run() {
                    //Code that interact with UI
                    FragmentMyEvent_new_3.this.editLocation.setText(FragmentMyEvent_new_3.this.locationName);

                }
            });

        }

    }


}