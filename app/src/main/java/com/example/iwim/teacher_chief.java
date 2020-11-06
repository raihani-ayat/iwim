package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class teacher_chief extends AppCompatActivity implements View.OnClickListener {
    private Button listt;
    private Button add;
    private Button modifiy;
    private Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_chief);
        listt = (Button) findViewById(R.id.k1);
        add=(Button) findViewById(R.id.k2);
        modifiy=(Button) findViewById(R.id.k3);
        contact=(Button) findViewById(R.id.k4);

        listt.setOnClickListener(this);
        add.setOnClickListener(this);
        modifiy.setOnClickListener(this);
        contact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==listt){
            Intent int11= new Intent(this,teachers_list.class);
            startActivity(int11);
        }
        if(v==add){
            Intent int22= new Intent(this,add_teacher.class);
            startActivity(int22);
        }
        if(v==modifiy){
            Intent int33= new Intent(this,modifiy_teacher.class);
            startActivity(int33);
        }
        if(v==contact){
            Intent int44= new Intent(this,send_message.class);
            startActivity(int44);
        }
    }
}
