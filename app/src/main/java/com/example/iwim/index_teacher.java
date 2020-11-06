package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class index_teacher extends AppCompatActivity implements View.OnClickListener {
private Button but1;
private Button but2;
private Button but3;
    private Button logout;
    private FirebaseAuth fir;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_teacher);
        but1= (Button) findViewById(R.id.textView6);
        but2= (Button) findViewById(R.id.ko);
        but3= (Button) findViewById(R.id.koo);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);

        logout=(Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);

        fir= FirebaseAuth.getInstance();

        if(fir.getCurrentUser()== null){
            finish();
            Intent int4= new Intent(this,SplashActivity.class);
            startActivity(int4);
        }

    }
    @Override
    public void onClick(View v) {
        if(v==but1){
            Intent int1= new Intent(this, emploi_teacher.class);
            startActivity(int1);
        }
        if(v==but2){
            Intent int2 = new Intent(this, attendance_teacher.class);
            startActivity(int2);
        }
        if(v==but3){
            Intent int4= new Intent(this, Messagerie.class);
            startActivity(int4);
        }
        if(v==logout){
            fir.signOut();
            Intent int5= new Intent(this,SplashActivity.class);
            startActivity(int5);
        }

    }
}
