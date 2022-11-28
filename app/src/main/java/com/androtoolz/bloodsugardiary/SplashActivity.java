package com.androtoolz.bloodsugardiary;

import Ads.CustomUtils;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.widget.Toast;

public class
SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //  Log.e("cccc", String.valueOf(MyApp.isJsonDone));
                if(MyApp.isJsonDone == 0){
                    handler.postDelayed(this, CustomUtils.TIME);
                }
                else if(MyApp.isJsonDone == 1)
                {
                    Intent i = new Intent(getBaseContext(), Framework.class);
                    startActivity(i);

                }
                else if(MyApp.isJsonDone == 2){
                    Toast.makeText(getApplicationContext(), "Error Plese try again later", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        },CustomUtils.TIME);


    }
}