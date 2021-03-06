package com.example.allschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class botonnn extends AppCompatActivity {

    private FloatingActionButton fab, fab1, fab2, fab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botonnn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Apuntes por materias");

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opción de agregar audio", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent audio = new Intent(botonnn.this, apuntes.class);
                startActivity(audio);
            }
        });

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opción de agregar dibujo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent dibujo = new Intent(botonnn.this, dibujo.class);
                startActivity(dibujo);
            }
        });

        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opción de agregar txt", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent nota = new Intent(botonnn.this, apunteNota.class);
                startActivity(nota);
            }
        });

        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opción de agregar txt", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent foto = new Intent(botonnn.this, fotoApunte.class);
                startActivity(foto);
            }
        });
    }

}
