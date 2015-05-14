package com.cs465.letsplay.fragmentClass.fragmentFindEvent;

import android.app.ListFragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cs465.letsplay.Entities.Events;
import com.cs465.letsplay.R;
import com.cs465.letsplay.fragmentClass.fragmentSetting.FragmentSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentFindEvent_list extends Fragment
{
    private List<Events> myEvents = new ArrayList<Events>();
    private ImageView imgBasketball;
    private ImageView imgFootball;
    private ImageView imgGolf;
    private ImageView imgGym;
    private ImageView imgPingpong;
    private ImageView imgPool;
    private ListView listEvent;
    ArrayAdapter<Events> adapter;

    public FragmentFindEvent_list()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_find_events_list, container, false);


//                populateEvents();
                //registerClickCallback();

                adapter = new MyListAdapter();
                listEvent = (ListView) v.findViewById(R.id.FEL_listView);
//                list.setAdapter(adapter);

//                HorizontalScrollView buttonList = (HorizontalScrollView) v.findViewById(R.id.FEL_horizontalScrollView);
//                buttonList.setOnClickListener(new AdapterView.OnItemClickListener() {
//
//                    @Override
//                    public void onItemClick(AdapterView<?> container, View v, int position, long id) {
//
//
//                    }
//
//                });
                imgBasketball = (ImageView) v.findViewById(R.id.FEL_imgBasketball);
                imgBasketball.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Basketball Games", "ARC Center", "3 miles ~", R.mipmap.basketball_c));
                        myEvents.add(new Events("Play Basket with me", "ARC Center", "5 miles ~", R.mipmap.basketball_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                imgFootball = (ImageView) v.findViewById(R.id.FEL_imgFootball);
                imgFootball.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Football Tournament", "CRCE Center", "1 miles ~", R.mipmap.football_c));
                        myEvents.add(new Events("Football Cup Community", "ARC Center", "2 miles ~", R.mipmap.football_c));
                        myEvents.add(new Events("Training Football", "CRCE Center", "3 miles ~", R.mipmap.football_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                imgGolf = (ImageView) v.findViewById(R.id.FEL_imgGolf);
                imgGolf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Golf Training", "Main Quad", "2 miles ~", R.mipmap.golf_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                imgGym = (ImageView) v.findViewById(R.id.FEL_imgGym);
                imgGym.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Play Gym together", "ARC Center", "3 miles ~", R.mipmap.gym_c));
                        myEvents.add(new Events("Gymnastic Tournament", "CRCE Center", "2 miles ~", R.mipmap.gym_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                imgPingpong = (ImageView) v.findViewById(R.id.FEL_imgPingpeng);
                imgPingpong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Table Tennis Cup", "ARC Center", "3 miles ~", R.mipmap.pingpeng_c));
                        myEvents.add(new Events("Play Pingpong with me", "CRCE Center", "2 miles ~", R.mipmap.pingpeng_c));
                        myEvents.add(new Events("Round Pingpong Group", "Siebel Center", "1 miles ~", R.mipmap.pingpeng_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                imgPool = (ImageView) v.findViewById(R.id.FEL_imgPool);
                imgPool.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        myEvents.clear();
                        myEvents.add(new Events("Snooker Games", "Illini Union", "1 miles ~", R.mipmap.pool_c));
                        myEvents.add(new Events("Need mate for pool", "ARC Center", "1 miles ~", R.mipmap.pool_c));

                        listEvent.setAdapter(adapter);

                    }
                });

                return v;
            }

            private void populateEvents() {
                myEvents.add(new Events("Pingpong Games", "ARC Center", "2 miles ~", R.mipmap.pingpeng_c));
                myEvents.add(new Events("Pingpong Tournament", "ARC Center", "3 miles ~", R.mipmap.pingpeng_c));
            }

            private class MyListAdapter extends ArrayAdapter<Events> {

                public MyListAdapter() {
                    super(getActivity(), R.layout.custom_list_events, myEvents);
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View itemView = convertView;
                    if (itemView == null) {
                        itemView = getActivity().getLayoutInflater().inflate(R.layout.custom_list_events, parent, false);
                    }

                    Events currentEvent = myEvents.get(position);

                    TextView nameTxt = (TextView) itemView.findViewById(R.id.CLE_nameTxt);
                    nameTxt.setText(currentEvent.getName());

                    TextView placeTxt = (TextView) itemView.findViewById(R.id.CLE_placeTxt);
                    placeTxt.setText(currentEvent.getPlace());

                    TextView milesTxt = (TextView) itemView.findViewById(R.id.CLE_milesTxt);
                    milesTxt.setText(currentEvent.getMiles());

                    ImageView iconImg = (ImageView) itemView.findViewById(R.id.CLE_iconImg);
                    iconImg.setImageResource(currentEvent.getIcon());

                    return itemView;
                }

            }


        }
