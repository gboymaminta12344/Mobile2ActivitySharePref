package com.android2.mobile2activitysharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LogIn extends AppCompatActivity {

    private EditText loginuname,loginpassword;
    private Button LogIn;
    private String UserInput,PassInput,userrname,passsword;
    private String Input1,Input2;
    private SharedPreferences sharedPreferences;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private CheckBox rememberme;
    private Button regMe;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        regMe = (Button) findViewById(R.id.register);
        loginuname = (EditText)findViewById(R.id.LogIn);
        loginpassword = (EditText)findViewById(R.id.PassWordLogIn);
        rememberme = (CheckBox)findViewById(R.id.rememberme);
        LogIn = (Button)findViewById(R.id.LogInButton);
        loginPreferences = getSharedPreferences("LoginPrefs",MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        //shareDPreferences of registered data
        sharedPreferences = getApplicationContext().getSharedPreferences("myprefrence", Context.MODE_PRIVATE);
        userrname = sharedPreferences.getString("USER_NAME" , "");
        passsword = sharedPreferences.getString("USER_PASSWORD", "");

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if(saveLogin==true){

            loginuname.setText(loginPreferences.getString("userName",""));
            loginpassword.setText(loginPreferences.getString("passWord",""));
            rememberme.setChecked(true);

        }


        //button to log in
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   //to welcome page
                welcomepage();

            }
        });

        regMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }

    public void welcomepage(){

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(loginuname.getWindowToken(),0);

        Input1 = loginuname.getText().toString();
        Input2 = loginpassword.getText().toString();

        UserInput = loginuname.getText().toString();
        PassInput = loginpassword.getText().toString();



        if(!UserInput.isEmpty() && !PassInput.isEmpty()) {
            if (UserInput.equals(userrname) && PassInput.equals(passsword)) {


                Intent intent = new Intent(LogIn.this, welcomepage.class);
                startActivity(intent);

                Toast.makeText(this, "you are logged in", Toast.LENGTH_LONG).show();

                if(rememberme.isChecked()){
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("userName",Input1);
                    loginPrefsEditor.putString("passWord",Input2);
                    loginPrefsEditor.commit();
                }else{

                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();

                }



            } else{

                Toast.makeText(this, "incorrect username or password", Toast.LENGTH_LONG).show();
            }


        }else {

            Toast.makeText(this, "no username or password", Toast.LENGTH_LONG).show();
        }
    }









}