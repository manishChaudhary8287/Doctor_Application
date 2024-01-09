package com.manish.doctorapplication.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class NewDatabase extends SQLiteOpenHelper {

    public NewDatabase(@Nullable Context context) {
        super(context, "DoctorDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Appointment(id integer ,doctor text,name text,phone text,address text,gender text," +
                "age text,des text,pay text,payment text,date text,customDate text,timeSlot text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Appointment");
    }

    public Boolean addPatientData(int id,String doctor, String name, String phone, String address,String gender, String age,
                                  String des, String pay,String payment,String date,String customDate,String timeSlot){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("doctor",doctor);
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        contentValues.put("gender",gender);
        contentValues.put("age",age);
        contentValues.put("des",des);
        contentValues.put("pay",pay);
        contentValues.put("payment",payment);
        contentValues.put("date",date);
        contentValues.put("customDate",customDate);
        contentValues.put("timeSlot",timeSlot);
        long result=db.insert("Appointment",null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

        public Cursor getReportData(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select doctor,name,age,pay,date from Appointment",null);
        return cursor;
    }

    public Cursor getData(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Appointment",null);
        return cursor;
    }

    public Cursor getDataById(int theId){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Appointment where id="+theId,null);
        return cursor;
    }
    public Cursor getReportUsingDate(Date d1, Date d2){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select doctor,name,age,pay,date from Appointment where date betweeen "+d1 + "and "+d2,null);
        return cursor;
    }
    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        int count= (int) DatabaseUtils.queryNumEntries(db,"Appointment");

        if(count==-1){
            return 1;
        }
        else {
            return count;
        }
    }
}

