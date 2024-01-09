package com.manish.doctorapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.database.NewDatabase;


public class TokenFragment extends Fragment {

        TextView tokenGenerated;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_token, container, false);

        NewDatabase db = new NewDatabase(container.getContext());

        tokenGenerated=view.findViewById(R.id.txtTotalgenerated);
        int a = db.getCount();
        String ab = String.valueOf(a);
        tokenGenerated.setText(ab);

        return view;
    }
}