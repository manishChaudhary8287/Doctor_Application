package com.manish.doctorapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.manish.doctorapplication.R;

public class UserActivity extends AppCompatActivity {

    CardView doctor,patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        doctor=findViewById(R.id.doctor);
        patient=findViewById(R.id.patient);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(UserActivity.this, DoctorLoginActivity.class);
                startActivity(intent);
            }
        });
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this, PatientLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}