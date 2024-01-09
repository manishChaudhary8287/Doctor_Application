package com.manish.doctorapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DoctorDatabase extends SQLiteOpenHelper {

    public DoctorDatabase(Context context){
        super(context,"DoctorProfile.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL("create table DoctorProfile(doctor text,special text,cost text,phone,text,address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int i, int i1) {
        db2.execSQL("drop table if exists DoctorProfile");
    }
    public boolean addDoctor(String doctor,String special,String cost,String phone,String address){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("doctor",doctor);
        cv.put("special",special);
        cv.put("cost",cost);
        cv.put("phone",phone);
        cv.put("address",address);
        long result=db2.insert("DoctorProfile",null,cv);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getDoctors(){
        SQLiteDatabase db2 = this.getReadableDatabase();
        return db2.rawQuery("select doctor from DoctorProfile",null);
    }
    public Cursor getDoctorProfile(){
        SQLiteDatabase db2 = this.getReadableDatabase();
        return db2.rawQuery("select doctor,special,cost from DoctorProfile",null);
    }
}
