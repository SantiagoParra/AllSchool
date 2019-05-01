package com.example.allschool;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Configuracion extends AppCompatActivity {

    private TextView mododiurno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        anteriorActionBar();

    }
    //ir a la actividad anterior
    public void anteriorActionBar ()
    {
        ActionBar actionbar = getSupportActionBar();
        if(actionbar!=null)
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setTitle("Configuración");
        }
    }
}
