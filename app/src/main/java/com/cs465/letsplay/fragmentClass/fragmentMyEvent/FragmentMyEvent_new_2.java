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
import android.widget.Toast;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentMyEvent_new_2 extends Fragment
{
    private Button btnNext;
    private FragmentManager fManager;

    private WebView webViewMap ;

    private String mydate ;
    private String myfrom ;
    private String myto ;


    @Override
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event_new_2_time, container, false);

        btnNext = (Button)v.findViewById(R.id.EN2_btnSelect);
        fManager = getActivity().getSupportFragmentManager();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_new_3 fragNew_3 = new FragmentMyEvent_new_3();
                fTransaction.replace(R.id.mainContent,fragNew_3);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location_picker);

        if (savedInstanceState!=null) {
            mydate = savedInstanceState.getString("mydate");
            myfrom = savedInstanceState.getString("myfrom");
            myfrom = savedInstanceState.getString("myto");

        }

        // LOCATION PICKER WEBVIEW SETUP
        webViewMap = (WebView) v.findViewById(R.id.EN2_webViewMap);
        webViewMap.setScrollContainer(false);
        webViewMap.getSettings().setDomStorageEnabled(true);
        webViewMap.getSettings().setJavaScriptEnabled(true);
        webViewMap.addJavascriptInterface(new JSInterface(), "AndroidFunction");

        webViewMap.loadUrl("file:///android_asset/locationPickerPage/round.html");

        webViewMap.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    webViewMap.loadUrl("javascript:activityInitialize(" + mydate + "," + mydate + "," + myto + ")");

                }
            }
        });

        // EVENT HANDLER FOR PERFORMING SEARCH IN WEBVIEW



        return v;
    }

    public class JSInterface {

        @JavascriptInterface
        public void getValues(String mydate, String myfrom, String myto){

            FragmentMyEvent_new_2.this.mydate = mydate;
            FragmentMyEvent_new_2.this.myfrom = myfrom;
            FragmentMyEvent_new_2.this.myto = myto;

            showToast(mydate + "-> from:" + myfrom + " to: " + myto);
        }

        // to ease debugging
        public void showToast(String toast){
            Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
        }

    }


}