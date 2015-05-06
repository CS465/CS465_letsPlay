package com.cs465.letsplay.fragmentClass.fragmentSetting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 3/7/2015.
 */
public class FragmentSetting extends Fragment
{
    private Button btnInfo;
    private Button btnSport;
    private Button btnTime;

    private FragmentManager fManager;

    public FragmentSetting()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        btnInfo = (Button)v.findViewById(R.id.SET_btnPersonalInfo);
        btnSport = (Button)v.findViewById(R.id.SET_btnSport);
        btnTime = (Button)v.findViewById(R.id.SET_btnAvailableTime);



        fManager = getActivity().getSupportFragmentManager();

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting_info fragmentInfo = new FragmentSetting_info();
                fTransaction.replace(R.id.mainContent,fragmentInfo);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting_sport fragmentSport = new FragmentSetting_sport();
                fTransaction.replace(R.id.mainContent,fragmentSport);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting_time fragmentTime = new FragmentSetting_time();
                fTransaction.replace(R.id.mainContent,fragmentTime);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });


        return v;
    }
}
