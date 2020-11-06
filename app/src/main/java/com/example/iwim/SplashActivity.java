package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public  class SplashActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button buttonSub;
    private Button buttonLog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);

        buttonSub = (Button) findViewById(R.id.button7);
        buttonLog = (Button) findViewById(R.id.button8);

        buttonSub.setOnClickListener(this);
        buttonLog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==buttonLog){
            startActivity(new Intent(this,com.example.iwim.ui.slideshow.signing.class));
        }
        if(v==buttonSub){
            startActivity(new Intent(this,Subscribe.class));
        }

    }


}


