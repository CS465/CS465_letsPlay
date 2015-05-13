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
import com.cs465.letsplay.fragmentClass.fragmentSetting.FragmentSetting_info;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentMyEvent_new_4 extends Fragment
{
    private Button btnSubmit;
    private FragmentManager fManager;
    public FragmentMyEvent_new_4()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event_new_4_info, container, false);
        btnSubmit =(Button) v.findViewById(R.id.EN4_btnCreate);
        fManager = getActivity().getSupportFragmentManager();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentProfile fragmentProfile = new FragmentProfile();
                fTransaction.replace(R.id.mainContent,fragmentProfile);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
        return v;
    }
}
