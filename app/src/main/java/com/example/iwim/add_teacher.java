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

public class add_teacher extends AppCompatActivity implements View.OnClickListener {
EditText name,last_name,email,phone,subject;
Button add;
ProgressBar progressBar;
FirebaseAuth firebaseAuth;
FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        name=(EditText) findViewById(R.id.stdname);
        last_name=(EditText) findViewById(R.id.stdlastname);
        email=(EditText) findViewById(R.id.stdemail);
        phone=(EditText) findViewById(R.id.stdnumtel);
        subject=(EditText) findViewById(R.id.stdclass);
        progressBar=(ProgressBar) findViewById(R.id.prog);
        add=(Button) findViewById(R.id.add2);

        firebaseAuth= FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==add) {
            String vname;
            String vlastname;
            String vemail;
            String vphone;
            String vsubject;

            vname = name.getText().toString();
            vlastname = last_name.getText().toString();
            vemail = email.getText().toString();
            vphone = phone.getText().toString();
            vsubject = subject.getText().toString();

            DocumentReference documentReference= fstore.collection("teachers").document(vname+" "+ vlastname);
            Map<String,Object> teacher = new HashMap<>();

            teacher.put("name",vname);
            teacher.put("Last Name",vlastname);
            teacher.put("Email",vemail);
            teacher.put("Phone",vphone);
            teacher.put("Subject",vsubject);

            progressBar.setVisibility(View.VISIBLE);

            documentReference.set(teacher).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                    name.setText("");
                    last_name.setText("");
                    email.setText("");
                    phone.setText("");
                    subject.setText("");
                }
            });

        }
    }
}
