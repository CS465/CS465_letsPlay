package com.cs465.letsplay.fragmentClass.fragmentSetting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 3/7/2015.
 */
public class FragmentSetting extends Fragment
{
    private ImageView imgInfo;
    private ImageView imgSport;
    private ImageView imgTime;
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
        imgInfo = (ImageView)v.findViewById(R.id.SET_imgPersonalInfo);
        imgSport = (ImageView)v.findViewById(R.id.SET_imgSport);
        imgTime = (ImageView)v.findViewById(R.id.SET_imgTime);

        fManager = getActivity().getSupportFragmentManager();

        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting_info fragmentInfo = new FragmentSetting_info();
                fTransaction.replace(R.id.mainContent,fragmentInfo);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        imgSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentSetting_sport fragmentSport = new FragmentSetting_sport();
                fTransaction.replace(R.id.mainContent,fragmentSport);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        imgTime.setOnClickListener(new View.OnClickListener() {
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
