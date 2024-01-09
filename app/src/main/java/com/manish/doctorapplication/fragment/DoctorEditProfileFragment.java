package com.manish.doctorapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.database.DoctorDatabase;


public class DoctorEditProfileFragment extends Fragment {

    EditText name,special,cost,phone,address;
    ImageView imgAddDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_doctor_edit_profile, container, false);

        name=view.findViewById(R.id.enterdoc);
        special=view.findViewById(R.id.enterSpec);
        cost=view.findViewById(R.id.enterPrice);
        phone=view.findViewById(R.id.enterPhone);
        address=view.findViewById(R.id.enterAddress);
        imgAddDetails=view.findViewById(R.id.imgAdd);

        imgAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String docName,docSpecial,docCost,docPhone,docAddress;
            docName=name.getText().toString();
            docSpecial=special.getText().toString();
            docCost=cost.getText().toString();
            docPhone=phone.getText().toString();
            docAddress=address.getText().toString();
                DoctorDatabase db2 = new DoctorDatabase(container.getContext());
                boolean res = db2.addDoctor(docName,docSpecial,docCost,docPhone,docAddress);
                if(res){
                    Toast.makeText(getContext(), "Doctor added to the database", Toast.LENGTH_SHORT).show();
                    name.getText().clear();
                    special.getText().clear();
                    cost.getText().clear();
                    phone.getText().clear();
                    address.getText().clear();
                }
                else {
                    Toast.makeText(getContext(),"Failed to add to database",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}