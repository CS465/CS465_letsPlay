package com.cs465.letsplay.fragmentClass.fragmentProfile;

/**
 * Created by kevin on 3/7/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs465.letsplay.R;

public class FragmentProfile extends Fragment
{

    public FragmentProfile()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }
}
