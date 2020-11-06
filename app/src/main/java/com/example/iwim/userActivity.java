package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class userActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button button1;
    private Button button2;
    private Button button3;
    public static String i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        button1= (Button) findViewById(R.id.textView6);
        button2= (Button) findViewById(R.id.textView8);
        button3= (Button) findViewById(R.id.textView10);

        button1.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if(v==button1){
            i="chief";
            startActivity(new Intent(this,code.class));
        }
        if(v==button2){
            i="teacher";
            startActivity(new Intent(this,code.class));
        }
        if(v==button3){
            i="student";
            startActivity(new Intent(this,code.class));
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getKeyCode()==4){
            finish();
        }
        return false;
    }
}



