package com.example.iwim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class Schedule_chief extends AppCompatActivity implements View.OnClickListener {
EditText m_r1,m_r2,m_r3,m_r4,m_s1,m_s2,m_s3,m_s4,m_t1,m_t2,m_t3,m_t4;
EditText t_r1,t_r2,t_r3,t_r4,t_s1,t_s2,t_s3,t_s4,t_t1,t_t2,t_t3,t_t4;
EditText w_r1,w_r2,w_r3,w_r4,w_s1,w_s2,w_s3,w_s4,w_t1,w_t2,w_t3,w_t4;
EditText tt_r1,tt_r2,tt_r3,tt_r4,tt_s1,tt_s2,tt_s3,tt_s4,tt_t1,tt_t2,tt_t3,tt_t4;
EditText f_r1,f_r2,f_r3,f_r4,f_s1,f_s2,f_s3,f_s4,f_t1,f_t2,f_t3,f_t4;
EditText week,periode;
Button update;
FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_chief);

        m_r1=(EditText) findViewById(R.id.m_r1);
        m_r2=(EditText) findViewById(R.id.m_r2);
        m_r3=(EditText) findViewById(R.id.m_r3);
        m_r4=(EditText) findViewById(R.id.m_r4);
        m_s1=(EditText) findViewById(R.id.m_s1);
        m_s2=(EditText) findViewById(R.id.m_s2);
        m_s3=(EditText) findViewById(R.id.m_s3);
        m_s4=(EditText) findViewById(R.id.m_s4);
        m_t1=(EditText) findViewById(R.id.m_t1);
        m_t2=(EditText) findViewById(R.id.m_t2);
        m_t3=(EditText) findViewById(R.id.m_t3);
        m_t4=(EditText) findViewById(R.id.m_t4);

        t_r1=(EditText) findViewById(R.id.t_r1);
        t_r2=(EditText) findViewById(R.id.t_r2);
        t_r3=(EditText) findViewById(R.id.t_r3);
        t_r4=(EditText) findViewById(R.id.t_r4);
        t_s1=(EditText) findViewById(R.id.t_s1);
        t_s2=(EditText) findViewById(R.id.t_s2);
        t_s3=(EditText) findViewById(R.id.t_s3);
        t_s4=(EditText) findViewById(R.id.t_s4);
        t_t1=(EditText) findViewById(R.id.t_t1);
        t_t2=(EditText) findViewById(R.id.t_t2);
        t_t3=(EditText) findViewById(R.id.t_t3);
        t_t4=(EditText) findViewById(R.id.t_t4);

        w_r1=(EditText) findViewById(R.id.w_r1);
        w_r2=(EditText) findViewById(R.id.w_r2);
        w_r3=(EditText) findViewById(R.id.w_r3);
        w_r4=(EditText) findViewById(R.id.w_r4);
        w_s1=(EditText) findViewById(R.id.w_s1);
        w_s2=(EditText) findViewById(R.id.w_s2);
        w_s3=(EditText) findViewById(R.id.w_s3);
        w_s4=(EditText) findViewById(R.id.w_s4);
        w_t1=(EditText) findViewById(R.id.w_t1);
        w_t2=(EditText) findViewById(R.id.w_t2);
        w_t3=(EditText) findViewById(R.id.w_t3);
        w_t4=(EditText) findViewById(R.id.w_t4);


        tt_r1=(EditText) findViewById(R.id.tt_r1);
        tt_r2=(EditText) findViewById(R.id.tt_r2);
        tt_r3=(EditText) findViewById(R.id.tt_r3);
        tt_r4=(EditText) findViewById(R.id.tt_r4);
        tt_s1=(EditText) findViewById(R.id.tt_s1);
        tt_s2=(EditText) findViewById(R.id.tt_s2);
        tt_s3=(EditText) findViewById(R.id.tt_s3);
        tt_s4=(EditText) findViewById(R.id.tt_s4);
        tt_t1=(EditText) findViewById(R.id.tt_t1);
        tt_t2=(EditText) findViewById(R.id.tt_t2);
        tt_t3=(EditText) findViewById(R.id.tt_t3);
        tt_t4=(EditText) findViewById(R.id.tt_t4);

        f_r1=(EditText) findViewById(R.id.f_r1);
        f_r2=(EditText) findViewById(R.id.f_r2);
        f_r3=(EditText) findViewById(R.id.f_r3);
        f_r4=(EditText) findViewById(R.id.f_r4);
        f_s1=(EditText) findViewById(R.id.f_s1);
        f_s2=(EditText) findViewById(R.id.f_s2);
        f_s3=(EditText) findViewById(R.id.f_s3);
        f_s4=(EditText) findViewById(R.id.f_s4);
        f_t1=(EditText) findViewById(R.id.f_t1);
        f_t2=(EditText) findViewById(R.id.f_t2);
        f_t3=(EditText) findViewById(R.id.f_t3);
        f_t4=(EditText) findViewById(R.id.f_t4);

        week=(EditText) findViewById(R.id.week);
        periode=(EditText) findViewById(R.id.semestre);

        firebaseFirestore=FirebaseFirestore.getInstance();

        update=(Button) findViewById(R.id.update_it);

        DocumentReference documentReference= firebaseFirestore.collection("Schedule").document("Week");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
               week.setText(documentSnapshot.getString("numero"));
            }
        });

        DocumentReference documentSemestre= firebaseFirestore.collection("Schedule").document("semestre_periode");
        documentSemestre.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                periode.setText(documentSnapshot.getString("reference"));
            }
        });
        //Friday

        DocumentReference f1= firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance1");
        f1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                f_s1.setText(documentSnapshot.getString("subject"));
                f_t1.setText(documentSnapshot.getString("tutor"));
                f_r1.setText(documentSnapshot.getString("room"));
            }
        });
        DocumentReference f2= firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seanace2");
        f2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                f_s2.setText(documentSnapshot.getString("subject"));
                f_t2.setText(documentSnapshot.getString("tutor"));
                f_r2.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference f3= firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance3");
        f3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                f_s3.setText(documentSnapshot.getString("subject"));
                f_t3.setText(documentSnapshot.getString("tutor"));
                f_r3.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference f4= firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance4");
        f4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                f_s4.setText(documentSnapshot.getString("subject"));
                f_t4.setText(documentSnapshot.getString("tutor"));
                f_r4.setText(documentSnapshot.getString("room"));
            }
        });

        //monday

        DocumentReference m1= firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance1");
        m1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                m_s1.setText(documentSnapshot.getString("subject"));
                m_t1.setText(documentSnapshot.getString("tutor"));
                m_r1.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference m2= firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance2");
        m2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                m_s2.setText(documentSnapshot.getString("subject"));
                m_t2.setText(documentSnapshot.getString("tutor"));
                m_r2.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference m3= firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance3");
        m3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                m_s3.setText(documentSnapshot.getString("subject"));
                m_t3.setText(documentSnapshot.getString("tutor"));
                m_r3.setText(documentSnapshot.getString("room"));
            }
        });
        DocumentReference m4= firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance4");
        m4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                m_s4.setText(documentSnapshot.getString("subject"));
                m_t4.setText(documentSnapshot.getString("tutor"));
                m_r4.setText(documentSnapshot.getString("room"));
            }
        });

        //tuesday

        DocumentReference t1= firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance1");
        t1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t_s1.setText(documentSnapshot.getString("subject"));
                t_t1.setText(documentSnapshot.getString("tutor"));
                t_r1.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference t2= firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance2");
        t2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t_s2.setText(documentSnapshot.getString("subject"));
                t_t2.setText(documentSnapshot.getString("tutor"));
                t_r2.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference t3= firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance3");
        t3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t_s3.setText(documentSnapshot.getString("subject"));
                t_t3.setText(documentSnapshot.getString("tutor"));
                t_r3.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference t4= firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance4");
        t4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                t_s4.setText(documentSnapshot.getString("subject"));
                t_t4.setText(documentSnapshot.getString("tutor"));
                t_r4.setText(documentSnapshot.getString("room"));
            }
        });
        //Thursday

        DocumentReference tt1= firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance1");
        tt1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                tt_s1.setText(documentSnapshot.getString("subject"));
                tt_t1.setText(documentSnapshot.getString("tutor"));
                tt_r1.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference tt2= firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance2");
        tt2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                tt_s2.setText(documentSnapshot.getString("subject"));
                tt_t2.setText(documentSnapshot.getString("tutor"));
                tt_r2.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference tt3= firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance3");
        tt3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                tt_s3.setText(documentSnapshot.getString("subject"));
                tt_t3.setText(documentSnapshot.getString("tutor"));
                tt_r3.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference tt4= firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance4");
        tt4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                tt_s4.setText(documentSnapshot.getString("subject"));
                tt_t4.setText(documentSnapshot.getString("tutor"));
                tt_r4.setText(documentSnapshot.getString("room"));
            }
        });

        //wednesday

        DocumentReference w1= firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance1");
        w1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                w_s1.setText(documentSnapshot.getString("subject"));
                w_t1.setText(documentSnapshot.getString("tutor"));
                w_r1.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference w2= firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance2");
        w2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                w_s2.setText(documentSnapshot.getString("subject"));
                w_t2.setText(documentSnapshot.getString("tutor"));
                w_r2.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference w3= firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance3");
        w3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                w_s3.setText(documentSnapshot.getString("subject"));
                w_t3.setText(documentSnapshot.getString("tutor"));
                w_r3.setText(documentSnapshot.getString("room"));
            }
        });

        DocumentReference w4= firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance4");
        w4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                w_s4.setText(documentSnapshot.getString("subject"));
                w_t4.setText(documentSnapshot.getString("tutor"));
                w_r4.setText(documentSnapshot.getString("room"));
            }
        });



        update.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==update){
            String vm_r1,vm_r2,vm_r3,vm_r4,vm_s1,vm_s2,vm_s3,vm_s4,vm_t1,vm_t2,vm_t3,vm_t4;
            String vt_r1,vt_r2,vt_r3,vt_r4,vt_s1,vt_s2,vt_s3,vt_s4,vt_t1,vt_t2,vt_t3,vt_t4;
            String vw_r1,vw_r2,vw_r3,vw_r4,vw_s1,vw_s2,vw_s3,vw_s4,vw_t1,vw_t2,vw_t3,vw_t4;
            String vtt_r1,vtt_r2,vtt_r3,vtt_r4,vtt_s1,vtt_s2,vtt_s3,vtt_s4,vtt_t1,vtt_t2,vtt_t3,vtt_t4;
            String vf_r1,vf_r2,vf_r3,vf_r4,vf_s1,vf_s2,vf_s3,vf_s4,vf_t1,vf_t2,vf_t3,vf_t4;
            String vsemestre, vweek;

            vm_s1=m_s1.getText().toString();
            vm_s2=m_s2.getText().toString();
            vm_s3=m_s3.getText().toString();
            vm_s4=m_s4.getText().toString();
            vm_t1=m_t1.getText().toString();
            vm_t2=m_t2.getText().toString();
            vm_t3=m_t3.getText().toString();
            vm_t4=m_t4.getText().toString();
            vm_r1=m_r1.getText().toString();
            vm_r2=m_r2.getText().toString();
            vm_r3=m_r3.getText().toString();
            vm_r4=m_r4.getText().toString();

            vt_s1=t_s1.getText().toString();
            vt_s2=t_s2.getText().toString();
            vt_s3=t_s3.getText().toString();
            vt_s4=t_s4.getText().toString();
            vt_t1=t_t1.getText().toString();
            vt_t2=t_t2.getText().toString();
            vt_t3=t_t3.getText().toString();
            vt_t4=t_t4.getText().toString();
            vt_r1=t_r1.getText().toString();
            vt_r2=t_r2.getText().toString();
            vt_r3=t_r3.getText().toString();
            vt_r4=t_r4.getText().toString();

            vtt_s1=tt_s1.getText().toString();
            vtt_s2=tt_s2.getText().toString();
            vtt_s3=tt_s3.getText().toString();
            vtt_s4=tt_s4.getText().toString();
            vtt_t1=tt_t1.getText().toString();
            vtt_t2=tt_t2.getText().toString();
            vtt_t3=tt_t3.getText().toString();
            vtt_t4=tt_t4.getText().toString();
            vtt_r1=tt_r1.getText().toString();
            vtt_r2=tt_r2.getText().toString();
            vtt_r3=tt_r3.getText().toString();
            vtt_r4=tt_r4.getText().toString();

            vw_s1=w_s1.getText().toString();
            vw_s2=w_s2.getText().toString();
            vw_s3=w_s3.getText().toString();
            vw_s4=w_s4.getText().toString();
            vw_t1=w_t1.getText().toString();
            vw_t2=w_t2.getText().toString();
            vw_t3=w_t3.getText().toString();
            vw_t4=w_t4.getText().toString();
            vw_r1=w_r1.getText().toString();
            vw_r2=w_r2.getText().toString();
            vw_r3=w_r3.getText().toString();
            vw_r4=w_r4.getText().toString();

            vf_s1=f_s1.getText().toString();
            vf_s2=f_s2.getText().toString();
            vf_s3=f_s3.getText().toString();
            vf_s4=f_s4.getText().toString();
            vf_t1=f_t1.getText().toString();
            vf_t2=f_t2.getText().toString();
            vf_t3=f_t3.getText().toString();
            vf_t4=f_t4.getText().toString();
            vf_r1=f_r1.getText().toString();
            vf_r2=f_r2.getText().toString();
            vf_r3=f_r3.getText().toString();
            vf_r4=f_r4.getText().toString();

            vweek= week.getText().toString();
            vsemestre= periode.getText().toString();

            DocumentReference vf1=firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance1");
            Map<String,Object> seancef1 = new HashMap<>();
            seancef1.put("room",vf_r1);
            seancef1.put("subject",vf_s1);
            seancef1.put("tutor",vf_t1);
            vf1.update(seancef1);

            DocumentReference vf2=firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seanace2");
            Map<String,Object> seancef2 = new HashMap<>();
            seancef2.put("room",vf_r2);
            seancef2.put("subject",vf_s2);
            seancef2.put("tutor",vf_t2);
            vf2.update(seancef2);

            DocumentReference vf3=firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance3");
            Map<String,Object> seancef3 = new HashMap<>();
            seancef3.put("room",vf_r3);
            seancef3.put("subject",vf_s3);
            seancef3.put("tutor",vf_t3);
            vf3.update(seancef3);

            DocumentReference vf4=firebaseFirestore.collection("Schedule").document("day").collection("Friday").document("seance4");
            Map<String,Object> seancef4 = new HashMap<>();
            seancef4.put("room",vf_r4);
            seancef4.put("subject",vf_s4);
            seancef4.put("tutor",vf_t4);
            vf4.update(seancef4);

            DocumentReference vtt4=firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance4");
            Map<String,Object> seancett4 = new HashMap<>();
            seancett4.put("room",vtt_r4);
            seancett4.put("subject",vtt_s4);
            seancett4.put("tutor",vtt_t4);
            vtt4.update(seancett4);

            DocumentReference vtt3=firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance3");
            Map<String,Object> seancett3 = new HashMap<>();
            seancett3.put("room",vtt_r3);
            seancett3.put("subject",vtt_s3);
            seancett3.put("tutor",vtt_t3);
            vtt3.update(seancett3);

            DocumentReference vtt2=firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance2");
            Map<String,Object> seancett2 = new HashMap<>();
            seancett2.put("room",vtt_r2);
            seancett2.put("subject",vtt_s2);
            seancett2.put("tutor",vtt_t2);
            vtt2.update(seancett2);

            DocumentReference vtt1=firebaseFirestore.collection("Schedule").document("day").collection("thursday").document("seance1");
            Map<String,Object> seancett1 = new HashMap<>();
            seancett1.put("room",vtt_r1);
            seancett1.put("subject",vtt_s1);
            seancett1.put("tutor",vtt_t1);
            vtt1.update(seancett1);

            DocumentReference vw1=firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance1");
            Map<String,Object> seancew1 = new HashMap<>();
            seancew1.put("room",vw_r1);
            seancew1.put("subject",vw_s1);
            seancew1.put("tutor",vw_t1);
            vw1.update(seancew1);

            DocumentReference vw2=firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance2");
            Map<String,Object> seancew2 = new HashMap<>();
            seancew2.put("room",vw_r2);
            seancew2.put("subject",vw_s2);
            seancew2.put("tutor",vw_t2);
            vw2.update(seancew2);

            DocumentReference vw3=firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance3");
            Map<String,Object> seancew3 = new HashMap<>();
            seancew3.put("room",vw_r3);
            seancew3.put("subject",vw_s3);
            seancew3.put("tutor",vw_t3);
            vw3.update(seancew3);

            DocumentReference vw4=firebaseFirestore.collection("Schedule").document("day").collection("wednesday").document("seance4");
            Map<String,Object> seancew4 = new HashMap<>();
            seancew4.put("room",vw_r4);
            seancew4.put("subject",vw_s4);
            seancew4.put("tutor",vw_t4);
            vw4.update(seancew4);

            DocumentReference vt1=firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance1");
            Map<String,Object> seancet1 = new HashMap<>();
            seancet1.put("room",vt_r1);
            seancet1.put("subject",vt_s1);
            seancet1.put("tutor",vt_t1);
            vt1.update(seancet1);

            DocumentReference vt2=firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance2");
            Map<String,Object> seancet2 = new HashMap<>();
            seancet2.put("room",vt_r2);
            seancet2.put("subject",vt_s2);
            seancet2.put("tutor",vt_t2);
            vt2.update(seancet2);

            DocumentReference vt3=firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance3");
            Map<String,Object> seancet3 = new HashMap<>();
            seancet3.put("room",vt_r3);
            seancet3.put("subject",vt_s3);
            seancet3.put("tutor",vt_t3);
            vt3.update(seancet3);

            DocumentReference vt4=firebaseFirestore.collection("Schedule").document("day").collection("tuesday").document("seance4");
            Map<String,Object> seancet4= new HashMap<>();
            seancet4.put("room",vt_r4);
            seancet4.put("subject",vt_s4);
            seancet4.put("tutor",vt_t4);
            vt4.update(seancet4);

            DocumentReference vm1=firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance1");
            Map<String,Object> seancem1 = new HashMap<>();
            seancem1.put("room",vm_r1);
            seancem1.put("subject",vm_s1);
            seancem1.put("tutor",vm_t1);
            vm1.update(seancem1);

            DocumentReference vm2=firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance2");
            Map<String,Object> seancem2 = new HashMap<>();
            seancem2.put("room",vm_r2);
            seancem2.put("subject",vm_s2);
            seancem2.put("tutor",vm_t2);
            vm2.update(seancem2);

            DocumentReference vm3=firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance3");
            Map<String,Object> seancem3 = new HashMap<>();
            seancem3.put("room",vm_r3);
            seancem3.put("subject",vm_s3);
            seancem3.put("tutor",vm_t3);
            vm3.update(seancem3);

            DocumentReference vm4=firebaseFirestore.collection("Schedule").document("day").collection("monday").document("seance4");
            Map<String,Object> seancem4 = new HashMap<>();
            seancem4.put("room",vm_r4);
            seancem4.put("subject",vm_s4);
            seancem4.put("tutor",vm_t4);
            vm4.update(seancem4);

            DocumentReference docWeek = firebaseFirestore.collection("Schedule").document("Week");
            Map<String,Object> wk= new HashMap<>();
            wk.put("numero",vweek);
            docWeek.update(wk);

            DocumentReference docsem = firebaseFirestore.collection("Schedule").document("semestre_periode");
            Map<String,Object> sem= new HashMap<>();
            sem.put("reference",vsemestre);
            docsem.update(sem);
        }

    }
}
