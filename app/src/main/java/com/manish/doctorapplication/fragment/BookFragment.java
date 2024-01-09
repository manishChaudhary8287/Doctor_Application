package com.manish.doctorapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.manish.doctorapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BookFragment extends Fragment {

    private TextView doctor,name,age,phone,address,gender,payment,txtDate,des,pay,dateSelected,timeSlot;
    private Button btnDownload,btnWhatsapp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_book, container, false);

        doctor=view.findViewById(R.id.doctor);
        name=view.findViewById(R.id.name);
        phone=view.findViewById(R.id.phone);
        address=view.findViewById(R.id.address);
        gender=view.findViewById(R.id.gender);
        age=view.findViewById(R.id.age);
        txtDate=view.findViewById(R.id.date);
        des=view.findViewById(R.id.des);
        payment=view.findViewById(R.id.payment1);
        pay=view.findViewById(R.id.bill);
        dateSelected=view.findViewById(R.id.selectedBookdate);
        timeSlot=view.findViewById(R.id.timeSlot);


        Bundle bundle=getArguments();

        if (bundle != null) {
            doctor.setText("Doctor :  " + bundle.getString("doctor"));
            name.setText("Patient : " + bundle.getString("name"));
            phone.setText("Phone : " + bundle.getString("phone"));
            gender.setText("Gender : " + bundle.getString("gender"));
            address.setText("Address : " + bundle.getString("address"));
            txtDate.setText("Date : " + bundle.getString("currentDate"));
            age.setText("Age : " + bundle.getString("age"));
            pay.setText("Amount Paid : "+bundle.getString("pay"));
            des.setText("Description  : " + bundle.getString("des"));
            payment.setText("Payment Mode : " + bundle.getString("payment"));
            dateSelected.setText("Appointment Date : "+bundle.getString("customDate"));
            timeSlot.setText("Time Slot : "+bundle.getString("timeSlot"));
        }

        return view;
    }
}