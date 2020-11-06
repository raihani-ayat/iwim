package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class modify_student extends AppCompatActivity implements View.OnClickListener {

    private Button choserr;
    private EditText name, lname;
    public static String stdname;
    public static String std_lastname;
    public static int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_student);
        choserr=(Button) findViewById(R.id.chooserr);
        name=(EditText) findViewById(R.id.editText8);
        lname=(EditText) findViewById(R.id.textView106);
        choserr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==choserr){
            i=0;
            stdname=name.getText().toString();
            std_lastname=lname.getText().toString();

            startActivity(new Intent(this,update_student.class));
        }

    }
}
