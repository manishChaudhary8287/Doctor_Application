package com.manish.doctorapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.fragment.DoctorEditProfileFragment;

public class DoctorActivity extends AppCompatActivity {

    TextView editDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        editDoc=findViewById(R.id.txteditdoc);

        editDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DoctorActivity.this,AddnewDoctorActivity.class);
                startActivity(intent);

            }
        });

    }
}