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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tareas extends AppCompatActivity implements CuadroDialogo.FinalizoCuadroDialogo{

    private ListView tareas;
    Context contexto;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Agregar tareas");

        contexto = this;

        tareas = (ListView)findViewById(R.id.lista_tareas);

        arrayList = new ArrayList<String>();

        AdminSQLiteOpenHelper juego = new AdminSQLiteOpenHelper(this, "jumm", null, 2);
        SQLiteDatabase bd = juego.getWritableDatabase();
        Cursor fila = bd.rawQuery("select materia, descripcion from tareas", null);
        if(fila.moveToFirst()){
            do{
                arrayList.add("• " + fila.getString(0) + "\n" + fila.getString(1));
            }while(fila.moveToNext());
        }
        bd.close();

        adapter = new ArrayAdapter<String>(Tareas.this, android.R.layout.simple_list_item_1, arrayList);
        tareas.setAdapter(adapter);

        tareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = arrayList.get(position);
                String[] parts = t.split("\n");
                String[] part = parts[0].split("• ");
                String part1 = part[1];
                String part2 = parts[1];
                //Intent materia = new Intent(Tareas.this, Materias.class);
                //startActivity(materia);
                Toast.makeText(Tareas.this,part1 + "\n" + part2, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.adicionar){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    new CuadroDialogo(contexto, Tareas.this);
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ResultadoCuadroDialogo(String materia, String descripcion) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "jumm", null, 2);
        SQLiteDatabase db = admin.getWritableDatabase();

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

    public void Eliminar(String materia, String descripcion){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db =  admin.getWritableDatabase();

        if (!materia.isEmpty() && !descripcion.isEmpty()){
            int cantidad = db.delete("tareas", "materia =" + materia + "descripcion =" + descripcion, null);
            db.close();

            if (cantidad == 1) {
                Toast.makeText(this, "Tarea eliminada exitosamente", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Seleccionar una Tarea", Toast.LENGTH_SHORT).show();
        }
        finish();
        startActivity(getIntent());
    }
}
