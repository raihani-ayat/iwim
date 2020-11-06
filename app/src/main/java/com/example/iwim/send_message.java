package com.example.iwim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class send_message extends AppCompatActivity implements View.OnClickListener {

    private EditText message,subject,recipient;
    private Button send;
    private Button inbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        message=(EditText) findViewById(R.id.message);
        subject=(EditText) findViewById(R.id.subject);
        recipient=(EditText) findViewById(R.id.recipients);

        send=(Button) findViewById(R.id.button_send);
        inbox=(Button) findViewById(R.id.button4);

        send.setOnClickListener(this);
        inbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         if(v==inbox){
            startActivity(new Intent(this,messages_received.class));
         }
         if(v==send){
             String recipients = recipient.getText().toString();
             String[] Recipients =recipients.split(",");
             String mmessage= message.getText().toString();
             String msubject= subject.getText().toString();

             Intent intent = new Intent(Intent.ACTION_SEND);
             intent.putExtra(Intent.EXTRA_EMAIL,Recipients);
             intent.putExtra(Intent.EXTRA_SUBJECT,msubject);
             intent.putExtra(Intent.EXTRA_TEXT,mmessage);

             intent.setType("message/rfc822");
             startActivity(Intent.createChooser(intent,"Choose email app"));

         }

    }
}
