package com.cs465.letsplay.fragmentClass.fragmentMyEvent;


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
public class FragmentMyEvent extends Fragment
{
    private ImageView imgNewEvent;
    private ImageView imgMyEvent;
    private FragmentManager fManager;
    public FragmentMyEvent()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event, container, false);
        imgNewEvent = (ImageView)v.findViewById(R.id.MY_imgCreateEven);
        imgMyEvent = (ImageView)v.findViewById(R.id.MY_imgMyEven);
        fManager = getActivity().getSupportFragmentManager();

        imgNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_new_1 fragmentMyE_new1 = new FragmentMyEvent_new_1();
                fTransaction.replace(R.id.mainContent,fragmentMyE_new1);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });


        imgMyEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_created fragmentMyEvent_created = new FragmentMyEvent_created();
                fTransaction.replace(R.id.mainContent,fragmentMyEvent_created);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
        return v;
    }
}
