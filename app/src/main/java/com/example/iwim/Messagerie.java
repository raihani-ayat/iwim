package com.example.iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Messagerie extends AppCompatActivity {

    private Button but1;
    private Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);

        but1= (Button) findViewById(R.id.kl);
        but2= (Button) findViewById(R.id.lk);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewMessage();
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInbox();
            }
        });


    }

    public void openNewMessage(){

        Intent int1 = new Intent(this, send_message.class);
        startActivity(int1);
    }

    public void openInbox(){

        Intent int2= new Intent(this,messages_received.class);
        startActivity(int2);
    }
}
