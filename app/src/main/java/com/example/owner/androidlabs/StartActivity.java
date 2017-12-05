package com.example.owner.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "StartActivity";
    private Button aButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        aButton = (Button)findViewById(R.id.button);
        aButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent n = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(n, 10);
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
     if(requestCode == 10 && responseCode == Activity.RESULT_OK){
         Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
         String messagePassed = data.getStringExtra("Response");
         Toast.makeText(StartActivity.this, messagePassed, Toast.LENGTH_LONG).show();
     }
    }
}
