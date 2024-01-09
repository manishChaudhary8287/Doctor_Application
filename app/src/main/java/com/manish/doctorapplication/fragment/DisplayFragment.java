package com.manish.doctorapplication.fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.database.NewDatabase;


public class DisplayFragment extends Fragment {

    TextView doctor,name,phone,address,gender,age,des,pay,payment,date;



    @SuppressLint("Range")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_display, container, false);

        doctor=view.findViewById(R.id.doctor);
        name=view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        gender = view.findViewById(R.id.gender);
        age = view.findViewById(R.id.age);
        des = view.findViewById(R.id.des);
        pay= view.findViewById(R.id.pay);
        payment = view.findViewById(R.id.payment);
        date = view.findViewById(R.id.date2);

        NewDatabase db = new NewDatabase(container.getContext());

        Cursor cursor = db.getData();


        cursor.moveToFirst();

        do{
            doctor.append(cursor.getString(0)+"\n");
            name.append(cursor.getString(1)+"\n");
            phone.append(cursor.getString(2)+"\n");
            address.append(cursor.getString(3)+"\n");
            gender.append(cursor.getString(4)+"\n");
            age.append(cursor.getString(5)+"\n");
            des.append(cursor.getString(6)+"\n");
            pay.append(cursor.getString(7)+"\n");
            payment.append(cursor.getString(8)+"\n");
            date.append(cursor.getString(9)+"\n");
        }while(cursor.moveToNext());


        return view;
    }
}