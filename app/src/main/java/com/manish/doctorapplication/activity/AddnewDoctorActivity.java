package com.manish.doctorapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.fragment.DashboardFragment;
import com.manish.doctorapplication.fragment.DoctorEditProfileFragment;

public class AddnewDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_doctor);

        openDoctorEdit();

    }
    public void openDoctorEdit() {
        DoctorEditProfileFragment fragment = new DoctorEditProfileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.doctorEditFrameLayout, fragment);
        transaction.commit();

    }
}