package com.cs465.letsplay.fragmentPageAdpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cs465.letsplay.fragmentClass.fragmentFindEvent.FragmentFindEvent_list;
import com.cs465.letsplay.fragmentClass.fragmentFindEvent.FragmentFindEvent_map;

/**
 * Created by kevin on 5/6/2015.
 */
public class TabsPagerAdapter_event extends FragmentPagerAdapter {

    public TabsPagerAdapter_event(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new FragmentFindEvent_list();
            case 1:
                // Games fragment activity
                return new FragmentFindEvent_map();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        String title = new String();
        if (position == 0) {
            title = "List";
        } else if (position == 1) {
            title = "Map";
        }
        return title;
    }
}


