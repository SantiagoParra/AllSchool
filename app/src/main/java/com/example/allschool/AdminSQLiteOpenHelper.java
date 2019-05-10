package com.example.allschool;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table horario (codigo int primary key, lun1 text, lun2 text, lun3 text, lun4 text, lun5 text, lun6 text, lun7 text, lun8 text, mar1 text, mar2 text, mar3 text, mar4 text, mar5 text, mar6 text, mar7 text, mar8 text, mie1 text, mie2 text, mie3 text, mie4 text, mie5 text, mie6 text, mie7 text, mie8 text, jue1 text, jue2 text, jue3 text, jue4 text, jue5 text, jue6 text, jue7 text, jue8 text, vie1 text, vie2 text, vie3 text, vie4 text, vie5 text, vie6 text, vie7 text, vie8 text, sab1 text, sab2 text, sab3 text, sab4 text, sab5 text, sab6 text, sab7 text, sab8 text)");
        db.execSQL("create table tareas (materia text, descripcion text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
