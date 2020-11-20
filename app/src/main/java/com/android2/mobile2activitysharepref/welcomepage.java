package com.android2.mobile2activitysharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class welcomepage extends AppCompatActivity {

    private  String welcomeName;
    private TextView welComeDisplay;
    private  Button logout;
    private SharedPreferences sp;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);


        welComeDisplay = (TextView)findViewById(R.id.UserDisplay2);
        logout = (Button)findViewById(R.id.logout);


        sp = getApplicationContext().getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE);
        welcomeName = sp.getString("userName","");

        welComeDisplay.setText("kamusta ka po" + " " + welcomeName);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(welcomepage.this,LogIn.class);
                startActivity(intent);
            }
        });





    }
}