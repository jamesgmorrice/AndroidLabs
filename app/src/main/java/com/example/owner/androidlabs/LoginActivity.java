package com.example.owner.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    protected static final String Activity_Name = "LoginActivity";
    protected Button loginButton;
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;
    public static String pref_emails = "loginEmails";
    public static final String default_email = "default_email";
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(Activity_Name, "In OnCreate()");
        pref = getSharedPreferences(pref_emails, Context.MODE_PRIVATE);

        loginButton = (Button)findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.editText);
                String email = text.getText().toString();
                pref = getSharedPreferences(pref_emails, Context.MODE_PRIVATE);
                editor = pref.edit();
                editor.putString(default_email, email);
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(Activity_Name, "In onResume()");
        pref = getSharedPreferences(pref_emails, Context.MODE_PRIVATE);
        String previousEmail = pref.getString(default_email, "email@domain.com");
        ((EditText)findViewById(R.id.editText)).setText(previousEmail);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(Activity_Name, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Activity_Name, "In onPause()");
        updateEmail();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Activity_Name, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Activity_Name, "In onDestroy()");
        updateEmail();
    }

    public void updateEmail(){
        EditText text = (EditText)findViewById(R.id.editText);
        String email = text.getText().toString();
        pref = getSharedPreferences(pref_emails, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString(default_email, email);
        editor.commit();
    }
}
