package com.example.allschool;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Materias extends AppCompatActivity {

    private Button btn_audio;
    private Button btn_dibujo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);
        btn_audio = (Button)findViewById(R.id.audio);

        FloatingActionButton fab = findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Snackbar.make(view, "Opción de agregar audio", Snackbar.LENGTH_LONG)
                                               .setAction("Action", null).show();
                                       Intent audio = new Intent(Materias.this, apuntes.class);
                                       startActivity(audio);
                                   }
                               });


        btn_dibujo = (Button)findViewById(R.id.dibujar);

        btn_dibujo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dibujo = new Intent(Materias.this, dibujo.class);
                startActivity(dibujo);
            }
        });
    }
}
