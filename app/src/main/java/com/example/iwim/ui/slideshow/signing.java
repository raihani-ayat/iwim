package com.example.iwim.ui.slideshow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iwim.R;
import com.example.iwim.userActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signing extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    private EditText email;
    private EditText password;
    private Button login;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);

        email=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        progressDialog= new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();
    }


    public void open_users(){
        Intent intent= new Intent(this, userActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        if(v==login){
            String em= email.getText().toString().trim();
            String ps= password.getText().toString().trim();

            if(TextUtils.isEmpty(em)){
                Toast.makeText(this,"please enter email",Toast.LENGTH_LONG).show();
            }

            if(TextUtils.isEmpty(ps)){
                Toast.makeText(this,"please enter password",Toast.LENGTH_LONG).show();
            }

                progressDialog.setMessage("Login...");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(em,ps).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            open_users();
                        }
                    }
                });
        }

    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getKeyCode()==4){
            finish();
        }
        return false;
    }
}









