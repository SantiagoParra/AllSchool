package com.example.allschool;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Asignaturas extends AppCompatActivity implements CuadroDialogoMat.FinalizoCuadroDialogo {
    private Spinner s1;
    private ListView materias;
    Context contexto;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        s1 = (Spinner)findViewById(R.id.spinner);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Agregar materias");


        String [] opciones = {"1","2","3","4", "5", "6", "7", "8", "9", "10"};

       ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, R.layout.spinner_item_calendario, opciones);
        s1.setAdapter(adapterr);

        contexto = this;

        materias = (ListView)findViewById(R.id.listamaterias);

        arrayList = new ArrayList<String>();

        AdminSQLiteOpenHelper juego = new AdminSQLiteOpenHelper(this, "mat", null, 2);
        SQLiteDatabase bd = juego.getWritableDatabase();
        Cursor fila = bd.rawQuery("select materia , descripcion from tareas", null);
        if(fila.moveToFirst()){
            do{
                arrayList.add("• " + fila.getString(0) + "\n" + fila.getString(1));
            }while(fila.moveToNext());
        }
        bd.close();

        adapter = new ArrayAdapter<String>(Asignaturas.this, android.R.layout.simple_list_item_1, arrayList);
        materias.setAdapter(adapter);

       materias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = arrayList.get(position);
                String[] parts = t.split("\n");
                String[] part = parts[0].split("• ");
                String part1 = part[1];
                String part2 = parts[1];
                Intent materia = new Intent(Asignaturas.this, botonnn.class);
                startActivity(materia);
            }
        });


    }

    public void Guardar(View view) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "mat", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = (String) s1.getSelectedItem().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);

        db.insert("materias", null, registro);

        db.close();
        s1.setSelection(0);
    }

    public void Buscar (View v)
    {

        Toast.makeText(Asignaturas.this,"hola", Toast.LENGTH_SHORT).show();

        contexto = this;

        materias = (ListView)findViewById(R.id.listamaterias);

        arrayList = new ArrayList<String>();

        AdminSQLiteOpenHelper juego = new AdminSQLiteOpenHelper(this, "mat", null, 2);
        SQLiteDatabase bd = juego.getWritableDatabase();
        String semestre = (String) s1.getSelectedItem().toString();

        if (!semestre.isEmpty()){
        Cursor fila = bd.rawQuery("select materia, descripcion from materias where codigo = " + semestre, null);

        if(fila.moveToFirst()){
            do{
                arrayList.add("• " + fila.getString(0) + "\n" + fila.getString(1));
            }while(fila.moveToNext());
        }
        }
        bd.close();

        adapter = new ArrayAdapter<String>(Asignaturas.this, android.R.layout.simple_list_item_1, arrayList);
        materias.setAdapter(adapter);

        materias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = arrayList.get(position);
                String[] parts = t.split("\n");
                String[] part = parts[0].split("• ");
                String part1 = part[1];
                String part2 = parts[1];
                Intent materia = new Intent(Asignaturas.this, botonnn.class);
                startActivity(materia);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menumat, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.adicionar){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    new CuadroDialogoMat(contexto, Asignaturas.this);
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ResultadoCuadroDialogo(String materia, String descripcion) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "mat", null, 2);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = (String) s1.getSelectedItem().toString();

        if (!materia.isEmpty() && !descripcion.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("materia", materia);
            registro.put("descripcion", descripcion);

            db.insert("tareas", null, registro);
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Debe registrar todos los campos", Toast.LENGTH_SHORT).show();
        }

        db.close();
        finish();
        startActivity(getIntent());
    }


}
