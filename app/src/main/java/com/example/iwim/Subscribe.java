package com.example.iwim;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Subscribe extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button subs;
    private EditText emaill;
    private EditText pswrd;
    private ProgressDialog pd;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        firebaseAuth=FirebaseAuth.getInstance();
        pd= new ProgressDialog(this);

        subs=(Button) findViewById(R.id.button9);
        emaill=(EditText) findViewById(R.id.editText12);
        pswrd=(EditText)findViewById(R.id.editText13);

        subs.setOnClickListener(this);
    }

    private void register_user(){
        String email=emaill.getText().toString().trim();
        String password =pswrd.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //if email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //if password is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        // if the fields are not empty
        pd.setMessage("Registering user...");
        pd.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "User successfully registered ", Toast.LENGTH_LONG).show();
                    go_to_user();
                }
            }
        });

    }
    public void go_to_user(){

        Intent int1 = new Intent(this,userActivity.class);
        startActivity(int1);
    }

    @Override
    public void onClick(View v) {
        if(v==subs){
            register_user();
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
