package com.cs465.letsplay.ActivityClass;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.cs465.letsplay.R;

public class LoginActivity extends ActionBarActivity {


    private EditText editUserName;
    private ImageView imgStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUserName = (EditText)findViewById(R.id.L_editName);
        imgStart     = (ImageView)findViewById(R.id.L_imgBtnStart);
        imgStart.setOnClickListener(new  View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                String userName = editUserName.getText().toString();
                if(!userName.isEmpty())
                {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
