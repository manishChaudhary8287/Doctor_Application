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
import com.google.firebase.auth.FirebaseUser;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.model.RegisterPatient;

public class PatientRegisterActivity extends AppCompatActivity {

    Button register;
    TextView login;
    FirebaseAuth mAuth;
    EditText etName,etEmail,etPass,etCpass,etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        register=findViewById(R.id.btnregisterPatientRegister);
        login=findViewById(R.id.txtloginPatientRegister);
        etName=findViewById(R.id.etNamePatientRegister);
        etEmail=findViewById(R.id.etUsernamePatientRegister);
        etPass=findViewById(R.id.etPasswordPatientRegister);
        etCpass=findViewById(R.id.etConfirmPasswordPatientRegister);
        etPhone=findViewById(R.id.etNumberPatientRegister);

        mAuth=FirebaseAuth.getInstance();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkAllFields() && checkPass()){
                    String name=etName.getText().toString();
                    String email=etEmail.getText().toString();
                    String pass=etPass.getText().toString();

                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent=new Intent(PatientRegisterActivity.this, MainActivity.class);
                                Toast.makeText(PatientRegisterActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(PatientRegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PatientRegisterActivity.this, PatientLoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private boolean checkAllFields(){
        if(etName.length()==0||etEmail.length()==0||etPass.length()==0||etCpass.length()==0){
            if(etName.length()==0){
                etName.setError("Enter Name");
            }
            if(etEmail.length()==0){
                etEmail.setError("Enter Email");
            }
            if(etPass.length()==0){
                etPass.setError("Enter Password");
            }
            if(etCpass.length()==0){
                etCpass.setError("Enter Confirm Password");
            }
            return false;
        }
        else{
            return true;
        }
    }

    private boolean checkPass(){
        String tempPass=String.valueOf(etPass.getText());
        String tempCPass=String.valueOf(etCpass.getText());
        if(!tempPass.equals(tempCPass)){
            Toast.makeText(PatientRegisterActivity.this,"Password and Confirm Password must be same.",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }
}