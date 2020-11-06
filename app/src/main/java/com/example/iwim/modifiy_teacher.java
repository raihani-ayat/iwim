package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class modifiy_teacher extends AppCompatActivity  implements View.OnClickListener {
    private Button chooser;
    private EditText first_name,last_name;
    public static String name;
    public static String lname;
    public static int j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiy_teacher);
        chooser= (Button) findViewById(R.id.chooser);
        first_name=(EditText) findViewById(R.id.editText8);
        last_name=(EditText) findViewById(R.id.editTextt);
        chooser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==chooser){
            j=0;
            name=first_name.getText().toString();
            lname=last_name.getText().toString();

            startActivity(new Intent(this,update_teacher.class));

    }
}
}
