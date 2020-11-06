package com.example.iwim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class messages_received extends AppCompatActivity {
    private Button new_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_received);
        new_msg=(Button) findViewById(R.id.button5);
        new_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_new_msg();
            }
        });
    }

    public void open_new_msg(){
        Intent int24= new Intent(this, send_message.class);
        startActivity(int24);
    }
}
