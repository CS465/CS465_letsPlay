package com.cs465.letsplay.fragmentClass.fragmentSportMate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/29/2015.
 */
public class FragmentSportMate_list extends Fragment
{
    public FragmentSportMate_list()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_sport_mate_list, container, false);
        return v;
    }
}
