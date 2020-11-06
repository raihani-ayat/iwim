package com.example.iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class attendance_teacher extends AppCompatActivity {
    private Button confirm;
    private EditText clas;
    private EditText pourcentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_teacher);

        confirm = (Button) findViewById(R.id.button2);
        clas= (EditText) findViewById(R.id.editText6);
        pourcentage = (EditText) findViewById(R.id.editText7);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clas.setText("2A-GR1");
                pourcentage.setText("20%");
            }
        });
    }
}
