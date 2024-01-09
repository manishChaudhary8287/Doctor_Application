package com.manish.doctorapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.manish.doctorapplication.R;

public class DoctorLoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etUsername,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        btnLogin=findViewById(R.id.btnLoginDoctor);
        etUsername=findViewById(R.id.etUsernameDoctor);
        etPass=findViewById(R.id.etPasswordDoctor);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=etUsername.getText().toString();
                String pass=etPass.getText().toString();
                if((username.equalsIgnoreCase("doctor@admin.com")) && pass.equals("doctor123")){
                    Intent intent=new Intent(DoctorLoginActivity.this, DoctorActivity.class);
                    Toast.makeText(DoctorLoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(DoctorLoginActivity.this, "Login for Doctor failed", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

    }
}