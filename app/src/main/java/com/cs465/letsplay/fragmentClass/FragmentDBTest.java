package com.cs465.letsplay.fragmentClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/29/2015.
 */
public class FragmentDBTest extends Fragment
{
    TextView txtTitle ;

    public FragmentDBTest()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_dbtest, container, false);
        txtTitle = (TextView)v.findViewById(R.id.T_title);
        txtTitle.setText("something here");
        return v;
    }
}