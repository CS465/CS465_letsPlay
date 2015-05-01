package com.cs465.letsplay.fragmentClass.fragmentSportMate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cs465.letsplay.fragmentPageAdpter.TabsPagerAdapter;


import com.cs465.letsplay.R;

/**
 * Created by kevin on 3/7/2015.
 */
public class FragmentSportMate extends Fragment
{
    private ViewPager viewPager;
    //private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private View v;
    public FragmentSportMate()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_sport_mate, container, false);

        viewPager = (ViewPager)v.findViewById(R.id.pager);
        //FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentManager manager = getChildFragmentManager();

        viewPager.setAdapter(new TabsPagerAdapter(manager));
        return v;
    }

}
