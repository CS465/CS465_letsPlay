package com.cs465.letsplay.fragmentPageAdpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cs465.letsplay.fragmentClass.fragmentSportMate.FragmentSportMate_finder;
import com.cs465.letsplay.fragmentClass.fragmentSportMate.FragmentSportMate_list;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kevin on 4/29/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter
{

    public TabsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int index)
    {

        switch (index)
        {
            case 0:
                // Top Rated fragment activity
                return new FragmentSportMate_list();
            case 1:
                // Games fragment activity
                return new FragmentSportMate_finder();
        }

        return null;
    }

    @Override
    public int getCount()
    {
        // get item count - equal to number of tabs
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        String title = new String();
        if (position == 0) {
            title = "Friend";
        } else if (position == 1) {
            title = "Finder";
        }
        return title;
    }


}