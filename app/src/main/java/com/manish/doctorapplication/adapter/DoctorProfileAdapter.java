package com.manish.doctorapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.model.Doctor;

import java.util.List;

public class DoctorProfileAdapter extends RecyclerView.Adapter<DoctorProfileAdapter.Viewholder> {

    private final Context context;
    private final List<Doctor> doclist;
    public DoctorProfileAdapter(Context context, List<Doctor> doclist){
        this.context=context;
        this.doclist=doclist;
    }
    @NonNull
    @Override
    public DoctorProfileAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_doctor_profile,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorProfileAdapter.Viewholder holder, int position) {
        Doctor item=doclist.get(position);
        holder.doctor.setText(item.getDoctor());
        holder.spec.setText(item.getSpec());
        holder.price.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return doclist.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder{
        TextView doctor,spec,price;
        public Viewholder(View view){
            super(view);
            doctor=view.findViewById(R.id.txtName1);
            spec=view.findViewById(R.id.txtSpecial);
            price=view.findViewById(R.id.txtPrice2);
        }
    }
}
