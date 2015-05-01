package com.cs465.letsplay.fragmentClass.fragmentSetting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentSetting_info extends Fragment
{

    private EditText editName;
    private EditText editAge;
    private EditText editLocation;
    private Spinner spinnerGender;
    private Button btnEdit;
    private WebView webViewMap ;

    public FragmentSetting_info()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting_personal_info, container, false);
        editName = (EditText)v.findViewById(R.id.SPI_editName);
        editAge = (EditText)v.findViewById(R.id.SPI_editAge);
        editLocation = (EditText)v.findViewById(R.id.SPI_editLocation);
        spinnerGender = (Spinner)v.findViewById(R.id.SPI_spinnerGender);
        btnEdit = (Button)v.findViewById(R.id.SPI_btnEdit);
        webViewMap = (WebView)v.findViewById(R.id.SPI_webViewMap);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //todo logic here

            }
        });



        return v;
    }
}
