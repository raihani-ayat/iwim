package com.example.iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class std_chief_index extends AppCompatActivity {
    private Button listt;
    private Button add;
    private Button modifiy;
    private Button contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_chief_index);

        listt = (Button) findViewById(R.id.k1);
        add=(Button) findViewById(R.id.k2);
        modifiy=(Button) findViewById(R.id.k3);
        contact=(Button) findViewById(R.id.k4);

        listt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_list();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_add_student();
            }
        });

        modifiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_modify();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_send_msg();
            }
        });
    }

    public void open_list(){
        Intent int11= new Intent(this,students_list.class);
        startActivity(int11);
    }

    public void open_add_student(){
        Intent int22= new Intent(this,add_student.class);
        startActivity(int22);
    }

    public void open_modify(){
        Intent int33= new Intent(this,modify_student.class);
        startActivity(int33);
    }

    public void open_send_msg(){
        Intent int44= new Intent(this,send_message.class);
        startActivity(int44);
    }
}
