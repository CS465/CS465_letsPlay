package com.cs465.letsplay.fragmentClass.fragmentMyEvent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs465.letsplay.R;
import com.cs465.letsplay.fragmentClass.fragmentProfile.FragmentProfile;
import com.cs465.letsplay.fragmentClass.fragmentSportMate.FragmentSportMate;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentMyEvent_new_1 extends Fragment
{
    private Button btnNext;
    private FragmentManager fManager;

    private ImageView imgSoccer;
    private ImageView imgFootball;
    private ImageView imgGolf;
    private ImageView imgPool;
    private ImageView imgVolleyball;
    private ImageView imgBasketball;
    private ImageView imgTennis;
    private ImageView imgPingpang;
    private ImageView imgGym;
    private TextView txtSelection;


    private ImageView imgSoccer_u;
    private ImageView imgFootball_u;
    private ImageView imgGolf_u;
    private ImageView imgPool_u;
    private ImageView imgVolleyball_u;
    private ImageView imgBasketball_u;
    private ImageView imgTennis_u;
    private ImageView imgPingpang_u;
    private ImageView imgGym_u;


    public FragmentMyEvent_new_1()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_event_new_1_sport, container, false);
        btnNext = (Button)v.findViewById(R.id.EN1_btnSelect);
        fManager = getActivity().getSupportFragmentManager();
        txtSelection = (TextView)v.findViewById(R.id.EN1_txtSelection);

        imgSoccer = (ImageView)v.findViewById(R.id.EN1_imgSoccer);
        imgFootball= (ImageView)v.findViewById(R.id.EN1_football);
        imgGolf = (ImageView)v.findViewById(R.id.EN1_golf);
        imgPool = (ImageView)v.findViewById(R.id.EN1_pool);
        imgVolleyball = (ImageView)v.findViewById(R.id.EN1_volleyball);
        imgBasketball = (ImageView)v.findViewById(R.id.EN1_basketball);
        imgTennis = (ImageView)v.findViewById(R.id.EN1_tennis);
        imgPingpang = (ImageView)v.findViewById(R.id.EN1_pingpeng);
        imgGym = (ImageView)v.findViewById(R.id.EN1_gym);

        imgSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgSoccer_u.setVisibility(View.VISIBLE);
                imgSoccer.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFootball_u.setVisibility(View.VISIBLE);
                imgFootball.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgGolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGolf_u.setVisibility(View.VISIBLE);
                imgGolf.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgPool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPool_u.setVisibility(View.VISIBLE);
                imgPool.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgVolleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgVolleyball_u.setVisibility(View.VISIBLE);
                imgVolleyball.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBasketball_u.setVisibility(View.VISIBLE);
                imgBasketball.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTennis_u.setVisibility(View.VISIBLE);
                imgTennis.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgPingpang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPingpang_u.setVisibility(View.VISIBLE);
                imgPingpang.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });
        imgGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGym_u.setVisibility(View.VISIBLE);
                imgGym.setVisibility(View.GONE);
                txtSelection.setText("");
            }
        });

        imgSoccer_u = (ImageView)v.findViewById(R.id.EN1_imgSoccer_u);
        imgFootball_u= (ImageView)v.findViewById(R.id.EN1_football_u);
        imgGolf_u = (ImageView)v.findViewById(R.id.EN1_golf_u);
        imgPool_u = (ImageView)v.findViewById(R.id.EN1_pool_u);
        imgVolleyball_u = (ImageView)v.findViewById(R.id.EN1_volleyball_u);
        imgBasketball_u = (ImageView)v.findViewById(R.id.EN1_basketball_u);
        imgTennis_u = (ImageView)v.findViewById(R.id.EN1_tennis_u);
        imgPingpang_u = (ImageView)v.findViewById(R.id.EN1_pingpeng_u);
        imgGym_u = (ImageView)v.findViewById(R.id.EN1_gym_u);

        imgSoccer_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                removeAll();
                imgSoccer.setVisibility(View.VISIBLE);
                imgSoccer_u.setVisibility(View.GONE);
                txtSelection.setText("Soccer");
            }
        });
        imgFootball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgFootball.setVisibility(View.VISIBLE);
                imgFootball_u.setVisibility(View.GONE);
                txtSelection.setText("Football");

            }
        });
        imgGolf_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgGolf.setVisibility(View.VISIBLE);
                imgGolf_u.setVisibility(View.GONE);
                txtSelection.setText("Golf");

            }
        });
        imgPool_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgPool.setVisibility(View.VISIBLE);
                imgPool_u.setVisibility(View.GONE);
                txtSelection.setText("Snooker");

            }
        });
        imgVolleyball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgVolleyball.setVisibility(View.VISIBLE);
                imgVolleyball_u.setVisibility(View.GONE);
                txtSelection.setText("Volleyball");

            }
        });
        imgBasketball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgBasketball.setVisibility(View.VISIBLE);
                imgBasketball_u.setVisibility(View.GONE);
                txtSelection.setText("Basketball");

            }
        });
        imgTennis_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgTennis.setVisibility(View.VISIBLE);
                imgTennis_u.setVisibility(View.GONE);
                txtSelection.setText("Tennis");

            }
        });
        imgPingpang_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgPingpang.setVisibility(View.VISIBLE);
                imgPingpang_u.setVisibility(View.GONE);
                txtSelection.setText("PingPang");

            }
        });
        imgGym_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAll();
                imgGym.setVisibility(View.VISIBLE);
                imgGym_u.setVisibility(View.GONE);
                txtSelection.setText("Gym");

            }
        });



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction  = fManager.beginTransaction();
                FragmentMyEvent_new_2 fragNew_2 = new FragmentMyEvent_new_2();
                fTransaction.replace(R.id.mainContent,fragNew_2);
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });

        return v;

    }


    public void removeAll()
    {
        imgSoccer.setVisibility(View.GONE);
        imgSoccer_u.setVisibility(View.VISIBLE);
        imgFootball.setVisibility(View.GONE);
        imgFootball_u.setVisibility(View.VISIBLE);
        imgGolf.setVisibility(View.GONE);
        imgGolf_u.setVisibility(View.VISIBLE);
        imgPool.setVisibility(View.GONE);
        imgPool_u.setVisibility(View.VISIBLE);
        imgVolleyball.setVisibility(View.GONE);
        imgVolleyball_u.setVisibility(View.VISIBLE);
        imgBasketball.setVisibility(View.GONE);
        imgBasketball_u.setVisibility(View.VISIBLE);
        imgTennis.setVisibility(View.GONE);
        imgTennis_u.setVisibility(View.VISIBLE);
        imgPingpang.setVisibility(View.GONE);
        imgPingpang_u.setVisibility(View.VISIBLE);
        imgGym.setVisibility(View.GONE);
        imgGym_u.setVisibility(View.VISIBLE);
    }
}