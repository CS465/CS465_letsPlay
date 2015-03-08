package com.cs465.letsplay;

/**
 * Created by kevin on 3/7/2015.
 */
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// MainActivity Class
public class MainActivity extends ActionBarActivity  implements OnItemClickListener
{
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] menu;
    private ActionBarDrawerToggle drawerListener;
    private FragmentManager fManager;

    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        //enable the action bar
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        menu = getResources().getStringArray(R.array.menu);
        //Set up the List view for the menu
        listView = (ListView)findViewById(R.id.drawerList);
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.custom_list_item,menu));
        listView.setOnItemClickListener(this);
        // drawer menu
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerListener);
        // fragment manager

        fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction  = fManager.beginTransaction();
        FragmentProfile fragmentProfile = new FragmentProfile();
        fTransaction.add(R.id.mainContent,fragmentProfile);
        fTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        if(drawerListener.onOptionsItemSelected(menuItem))
        {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onConfigurationChanged(Configuration config)
    {

        super.onConfigurationChanged(config);
        drawerListener.onConfigurationChanged(config);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id)
    {
        selectItem(position);

    }
    public void selectItem(int position)
    {
        listView.setItemChecked(position, true);
        setTitle(menu[position]);
        FragmentTransaction fTransaction  = fManager.beginTransaction();
        Toast.makeText(getBaseContext(), "On fragment : "+menu[position],Toast.LENGTH_SHORT).show();
		/*
		 * need to research how to implement backstack here
		 */
        switch (position)
        {
            case 0:
                fTransaction.replace(R.id.mainContent,new FragmentProfile());
                fTransaction.commit();
                break;
            case 1:
                fTransaction.replace(R.id.mainContent, new FragmentContacts());
                fTransaction.commit();
                break;
            case 2:
                fTransaction.replace(R.id.mainContent, new FragmentEvent());
                fTransaction.commit();
                break;
            case 3:
                fTransaction.replace(R.id.mainContent, new FragmentSearch());
                fTransaction.commit();
                break;
            case 4:
                fTransaction.replace(R.id.mainContent, new FragmentSetting());
                fTransaction.commit();
                break;
            default:
                break;

        }
        drawerLayout.closeDrawers();

    }
    public void setTitle(String title)
    {
        getSupportActionBar().setTitle(title);

    }

}
