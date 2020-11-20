package com.android2.mobile2activitysharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText Username;
     EditText Password;
     Button SubmitInfo;
     Button ViewInfo;
     Button Loginpage;
     SharedPreferences sharedPreferences;
     String UserInput,PassInput;






    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          Username = (EditText)findViewById(R.id.UName);
          Password = (EditText)findViewById(R.id.PWord);
          SubmitInfo = (Button)findViewById(R.id.saveinfo);
          ViewInfo = (Button)findViewById(R.id.viewinfo);


          Username.addTextChangedListener(SubmitTextWatcher);
          Password.addTextChangedListener(SubmitTextWatcher);

          sharedPreferences = getSharedPreferences("myprefrence", Context.MODE_PRIVATE);

          SubmitInfo.setEnabled(false);
          //check if data is available




          //save the data to sharedpref
          SubmitInfo.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  UserInput = Username.getText().toString().trim();
                  PassInput = Password.getText().toString().trim();


                  SharedPreferences.Editor editor = sharedPreferences.edit();

                  editor.putString("USER_NAME",UserInput);
                  editor.putString("USER_PASSWORD",PassInput);
                  editor.apply();


                  Toast.makeText(MainActivity.this, "REGISTERED", Toast.LENGTH_LONG).show();

              }
          });

         ViewInfo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 // to list of user button
                 Intent intent = new Intent( MainActivity.this,listofuser.class);
                 startActivity(intent);

             }
         });

         Loginpage = (Button)findViewById(R.id.login);

         Loginpage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                  //to log in page button

                 Intent intent = new Intent( MainActivity.this,LogIn.class);
                 startActivity(intent);

             }
         });


    }

    private TextWatcher SubmitTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String User_input = Username.getText().toString().trim();
            String Pass_input = Password.getText().toString().trim();

            SubmitInfo.setEnabled(!User_input.isEmpty() && !Pass_input.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}