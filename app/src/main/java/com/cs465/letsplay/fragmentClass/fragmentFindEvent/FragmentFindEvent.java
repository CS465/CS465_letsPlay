package com.cs465.letsplay.fragmentClass.fragmentFindEvent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs465.letsplay.R;
import com.cs465.letsplay.fragmentPageAdpter.TabsPagerAdapter;
import com.cs465.letsplay.fragmentPageAdpter.TabsPagerAdapter_event;

/**
 * Created by kevin on 3/7/2015.
 */
public class FragmentFindEvent extends Fragment
{
    private ViewPager viewPager;
    public FragmentFindEvent()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_find_events, container, false);

        viewPager = (ViewPager)v.findViewById(R.id.pager_event);
        //FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentManager manager = getChildFragmentManager();

        viewPager.setAdapter(new TabsPagerAdapter_event(manager));

        return v;
    }
}
