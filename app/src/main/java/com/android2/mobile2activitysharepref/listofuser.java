package com.android2.mobile2activitysharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class listofuser extends AppCompatActivity {

    TextView DN,DP;
    Button deldata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofuser);

        DN = findViewById(R.id.UserDisplay);
        DP = findViewById(R.id.UPWord);

        deldata = (Button)findViewById(R.id.DELETE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("myprefrence", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("USER_NAME" , "");
        String password = sharedPreferences.getString("USER_PASSWORD", "");

        DN.setText(username);
        DP.setText(password);

        deldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("myprefrence", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                editor.commit();


                finish();
                mainpage();



            }
        });

    }
    public void mainpage(){


        Intent intent = new Intent( this,MainActivity.class);
        startActivity(intent);
    }



}