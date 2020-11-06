package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class code extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button cancel;
    private Button submit;
    private EditText codee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        cancel=(Button) findViewById(R.id.cancel_dialog);
        submit=(Button) findViewById(R.id.submit_dialog);
        codee=(EditText) findViewById(R.id.code);

        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String code= codee.getText().toString().trim();
        if(v== submit){
            if(userActivity.i=="chief" ){
                if(code.isEmpty()){
                    Toast.makeText(this,"Please enter the code",Toast.LENGTH_SHORT).show();
                }
                if(code.equals("chief1")){
                    startActivity(new Intent(this,Index_chef.class));
                }
            }
            if(userActivity.i=="teacher"){
                if(code.isEmpty()){
                    Toast.makeText(this,"Please enter the code",Toast.LENGTH_SHORT).show();
                }
                if(code.equals("teacher1")){
                    startActivity(new Intent(this,index_teacher.class));
                }
            }
            if(userActivity.i=="student"){
                if(code.isEmpty()){
                    Toast.makeText(this,"Please enter the code",Toast.LENGTH_SHORT).show();
                }
                if(code.equals("student1")){
                    startActivity(new Intent(this,index_student.class));
                }
            }
        }
        if(v== cancel){
            finish();
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
