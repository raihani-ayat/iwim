package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class index_student extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button logout;
    private FirebaseAuth fir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_student);

        but1= (Button) findViewById(R.id.aa);
        but2= (Button) findViewById(R.id.tt);
        but3= (Button) findViewById(R.id.vv);
        but4= (Button) findViewById(R.id.hh);
        logout=(Button) findViewById(R.id.logout);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);

        fir= FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v==but1){
            startActivity(new Intent(this,schedule.class));
        }
        if(v==but2){
            startActivity(new Intent(this,attendance_student.class));
        }
        if(v==but3){
            startActivity(new Intent(this,teachers_list.class));
        }
        if(v==but4){
            startActivity(new Intent(this,Messagerie.class));
        }
        if(v==logout){
            fir.signOut();
            startActivity(new Intent(this,com.example.iwim.ui.slideshow.signing.class));
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getKeyCode()==4){
            startActivity(new Intent(this,com.example.iwim.ui.slideshow.signing.class));
        }
        return false;
    }
}
