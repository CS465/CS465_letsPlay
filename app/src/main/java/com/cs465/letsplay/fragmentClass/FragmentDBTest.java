package com.cs465.letsplay.fragmentClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cs465.letsplay.Entities.User;
import com.cs465.letsplay.R;
import com.cs465.letsplay.SQLLite.DBManager;

/**
 * Created by kevin on 4/29/2015.
 */
public class FragmentDBTest extends Fragment
{
    TextView txtResult ;
    EditText editName;
    EditText editId;
    Button btnsumbit;
    Button btnshow;
    DBManager dbManager;

    public FragmentDBTest()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_dbtest, container, false);
        txtResult = (TextView)v.findViewById(R.id.T_result);
        editName = (EditText)v.findViewById(R.id.editText);
        editId = (EditText)v.findViewById(R.id.editUserId);
        btnshow = (Button)v.findViewById(R.id.T_btnshow);
        btnsumbit =(Button)v.findViewById(R.id.T_btnSubmit);
        dbManager = new DBManager(getActivity());



        btnsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = editName.getText().toString();
                String userId = editId.getText().toString();
                dbManager.createUser(userName,userId);

            }
        });
        btnshow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                User user = dbManager.getUserInfo();
                String userName = user.getUsername();
                String userId = user.getUserId();
                txtResult.setText("name : "+userName+" | "+"ID: "+String.valueOf(userId));

            }
        });

        return v;
    }
}