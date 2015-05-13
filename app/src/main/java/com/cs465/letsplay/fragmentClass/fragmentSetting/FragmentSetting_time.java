package com.cs465.letsplay.fragmentClass.fragmentSetting;

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
import android.widget.Toast;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentSetting_time extends Fragment
{
    private WebView webViewMap ;
    private Float latitude = 0f;
    private Float longitude = 0f;
    private Integer zoom = 5;
    private String locationName;
    private Button btnSave;
    private FragmentManager fManager;
    public FragmentSetting_time()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting_available_time, container, false);
        fManager = getActivity().getSupportFragmentManager();
        btnSave = (Button) v.findViewById(R.id.SAT_btnEdit);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting fragmentSetting = new FragmentSetting();
                fTransaction.replace(R.id.mainContent,fragmentSetting);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
        // LOCATION PICKER WEBVIEW SETUP
        webViewMap = (WebView) v.findViewById(R.id.SAT_webViewMap);
        webViewMap.setScrollContainer(false);
        webViewMap.getSettings().setDomStorageEnabled(true);
        webViewMap.getSettings().setJavaScriptEnabled(true);
        webViewMap.addJavascriptInterface(new JSInterface(), "AndroidFunction");


        webViewMap.loadUrl("file:///android_asset/locationPickerPage/time.html");

        webViewMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {

                if (progress == 100) {
                    webViewMap.loadUrl("javascript:setData('sunday',5,20)");
                    webViewMap.loadUrl("javascript:activityInitialize(" + latitude + "," + longitude + "," + zoom + ")");
                }
            }
        });


        return v;
    }

    public class JSInterface {
        @JavascriptInterface
        public void getData(String day, String from, String to){
            showToast(day + "-> from:" + from + " to: " + to);
        }

        // to ease debugging
        public void showToast(String toast){
            Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
        }

    }



}
