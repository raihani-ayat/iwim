package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.firebase.auth.FirebaseAuth;

public class Index_chef extends AppCompatActivity {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button logout;
    private FirebaseAuth fire;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_index_chef);

        but1= (Button) findViewById(R.id.textView6);
        but2= (Button) findViewById(R.id.buti);
        but3= (Button) findViewById(R.id.butii);
        but4= (Button) findViewById(R.id.butiki);
        logout=(Button) findViewById(R.id.logout);
        fire= FirebaseAuth.getInstance();
        if(fire.getCurrentUser()== null){
            finish();
            Intent int4= new Intent(this,SplashActivity.class);
            startActivity(int4);
        }

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEmploi();
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              goToAbs();
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTeachers();
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStudents();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_to_splash();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index_chef, menu);
        return true;
    }

    public void goToEmploi(){
        Intent int1= new Intent(this,Schedule_chief.class);
        startActivity(int1);

    }

    public void goToAbs(){

        Intent int2 = new Intent(this, Attendance_chef.class);
        startActivity(int2);
    }

    public void goToTeachers(){

        Intent int3 = new Intent(this,teacher_chief.class);
        startActivity(int3);
    }

    public void goToStudents(){

        Intent int4 = new Intent(this, std_chief_index.class);
        startActivity(int4);
    }

    public void go_to_splash(){
        fire.signOut();
        finish();
        Intent int5= new Intent(this,SplashActivity.class);
        startActivity(int5);

    }



}
