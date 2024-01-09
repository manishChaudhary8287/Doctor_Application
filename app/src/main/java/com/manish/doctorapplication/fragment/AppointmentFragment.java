package com.manish.doctorapplication.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.manish.doctorapplication.R;
import com.manish.doctorapplication.database.DoctorDatabase;
import com.manish.doctorapplication.database.NewDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class AppointmentFragment extends Fragment {

    Button btnBook,btnSelectDate;
    EditText etName,etPhone,etAge,etAddress,etDes;
    RadioGroup rgGender,rgPayment;
    Spinner spin,timeSlot;
    String docSelect,timeSelected;
    ArrayList<String> docList;
    ArrayList<String> timeList;
    TextView txtSelectedDate;
    int id=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_appointment, container, false);

        btnBook=view.findViewById(R.id.btnBook);
        etName=view.findViewById(R.id.etName);
        etPhone=view.findViewById(R.id.etPhone);
        etAddress=view.findViewById(R.id.etAddress);
        etAge=view.findViewById(R.id.etAge);
        etDes=view.findViewById(R.id.etDes);
        rgGender=view.findViewById(R.id.rgGender);
        spin=view.findViewById(R.id.spinner);
        rgPayment=view.findViewById(R.id.rgPayment);
        timeSlot=view.findViewById(R.id.timeSlotList);
        btnSelectDate=view.findViewById(R.id.btnSelectDate);
        txtSelectedDate=view.findViewById(R.id.selectedDate);

        timeList=new ArrayList<>();
        timeList.add("slot 1: 10:00 AM - 12:00 PM");
        timeList.add("slot 2: 02:00 PM - 04:00 PM");
        timeList.add("slot 3: 07:00 PM - 10:00 PM");



        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String currentDate=sdf.format(new Date());

        docList=new ArrayList<String>();

        DoctorDatabase db2= new DoctorDatabase(container.getContext());
        Cursor cursor=db2.getDoctors();
        cursor.moveToFirst();
        docList.clear();


        do{
            String temp=cursor.getString(0);
            docList.add(temp);
        }while(cursor.moveToNext());
        System.out.println("Doctors List : "+docList);

//        String[] doc ={"1 Doctor","2 Doctor","3 Doctor","4 Doctor","5 Doctor"};

        ArrayAdapter ad=new ArrayAdapter(container.getContext(),R.layout.my_spinner_layout,docList);
        ArrayAdapter timeAdapter= new ArrayAdapter(container.getContext(),R.layout.my_spinner_layout,timeList);
        spin.setAdapter(ad);
        timeSlot.setAdapter(timeAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                docSelect = docList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Nothing to do here for now.
            }
        });

        timeSlot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                timeSelected=timeList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Nothing to do  here for now.
            }
        });

        NewDatabase db = new NewDatabase(container.getContext());

        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        container.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txtSelectedDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkedField()){
                String doctor,name,age,phone,address,gender,pay,des,payment,time,customDate;
                doctor= docSelect;
                name=etName.getText().toString();
                age=etAge.getText().toString();
                phone=etPhone.getText().toString();
                address=etAddress.getText().toString();
                des=etDes.getText().toString();
                gender=radioGender();
                payment=radioPayment();
                customDate=txtSelectedDate.getText().toString();
                time=timeSelected;
                pay="00";
                id++;
                BookFragment bookFragment=new BookFragment();
                Bundle bundle=new Bundle();

                    bundle.putString("doctor", doctor);
                    bundle.putString("name", name);
                    bundle.putString("phone", phone);
                    bundle.putString("address", address);
                    bundle.putString("gender", gender);
                    bundle.putString("age", age);
                    bundle.putString("des", des);
                    bundle.putString("pay", pay);
                    bundle.putString("payment", payment);
                    bundle.putString("timeSlot",time);
                    bundle.putString("customDate",customDate);
                    bundle.putString("currentDate",currentDate);

                    Boolean checkInsertedData=db.addPatientData(id,doctor,name,phone,address,gender,age,des,pay,payment,currentDate,customDate,time);
//                    if(checkInsertedData){
//
                        Toast.makeText(container.getContext(),name + " added to database",Toast.LENGTH_SHORT)
                                .show();
                        bookFragment.setArguments(bundle);
                        getParentFragmentManager().beginTransaction().replace(R.id.frameLayout,bookFragment).commit();

                        etName.getText().clear();
                        etPhone.getText().clear();
                        etAddress.getText().clear();
                        rgGender.clearCheck();
                        etAge.getText().clear();
                        etDes.getText().clear();
                        rgPayment.clearCheck();
//                    }
//                    else{
//                        id--;
//                        Toast.makeText(container.getContext(), " Failed to add in database",Toast.LENGTH_SHORT)
//                                .show();
//                    }
                }
            }
        });

        return view;
    }

    private Boolean checkedField(){

        if(etName.length()==0||etPhone.length()==0||etAge.length()==0){
            if(etName.length()==0){
                etName.setError("Field is required");
            }
            if(etPhone.length()==0){
                etPhone.setError("Field is required");
            }
            if(etAge.length()==0){
                etAge.setError("Field is required");
            }
            return false;
        }
        else {
            return true;
        }
    }

    private String radioGender(){
        int select=rgGender.getCheckedRadioButtonId();
        if(select!=1){
            RadioButton rb= getView().findViewById(select);
            return rb.getText().toString();
        }
        else{
            return "None is selected";
        }
    }
    private String radioPayment(){
        int select=rgPayment.getCheckedRadioButtonId();
        if(select!=-1){
            RadioButton rb=getView().findViewById(select);
            return rb.getText().toString();
        }
        else {
            return "None is selected";
        }
    }
}