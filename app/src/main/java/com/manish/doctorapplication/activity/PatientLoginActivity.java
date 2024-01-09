package com.manish.doctorapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.manish.doctorapplication.R;

public class PatientLoginActivity extends AppCompatActivity {

    Button login;
    TextView register;
    FirebaseAuth mAuth;
    EditText etEmail,etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        login=findViewById(R.id.btnLoginPatientLogin);
        register=findViewById(R.id.newPatient);
        etEmail=findViewById(R.id.etUsernamePatientLogin);
        etPass=findViewById(R.id.etPasswordPatientLogin);

        mAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail.getText().toString();
                String pass=etPass.getText().toString();
                if(checkAllFields()){
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent=new Intent(PatientLoginActivity.this, MainActivity.class);
                                Toast.makeText(PatientLoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(PatientLoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

               
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PatientLoginActivity.this, PatientRegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private boolean checkAllFields(){
        if(etEmail.length()==0||etPass.length()==0){
            if(etEmail.length()==0){
                etEmail.setError("Enter Email");
            }
            if(etPass.length()==0){
                etPass.setError("Enter Password");
            }
            return false;
        }
        else{
            return true;
        }
    }
}