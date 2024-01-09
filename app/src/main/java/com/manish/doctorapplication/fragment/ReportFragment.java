package com.manish.doctorapplication.fragment;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.adapter.ReportAdapter;
import com.manish.doctorapplication.database.NewDatabase;
import com.manish.doctorapplication.model.Patient;

import java.util.ArrayList;


public class ReportFragment extends Fragment {

    RecyclerView rvReport;
    ArrayList<Patient> reportDetails;
    TextView oneWeek, twoWeek, oneMonth, all;
    Button btnFilter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_report, container, false);

        btnFilter=view.findViewById(R.id.btnFilter);

        rvReport = view.findViewById(R.id.RVReport);
        reportDetails = new ArrayList<>();

        ReportAdapter ra = new ReportAdapter(container.getContext(), reportDetails);
        LinearLayoutManager linearLayout = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false);
        rvReport.setAdapter(ra);
        rvReport.setLayoutManager(linearLayout);

        NewDatabase db = new NewDatabase(container.getContext());
        Cursor cursor = db.getReportData();

        cursor.moveToFirst();

        reportDetails.clear();
        do {
            String doctor = cursor.getString(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            String pay = cursor.getString(3);
            String date = cursor.getString(4);

            Patient pat = new Patient(doctor, name, age, pay, date);
            reportDetails.add(pat);
        } while (cursor.moveToNext());


        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogBox();
            }
        });


        return view;
    }

    public void showAlertDialogBox(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog_layout,null);
        builder.setView(customLayout);

        oneWeek=customLayout.findViewById(R.id.txtweek1);
        twoWeek=customLayout.findViewById(R.id.txtweek2);
        oneMonth=customLayout.findViewById(R.id.txtmonth1);
        all=customLayout.findViewById(R.id.txtAll);

        oneWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border2,null));
                twoWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                oneMonth.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                all.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
            }
        });

        twoWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                twoWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border2,null));
                oneMonth.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                all.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
            }
        });
        oneMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                twoWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                oneMonth.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border2,null));
                all.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                twoWeek.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                oneMonth.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border,null));
                all.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.border2,null));
            }
        });


        builder.setPositiveButton("Done",(dialog,which) -> {
            builder.setCancelable(true);
                }
                );
        builder.setNegativeButton("Close",(dialog, which) -> {
            builder.setCancelable(true);
        });

        AlertDialog alert=builder.create();
        alert.show();
    }
}