package com.cs465.letsplay.fragmentClass.fragmentMyEvent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cs465.letsplay.R;
import com.cs465.letsplay.fragmentClass.fragmentProfile.FragmentProfile;
import com.cs465.letsplay.fragmentClass.fragmentSportMate.FragmentSportMate;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentMyEvent_new_1 extends Fragment
{
    private Button btnNext;
    private FragmentManager fManager;

    public FragmentMyEvent_new_1()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event_new_1_sport, container, false);
        btnNext = (Button)v.findViewById(R.id.EN1_btnSelect);
        fManager = getChildFragmentManager();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_new_1 fragNew_1 = new FragmentMyEvent_new_1();
                fTransaction.replace(R.id.mainContent,fragNew_1);
                fTransaction.commit();
            }
        });
        return v;

    }
}