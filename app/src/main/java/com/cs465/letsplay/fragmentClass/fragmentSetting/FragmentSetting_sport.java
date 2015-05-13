package com.cs465.letsplay.fragmentClass.fragmentSetting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.cs465.letsplay.R;

/**
 * Created by kevin on 4/28/2015.
 */
public class FragmentSetting_sport extends Fragment
{
    //private ImageView imgSubmit;
    private Button btnSave;
    private FragmentManager fManager;
    private int counts;

    private ImageView imgSoccer;
    private ImageView imgFootball;
    private ImageView imgGolf;
    private ImageView imgPool;
    private ImageView imgVolleyball;
    private ImageView imgBasketball;
    private ImageView imgTennis;
    private ImageView imgPingpang;
    private ImageView imgGym;


    private ImageView imgSoccer_u;
    private ImageView imgFootball_u;
    private ImageView imgGolf_u;
    private ImageView imgPool_u;
    private ImageView imgVolleyball_u;
    private ImageView imgBasketball_u;
    private ImageView imgTennis_u;
    private ImageView imgPingpang_u;
    private ImageView imgGym_u;


    public FragmentSetting_sport()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_setting_favorite_sport, container, false);
        addComponents(v);
        return v;
    }

    public void addComponents(View v)
    {
        btnSave = (Button)v.findViewById(R.id.SFS_btnSave);
        fManager = getActivity().getSupportFragmentManager();
        imgSoccer = (ImageView)v.findViewById(R.id.SFS_imgSoccer);
        imgFootball= (ImageView)v.findViewById(R.id.SFS_football);
        imgGolf = (ImageView)v.findViewById(R.id.SFS_golf);
        imgPool = (ImageView)v.findViewById(R.id.SFS_pool);
        imgVolleyball = (ImageView)v.findViewById(R.id.SFS_volleyball);
        imgBasketball = (ImageView)v.findViewById(R.id.SFS_basketball);
        imgTennis = (ImageView)v.findViewById(R.id.SFS_tennis);
        imgPingpang = (ImageView)v.findViewById(R.id.SFS_pingpeng);
        imgGym = (ImageView)v.findViewById(R.id.SFS_gym);

        imgSoccer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgSoccer_u.setVisibility(View.VISIBLE);
                imgSoccer.setVisibility(View.GONE);
                counts--;
            }
        });
        imgFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFootball_u.setVisibility(View.VISIBLE);
                imgFootball.setVisibility(View.GONE);
                counts--;
            }
        });
        imgGolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGolf_u.setVisibility(View.VISIBLE);
                imgGolf.setVisibility(View.GONE);
                counts--;
            }
        });
        imgPool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPool_u.setVisibility(View.VISIBLE);
                imgPool.setVisibility(View.GONE);
                counts--;
            }
        });
        imgVolleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgVolleyball_u.setVisibility(View.VISIBLE);
                imgVolleyball.setVisibility(View.GONE);
                counts--;
            }
        });
        imgBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBasketball_u.setVisibility(View.VISIBLE);
                imgBasketball.setVisibility(View.GONE);
                counts--;
            }
        });
        imgTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTennis_u.setVisibility(View.VISIBLE);
                imgTennis.setVisibility(View.GONE);
                counts--;
            }
        });
        imgPingpang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPingpang_u.setVisibility(View.VISIBLE);
                imgPingpang.setVisibility(View.GONE);
                counts--;
            }
        });
        imgGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGym_u.setVisibility(View.VISIBLE);
                imgGym.setVisibility(View.GONE);
                counts--;
            }
        });






        imgSoccer_u = (ImageView)v.findViewById(R.id.SFS_imgSoccer_u);
        imgFootball_u= (ImageView)v.findViewById(R.id.SFS_football_u);
        imgGolf_u = (ImageView)v.findViewById(R.id.SFS_golf_u);
        imgPool_u = (ImageView)v.findViewById(R.id.SFS_pool_u);
        imgVolleyball_u = (ImageView)v.findViewById(R.id.SFS_volleyball_u);
        imgBasketball_u = (ImageView)v.findViewById(R.id.SFS_basketball_u);
        imgTennis_u = (ImageView)v.findViewById(R.id.SFS_tennis_u);
        imgPingpang_u = (ImageView)v.findViewById(R.id.SFS_pingpeng_u);
        imgGym_u = (ImageView)v.findViewById(R.id.SFS_gym_u);

        imgSoccer_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgSoccer.setVisibility(View.VISIBLE);
                imgSoccer_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgFootball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFootball.setVisibility(View.VISIBLE);
                imgFootball_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgGolf_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGolf.setVisibility(View.VISIBLE);
                imgGolf_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgPool_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPool.setVisibility(View.VISIBLE);
                imgPool_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgVolleyball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgVolleyball.setVisibility(View.VISIBLE);
                imgVolleyball_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgBasketball_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBasketball.setVisibility(View.VISIBLE);
                imgBasketball_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgTennis_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTennis.setVisibility(View.VISIBLE);
                imgTennis_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgPingpang_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPingpang.setVisibility(View.VISIBLE);
                imgPingpang_u.setVisibility(View.GONE);
                counts++;
            }
        });
        imgGym_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGym.setVisibility(View.VISIBLE);
                imgGym_u.setVisibility(View.GONE);
                counts++;
            }
        });



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (validateRule())
                {
                    FragmentTransaction fTransaction = fManager.beginTransaction();
                    FragmentSetting fragmentSetting = new FragmentSetting();
                    fTransaction.replace(R.id.mainContent, fragmentSetting);
                    fTransaction.addToBackStack(null);
                    fTransaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please select your favorite sport.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public Boolean validateRule()
    {
        if(counts<1)
        {
            return false;
        }
        else
            return true;
    }
}
