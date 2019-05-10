package com.example.allschool;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class tareas extends AppCompatActivity {

    private ListView tareas;
    private  EditText et_materia;
    private ImageButton btn;
    private  EditText et_descripcion;
    Context contexto;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        et_materia = (EditText)findViewById(R.id.et_materia);
        et_descripcion = (EditText)findViewById(R.id.et_desc);
        btn = (ImageButton)findViewById(R.id.btn);
        tareas = (ListView)findViewById(R.id.lista_tareas);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(tareas.this, android.R.layout.simple_list_item_1, arrayList);
        tareas.setAdapter(adapter);
    }

    public void Adicionar(View view){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String materia = et_materia.getText().toString();
                String descripcion = et_descripcion.getText().toString();
                arrayList.add(materia + "\n" + descripcion);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
