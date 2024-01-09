package com.manish.doctorapplication.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.manish.doctorapplication.R;


public class DashboardFragment extends Fragment {

    CardView token,appointment,test,report,medicines,billing;
    TextView txtCurrent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);

        token=view.findViewById(R.id.cardToken);
        appointment=view.findViewById(R.id.cardAppoint);
        test=view.findViewById(R.id.cardTest);
        report=view.findViewById(R.id.cardReport);
        medicines=view.findViewById(R.id.cardMedicines);
        billing=view.findViewById(R.id.cardBilling);
        txtCurrent=view.findViewById(R.id.txtcurrent);

        txtCurrent.setSelected(true);

        NavigationView filNavi=requireActivity().findViewById(R.id.filterNavi);

        token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.GONE);
                FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,new TokenFragment()).commit();
            }
        });

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.GONE);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.frameLayout,new AppointmentFragment()).commit();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.GONE);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout,new TestFragment()).commit();
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.VISIBLE);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.frameLayout,new ReportFragment()).commit();
            }
        });

        medicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.GONE);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.frameLayout,new MedicineFragment()).commit();
            }
        });

        billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filNavi.setVisibility(View.GONE);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.frameLayout,new DisplayFragment()).commit();
            }
        });



        return view;
    }
}