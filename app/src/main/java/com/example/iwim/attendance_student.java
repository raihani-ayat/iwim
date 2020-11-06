package com.example.iwim;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class attendance_student extends AppCompatActivity {
    private Spinner sp;
    private Button choose;
    public TextView subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_student);

        subject= (TextView) findViewById(R.id.sub_name);

        sp= (Spinner)  findViewById(R.id.spinner);
        String[] arraySpinner =new String[]{"Enchanted cteatures","Potions","Dark arts repell"};
        final ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,R.layout.item_list,arraySpinner);
        Adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(Adapter);

        choose = (Button) findViewById(R.id.choose);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject.setText(Adapter.getItem(1));

            }
        });
    }
}
