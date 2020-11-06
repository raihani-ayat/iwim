package com.example.iwim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class update_student extends AppCompatActivity implements View.OnClickListener {

    EditText name, last_name, email, phone, group;
    Button update;
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        name = (EditText) findViewById(R.id.stdname);
        last_name = (EditText) findViewById(R.id.stdlastname);
        email = (EditText) findViewById(R.id.stdemail);
        phone = (EditText) findViewById(R.id.stdnumtel);
        group = (EditText) findViewById(R.id.stdclass);
        update = (Button) findViewById(R.id.add2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        update.setOnClickListener(this);
        firebaseFirestore = FirebaseFirestore.getInstance();
        String usert = modify_student.stdname +" " + modify_student.std_lastname;

        final DocumentReference documentReference = firebaseFirestore.collection("students").document(usert);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                name.setText(documentSnapshot.getString("Name"));
                last_name.setText(documentSnapshot.getString("Last name"));
                email.setText(documentSnapshot.getString("Email"));
                phone.setText(documentSnapshot.getString("Phone number"));
                group.setText(documentSnapshot.getString("Class"));

            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v == update) {
            String vname, vlast_name, vemail, vphone, vgroup;
            vname = name.getText().toString().trim();
            vlast_name = last_name.getText().toString();
            vemail = email.getText().toString();
            vphone = phone.getText().toString();
            vgroup = group.getText().toString();
            DocumentReference documentReference = firebaseFirestore.collection("students").document(vname + " " + vlast_name);
            Map<String, Object> user = new HashMap<>();
            user.put("Name", vname);
            user.put("Last name", vlast_name);
            user.put("Email", vemail);
            user.put("Phone number", vphone);
            user.put("Class", vgroup);

            progressBar.setVisibility(View.VISIBLE);

            documentReference.update(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });


        }

    }
}

