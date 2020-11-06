package com.example.iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Attendance_chef extends AppCompatActivity {

    public Spinner sp1;
    public Spinner sp2;
    private Button choose;
    private TextView sub;
    private TextView stdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_cheif);

        sp1= (Spinner) findViewById(R.id.spinner1);
        sp2= (Spinner) findViewById(R.id.spinner2);
        choose= (Button) findViewById(R.id.choose);
        sub= (TextView) findViewById(R.id.sub_name);
        stdt=(TextView) findViewById(R.id.std_2);

        String[] subjects =new String[]{"Potions","Dark arts repell","Enchanted creatures"};
        String[] students = new String[]{"Warewolf Anderson", "Harry Potter", "Unicorn Hailey","Dwarf Jack"};

        final ArrayAdapter<String> Adapter1= new ArrayAdapter<String>(this, R.layout.item_list,subjects);
        final ArrayAdapter<String> Adapter2= new ArrayAdapter<String>(this, R.layout.item_list,students);

        Adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp1.setAdapter(Adapter1);
        sp2.setAdapter(Adapter2);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub.setText(Adapter1.getItem(0));
                stdt.setText(Adapter2.getItem(1));

            }
        });

    }
}
