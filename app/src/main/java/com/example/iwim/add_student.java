package com.example.iwim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_student extends AppCompatActivity implements View.OnClickListener {
EditText name, last_name,email,phone,group;
Button add;
ProgressBar progressBar;
FirebaseAuth firebaseAuth;
FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        name=(EditText) findViewById(R.id.stdname2);
        last_name=(EditText) findViewById(R.id.stdlastname);
        email=(EditText) findViewById(R.id.stdemail);
        phone=(EditText) findViewById(R.id.stdnumtel);
        group=(EditText) findViewById(R.id.stdclass);
        add=(Button) findViewById(R.id.add1);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        firebaseAuth= FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();


        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==add) {
            String vname;
            String vlast_name;
            String vemail;
            String vphone;
            String vgroup;
            
                vname = name.getText().toString().trim();
                vlast_name = last_name.getText().toString();
                vemail = email.getText().toString();
                vphone = phone.getText().toString();
                vgroup = group.getText().toString();
                DocumentReference documentReference = fstore.collection("students").document(vname + " " + vlast_name);
                Map<String, Object> user = new HashMap<>();
                user.put("Name", vname);
                user.put("Last name", vlast_name);
                user.put("Email", vemail);
                user.put("Phone number", vphone);
                user.put("Class", vgroup);

                progressBar.setVisibility(View.VISIBLE);

                documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        name.setText("");
                        last_name.setText("");
                        email.setText("");
                        phone.setText("");
                        group.setText("");
                    }
                });


            }
        }
    }


