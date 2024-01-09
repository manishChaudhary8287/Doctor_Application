package com.manish.doctorapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.model.Patient;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {
    private final Context context;
    private final List<Patient> reportlist;

    public ReportAdapter(Context context, List<Patient> reportlist){
        this.context=context;
        this.reportlist=reportlist;
    }
    @NonNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_report_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.ViewHolder holder, int position) {
    Patient item=reportlist.get(position);
    holder.name.setText(item.getName());
    holder.age.setText(item.getAge());
    holder.doc.setText(item.getDoctor());
    holder.price.setText(item.getPay());
    holder.date.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return reportlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,age,doc,price,date;
        public ViewHolder(@NonNull View view) {
            super(view);
            name=view.findViewById(R.id.txtName);
            age=view.findViewById(R.id.txtAge2);
            doc=view.findViewById(R.id.txtDoc);
            price=view.findViewById(R.id.txtPrice);
            date=view.findViewById(R.id.txtdate);
        }
    }

}
