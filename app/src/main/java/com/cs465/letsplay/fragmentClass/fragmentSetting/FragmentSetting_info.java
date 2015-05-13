package com.cs465.letsplay.fragmentClass.fragmentSetting;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cs465.letsplay.R;
import com.cs465.letsplay.fragmentClass.fragmentProfile.FragmentProfile;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentSetting_info extends Fragment
{

    private EditText editName;
    private EditText editAge;
    private EditText editLocation;
    private Spinner spinnerGender;
    private Button btnSave;
    private Button btnSearch;
    private FragmentManager fManager;

    private WebView webViewMap ;


    private Float latitude = 0f;
    private Float longitude = 0f;
    private Integer zoom = 5;
    private String locationName;

    public FragmentSetting_info()
    {
        // Required empty public constructor
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting_personal_info, container, false);
        editName = (EditText)v.findViewById(R.id.SPI_editName);
        editAge = (EditText)v.findViewById(R.id.SPI_editAge);
        spinnerGender = (Spinner)v.findViewById(R.id.SPI_spinnerGender);
        btnSave = (Button)v.findViewById(R.id.SPI_btnSave);
        fManager = getActivity().getSupportFragmentManager();
        //webViewMap = (WebView)v.findViewById(R.id.SPI_webViewMap);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(validateRule())
                {
                    FragmentTransaction fTransaction = fManager.beginTransaction();
                    FragmentSetting fragmentSetting = new FragmentSetting();
                    fTransaction.replace(R.id.mainContent, fragmentSetting);
                    fTransaction.addToBackStack(null);
                    fTransaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please check your input.", Toast.LENGTH_SHORT).show();
                }
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
        webViewMap = (WebView) v.findViewById(R.id.SPI_webViewMap);
        webViewMap.setScrollContainer(false);
        webViewMap.getSettings().setDomStorageEnabled(true);
        webViewMap.getSettings().setJavaScriptEnabled(true);
        webViewMap.addJavascriptInterface(new LocationPickerJSInterface(), "AndroidFunction");

        webViewMap.loadUrl("file:///android_asset/locationPickerPage/index.html");

        webViewMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    webViewMap.loadUrl("javascript:activityInitialize(" + latitude + "," + longitude + "," + zoom + ")");

                }
            }
        });

        // EVENT HANDLER FOR PERFORMING SEARCH IN WEBVIEW
        editLocation = (EditText) v.findViewById(R.id.SPI_editLocation);
        btnSearch = (Button) v.findViewById(R.id.SPI_btnSearch);
        btnSearch.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                webViewMap.loadUrl("javascript:if (typeof activityPerformSearch == 'function') {activityPerformSearch(\"" + editLocation.getText().toString() + "\")}");
            }
        });
        return v;
    }

    public Boolean validateRule()
    {
        if(editName.getText().toString().isEmpty()||editAge.getText().toString().isEmpty()||editLocation.getText().toString().isEmpty())
        {
            return false;
        }
        else
            return true;
    }
    public class LocationPickerJSInterface {
        @JavascriptInterface
        public void getValues(String latitude, String longitude, String zoom, String locationName){
            FragmentSetting_info.this.latitude = Float.parseFloat(latitude);
            FragmentSetting_info.this.longitude = Float.parseFloat(longitude);
            FragmentSetting_info.this.zoom = Integer.parseInt(zoom);
            FragmentSetting_info.this.locationName = locationName;

            getActivity().runOnUiThread(new Runnable() {

                public void run() {
                    //Code that interact with UI
                    FragmentSetting_info.this.editLocation.setText(FragmentSetting_info.this.locationName);

                }
            });

        }

    }


}
