package com.manish.doctorapplication.fragment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.adapter.DoctorProfileAdapter;
import com.manish.doctorapplication.database.DoctorDatabase;
import com.manish.doctorapplication.model.Doctor;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    RecyclerView rvProfile;
    ArrayList<Doctor> doctorDetails;
    TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        txt=view.findViewById(R.id.floatingText);
        txt.setSelected(true);

        rvProfile=view.findViewById(R.id.RecyclerDoctor);
        doctorDetails=new ArrayList<>();

        DoctorProfileAdapter dpa  = new DoctorProfileAdapter(container.getContext(),doctorDetails);
        LinearLayoutManager linearLayout = new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false);

        rvProfile.setAdapter(dpa);
        rvProfile.setLayoutManager(linearLayout);

        DoctorDatabase db2 = new DoctorDatabase(container.getContext());
        Cursor cursor = db2.getDoctorProfile();
        cursor.moveToFirst();
        doctorDetails.clear();

        do{
            String docName = cursor.getString(0);
            String docSpecial = cursor.getString(1);
            String docCost = cursor.getString(2);

            Doctor docList = new Doctor(docName,docSpecial,docCost);
            doctorDetails.add(docList);
        }while (cursor.moveToNext());


        return view;
    }
}