package com.cs465.letsplay.fragmentClass.fragmentSetting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentSetting_sport extends Fragment
{
    private Button btnSet;
    public FragmentSetting_sport()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting_favorite_sport, container, false);
        btnSet = (Button)v.findViewById(R.id.SFS_btnSet);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //todo the db call here
            }
        });

        return v;
    }
}
