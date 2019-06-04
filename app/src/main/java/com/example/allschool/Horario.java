package com.example.allschool;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Horario extends AppCompatActivity {

    private EditText lun1, lun2, lun3, lun4, lun5, lun6, lun7, lun8;
    private EditText mar1, mar2, mar3, mar4, mar5, mar6, mar7, mar8;
    private EditText mie1, mie2, mie3, mie4, mie5, mie6, mie7, mie8;
    private EditText jue1, jue2, jue3, jue4, jue5, jue6, jue7, jue8;
    private EditText vie1, vie2, vie3, vie4, vie5, vie6, vie7, vie8;
    private EditText sab1, sab2, sab3, sab4, sab5, sab6, sab7, sab8;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Agregar horario por semestre");

        lun1 = (EditText)findViewById(R.id.lun1);
        lun2 = (EditText)findViewById(R.id.lun2);
        lun3 = (EditText)findViewById(R.id.lun3);
        lun4 = (EditText)findViewById(R.id.lun4);
        lun5 = (EditText)findViewById(R.id.lun5);
        lun6 = (EditText)findViewById(R.id.lun6);
        lun7 = (EditText)findViewById(R.id.lun7);
        lun8 = (EditText)findViewById(R.id.lun8);

        mar1 = (EditText)findViewById(R.id.mar1);
        mar2 = (EditText)findViewById(R.id.mar2);
        mar3 = (EditText)findViewById(R.id.mar3);
        mar4 = (EditText)findViewById(R.id.mar4);
        mar5 = (EditText)findViewById(R.id.mar5);
        mar6 = (EditText)findViewById(R.id.mar6);
        mar7 = (EditText)findViewById(R.id.mar7);
        mar8 = (EditText)findViewById(R.id.mar8);

        mie1 = (EditText)findViewById(R.id.mie1);
        mie2 = (EditText)findViewById(R.id.mie2);
        mie3 = (EditText)findViewById(R.id.mie3);
        mie4 = (EditText)findViewById(R.id.mie4);
        mie5 = (EditText)findViewById(R.id.mie5);
        mie6 = (EditText)findViewById(R.id.mie6);
        mie7 = (EditText)findViewById(R.id.mie7);
        mie8 = (EditText)findViewById(R.id.mie8);

        jue1 = (EditText)findViewById(R.id.jue1);
        jue2 = (EditText)findViewById(R.id.jue2);
        jue3 = (EditText)findViewById(R.id.jue3);
        jue4 = (EditText)findViewById(R.id.jue4);
        jue5 = (EditText)findViewById(R.id.jue5);
        jue6 = (EditText)findViewById(R.id.jue6);
        jue7 = (EditText)findViewById(R.id.jue7);
        jue8 = (EditText)findViewById(R.id.jue8);

        vie1 = (EditText)findViewById(R.id.vie1);
        vie2 = (EditText)findViewById(R.id.vie2);
        vie3 = (EditText)findViewById(R.id.vie3);
        vie4 = (EditText)findViewById(R.id.vie4);
        vie5 = (EditText)findViewById(R.id.vie5);
        vie6 = (EditText)findViewById(R.id.vie6);
        vie7 = (EditText)findViewById(R.id.vie7);
        vie8 = (EditText)findViewById(R.id.vie8);

        sab1 = (EditText)findViewById(R.id.sab1);
        sab2 = (EditText)findViewById(R.id.sab2);
        sab3 = (EditText)findViewById(R.id.sab3);
        sab4 = (EditText)findViewById(R.id.sab4);
        sab5 = (EditText)findViewById(R.id.sab5);
        sab6 = (EditText)findViewById(R.id.sab6);
        sab7 = (EditText)findViewById(R.id.sab7);
        sab8 = (EditText)findViewById(R.id.sab8);

        spinner1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"1","2","3","4", "5", "6", "7", "8", "9", "10"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_calendario, opciones);
        spinner1.setAdapter(adapter);
    }

    public void Guardar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "otro", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = (String) spinner1.getSelectedItem().toString();

        String slun1 = lun1.getText().toString();
        String slun2 = lun2.getText().toString();
        String slun3 = lun3.getText().toString();
        String slun4 = lun4.getText().toString();
        String slun5 = lun5.getText().toString();
        String slun6 = lun6.getText().toString();
        String slun7 = lun7.getText().toString();
        String slun8 = lun8.getText().toString();

        String smar1 = mar1.getText().toString();
        String smar2 = mar2.getText().toString();
        String smar3 = mar3.getText().toString();
        String smar4 = mar4.getText().toString();
        String smar5 = mar5.getText().toString();
        String smar6 = mar6.getText().toString();
        String smar7 = mar7.getText().toString();
        String smar8 = mar8.getText().toString();

        String smie1 = mie1.getText().toString();
        String smie2 = mie2.getText().toString();
        String smie3 = mie3.getText().toString();
        String smie4 = mie4.getText().toString();
        String smie5 = mie5.getText().toString();
        String smie6 = mie6.getText().toString();
        String smie7 = mie7.getText().toString();
        String smie8 = mie8.getText().toString();

        String sjue1 = jue1.getText().toString();
        String sjue2 = jue2.getText().toString();
        String sjue3 = jue3.getText().toString();
        String sjue4 = jue4.getText().toString();
        String sjue5 = jue5.getText().toString();
        String sjue6 = jue6.getText().toString();
        String sjue7 = jue7.getText().toString();
        String sjue8 = jue8.getText().toString();

        String svie1 = vie1.getText().toString();
        String svie2 = vie2.getText().toString();
        String svie3 = vie3.getText().toString();
        String svie4 = vie4.getText().toString();
        String svie5 = vie5.getText().toString();
        String svie6 = vie6.getText().toString();
        String svie7 = vie7.getText().toString();
        String svie8 = vie8.getText().toString();

        String ssab1 = sab1.getText().toString();
        String ssab2 = sab2.getText().toString();
        String ssab3 = sab3.getText().toString();
        String ssab4 = sab4.getText().toString();
        String ssab5 = sab5.getText().toString();
        String ssab6 = sab6.getText().toString();
        String ssab7 = sab7.getText().toString();
        String ssab8 = sab8.getText().toString();

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("lun1", slun1);
            registro.put("lun2", slun2);
            registro.put("lun3", slun3);
            registro.put("lun4", slun4);
            registro.put("lun5", slun5);
            registro.put("lun6", slun6);
            registro.put("lun7", slun7);
            registro.put("lun8", slun8);

            registro.put("mar1", smar1);
            registro.put("mar2", smar2);
            registro.put("mar3", smar3);
            registro.put("mar4", smar4);
            registro.put("mar5", smar5);
            registro.put("mar6", smar6);
            registro.put("mar7", smar7);
            registro.put("mar8", smar8);

            registro.put("mie1", smie1);
            registro.put("mie2", smie2);
            registro.put("mie3", smie3);
            registro.put("mie4", smie4);
            registro.put("mie5", smie5);
            registro.put("mie6", smie6);
            registro.put("mie7", smie7);
            registro.put("mie8", smie8);

            registro.put("jue1", sjue1);
            registro.put("jue2", sjue2);
            registro.put("jue3", sjue3);
            registro.put("jue4", sjue4);
            registro.put("jue5", sjue5);
            registro.put("jue6", sjue6);
            registro.put("jue7", sjue7);
            registro.put("jue8", sjue8);

            registro.put("vie1", svie1);
            registro.put("vie2", svie2);
            registro.put("vie3", svie3);
            registro.put("vie4", svie4);
            registro.put("vie5", svie5);
            registro.put("vie6", svie6);
            registro.put("vie7", svie7);
            registro.put("vie8", svie8);

            registro.put("sab1", ssab1);
            registro.put("sab2", ssab2);
            registro.put("sab3", ssab3);
            registro.put("sab4", ssab4);
            registro.put("sab5", ssab5);
            registro.put("sab6", ssab6);
            registro.put("sab7", ssab7);
            registro.put("sab8", ssab8);


            db.insert("horario", null, registro);

            db.close();
            spinner1.setSelection(0);
            lun1.setText("");
            lun2.setText("");
            lun3.setText("");
            lun4.setText("");
            lun5.setText("");
            lun6.setText("");
            lun7.setText("");
            lun8.setText("");
            mar1.setText("");
            mar2.setText("");
            mar3.setText("");
            mar4.setText("");
            mar5.setText("");
            mar6.setText("");
            mar7.setText("");
            mar8.setText("");
            mie1.setText("");
            mie2.setText("");
            mie3.setText("");
            mie4.setText("");
            mie5.setText("");
            mie6.setText("");
            mie7.setText("");
            mie8.setText("");
            jue1.setText("");
            jue2.setText("");
            jue3.setText("");
            jue4.setText("");
            jue5.setText("");
            jue6.setText("");
            jue7.setText("");
            jue8.setText("");
            vie1.setText("");
            vie2.setText("");
            vie3.setText("");
            vie4.setText("");
            vie5.setText("");
            vie6.setText("");
            vie7.setText("");
            vie8.setText("");
            sab1.setText("");
            sab2.setText("");
            sab3.setText("");
            sab4.setText("");
            sab5.setText("");
            sab6.setText("");
            sab7.setText("");
            sab8.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
    }

    public void Buscar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "otro", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String semestre = (String)spinner1.getSelectedItem().toString();

        if (!semestre.isEmpty()){
            Cursor fila = db.rawQuery("select lun1, lun2, lun3, lun4, lun5, lun6, lun7, lun8, mar1, mar2, mar3, mar4, mar5, mar6, mar7, mar8, mie1, mie2, mie3, mie4, mie5, mie6, mie7, mie8, jue1, jue2, jue3, jue4, jue5, jue6, jue7, jue8, vie1, vie2, vie3, vie4, vie5, vie6, vie7, vie8, sab1, sab2, sab3, sab4, sab5, sab6, sab7, sab8 from horario where codigo =" + semestre, null);

            if(fila.moveToFirst()){
                lun1.setText(fila.getString(0));
                lun2.setText(fila.getString(1));
                lun3.setText(fila.getString(2));
                lun4.setText(fila.getString(3));
                lun5.setText(fila.getString(4));
                lun6.setText(fila.getString(5));
                lun7.setText(fila.getString(6));
                lun8.setText(fila.getString(7));
                mar1.setText(fila.getString(8));
                mar2.setText(fila.getString(9));
                mar3.setText(fila.getString(10));
                mar4.setText(fila.getString(11));
                mar5.setText(fila.getString(12));
                mar6.setText(fila.getString(13));
                mar7.setText(fila.getString(14));
                mar8.setText(fila.getString(15));
                mie1.setText(fila.getString(16));
                mie2.setText(fila.getString(17));
                mie3.setText(fila.getString(18));
                mie4.setText(fila.getString(19));
                mie5.setText(fila.getString(20));
                mie6.setText(fila.getString(21));
                mie7.setText(fila.getString(22));
                mie8.setText(fila.getString(23));
                jue1.setText(fila.getString(24));
                jue2.setText(fila.getString(25));
                jue3.setText(fila.getString(26));
                jue4.setText(fila.getString(27));
                jue5.setText(fila.getString(28));
                jue6.setText(fila.getString(29));
                jue7.setText(fila.getString(30));
                jue8.setText(fila.getString(31));
                vie1.setText(fila.getString(32));
                vie2.setText(fila.getString(33));
                vie3.setText(fila.getString(34));
                vie4.setText(fila.getString(35));
                vie5.setText(fila.getString(36));
                vie6.setText(fila.getString(37));
                vie7.setText(fila.getString(38));
                vie8.setText(fila.getString(39));
                sab1.setText(fila.getString(40));
                sab2.setText(fila.getString(41));
                sab3.setText(fila.getString(42));
                sab4.setText(fila.getString(43));
                sab5.setText(fila.getString(44));
                sab6.setText(fila.getString(45));
                sab7.setText(fila.getString(46));
                sab8.setText(fila.getString(47));

                db.close();
            }else{
                Toast.makeText(this, "No existe el horario", Toast.LENGTH_SHORT).show();
                lun1.setText("");
                lun2.setText("");
                lun3.setText("");
                lun4.setText("");
                lun5.setText("");
                lun6.setText("");
                lun7.setText("");
                lun8.setText("");
                mar1.setText("");
                mar2.setText("");
                mar3.setText("");
                mar4.setText("");
                mar5.setText("");
                mar6.setText("");
                mar7.setText("");
                mar8.setText("");
                mie1.setText("");
                mie2.setText("");
                mie3.setText("");
                mie4.setText("");
                mie5.setText("");
                mie6.setText("");
                mie7.setText("");
                mie8.setText("");
                jue1.setText("");
                jue2.setText("");
                jue3.setText("");
                jue4.setText("");
                jue5.setText("");
                jue6.setText("");
                jue7.setText("");
                jue8.setText("");
                vie1.setText("");
                vie2.setText("");
                vie3.setText("");
                vie4.setText("");
                vie5.setText("");
                vie6.setText("");
                vie7.setText("");
                vie8.setText("");
                sab1.setText("");
                sab2.setText("");
                sab3.setText("");
                sab4.setText("");
                sab5.setText("");
                sab6.setText("");
                sab7.setText("");
                sab8.setText("");
                db.close();
            }
        }else{
            Toast.makeText(this, "Debes seleccionar el semestre", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "otro", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = (String) spinner1.getSelectedItem().toString();

        String slun1 = lun1.getText().toString();
        String slun2 = lun2.getText().toString();
        String slun3 = lun3.getText().toString();
        String slun4 = lun4.getText().toString();
        String slun5 = lun5.getText().toString();
        String slun6 = lun6.getText().toString();
        String slun7 = lun7.getText().toString();
        String slun8 = lun8.getText().toString();

        String smar1 = mar1.getText().toString();
        String smar2 = mar2.getText().toString();
        String smar3 = mar3.getText().toString();
        String smar4 = mar4.getText().toString();
        String smar5 = mar5.getText().toString();
        String smar6 = mar6.getText().toString();
        String smar7 = mar7.getText().toString();
        String smar8 = mar8.getText().toString();

        String smie1 = mie1.getText().toString();
        String smie2 = mie2.getText().toString();
        String smie3 = mie3.getText().toString();
        String smie4 = mie4.getText().toString();
        String smie5 = mie5.getText().toString();
        String smie6 = mie6.getText().toString();
        String smie7 = mie7.getText().toString();
        String smie8 = mie8.getText().toString();

        String sjue1 = jue1.getText().toString();
        String sjue2 = jue2.getText().toString();
        String sjue3 = jue3.getText().toString();
        String sjue4 = jue4.getText().toString();
        String sjue5 = jue5.getText().toString();
        String sjue6 = jue6.getText().toString();
        String sjue7 = jue7.getText().toString();
        String sjue8 = jue8.getText().toString();

        String svie1 = vie1.getText().toString();
        String svie2 = vie2.getText().toString();
        String svie3 = vie3.getText().toString();
        String svie4 = vie4.getText().toString();
        String svie5 = vie5.getText().toString();
        String svie6 = vie6.getText().toString();
        String svie7 = vie7.getText().toString();
        String svie8 = vie8.getText().toString();

        String ssab1 = sab1.getText().toString();
        String ssab2 = sab2.getText().toString();
        String ssab3 = sab3.getText().toString();
        String ssab4 = sab4.getText().toString();
        String ssab5 = sab5.getText().toString();
        String ssab6 = sab6.getText().toString();
        String ssab7 = sab7.getText().toString();
        String ssab8 = sab8.getText().toString();

        if (!codigo.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("lun1", slun1);
            registro.put("lun2", slun2);
            registro.put("lun3", slun3);
            registro.put("lun4", slun4);
            registro.put("lun5", slun5);
            registro.put("lun6", slun6);
            registro.put("lun7", slun7);
            registro.put("lun8", slun8);

            registro.put("mar1", smar1);
            registro.put("mar2", smar2);
            registro.put("mar3", smar3);
            registro.put("mar4", smar4);
            registro.put("mar5", smar5);
            registro.put("mar6", smar6);
            registro.put("mar7", smar7);
            registro.put("mar8", smar8);

            registro.put("mie1", smie1);
            registro.put("mie2", smie2);
            registro.put("mie3", smie3);
            registro.put("mie4", smie4);
            registro.put("mie5", smie5);
            registro.put("mie6", smie6);
            registro.put("mie7", smie7);
            registro.put("mie8", smie8);

            registro.put("jue1", sjue1);
            registro.put("jue2", sjue2);
            registro.put("jue3", sjue3);
            registro.put("jue4", sjue4);
            registro.put("jue5", sjue5);
            registro.put("jue6", sjue6);
            registro.put("jue7", sjue7);
            registro.put("jue8", sjue8);

            registro.put("vie1", svie1);
            registro.put("vie2", svie2);
            registro.put("vie3", svie3);
            registro.put("vie4", svie4);
            registro.put("vie5", svie5);
            registro.put("vie6", svie6);
            registro.put("vie7", svie7);
            registro.put("vie8", svie8);

            registro.put("sab1", ssab1);
            registro.put("sab2", ssab2);
            registro.put("sab3", ssab3);
            registro.put("sab4", ssab4);
            registro.put("sab5", ssab5);
            registro.put("sab6", ssab6);
            registro.put("sab7", ssab7);
            registro.put("sab8", ssab8);

            int cantidad = db.update("horario", registro, "codigo =" + codigo, null);
            db.close();

            if (cantidad == 1){
                Toast.makeText(this, "Horario modificado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe el horario", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
