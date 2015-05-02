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
import com.cs465.letsplay.SQLite.DBManager;

/**
 * Created by kevin on 4/29/2015.
 */
public class FragmentDBTest extends Fragment
{
    TextView txtResult ;
    EditText editUserName;
    EditText editId;
    Button btnSubmit;
    Button btnShow;
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
        editUserName = (EditText)v.findViewById(R.id.T_editName);
        editId = (EditText)v.findViewById(R.id.T_editId);
        btnSubmit = (Button)v.findViewById(R.id.T_btnSubmit);
        btnShow = (Button)v.findViewById(R.id.T_btnShow);
        dbManager = new DBManager(getActivity());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String userName = editUserName.getText().toString();
                String Id = editId.getText().toString();
                dbManager.createUser(userName,Id);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                User user = dbManager.getUserInfo();
                String name = user.getUsername();
                String id =  user.getUserId();
                txtResult.setText("user name: "+name+" User Id: "+ id);

            }
        });

        return v;
    }
}