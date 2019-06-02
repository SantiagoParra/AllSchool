package com.example.allschool;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class dibujo extends AppCompatActivity implements  View.OnClickListener{

    private ImageButton colornegro;
    private ImageButton colorazul;
    private ImageButton colorazulClaro;
    private ImageButton colorrojo;
    private ImageButton colorverde;
    private lienzo lienz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        colornegro=(ImageButton)findViewById(R.id.colorNegro);
        colorazul=(ImageButton)findViewById(R.id.colorAzul);
        colorazulClaro=(ImageButton)findViewById(R.id.colorAzulClaro);
        colorverde=(ImageButton)findViewById(R.id.colorVerde);
        colorrojo=(ImageButton)findViewById(R.id.colorRojo);

        colornegro.setOnClickListener(this);
        colorazul.setOnClickListener(this);
        colorazulClaro.setOnClickListener(this);
        colorverde.setOnClickListener(this);
        colorrojo.setOnClickListener(this);
        lienz =(lienzo) findViewById(R.id.Lienzo);




    }

    @Override
    public void onClick(View v) {
        String color=null;
        switch (v.getId())
        {
            case R.id.colorNegro:
                color=v.getTag().toString();
                lienz.setColor(color);

                break;
            case R.id.colorAzul:
                color=v.getTag().toString();
                lienz.setColor(color);
                break;
            case R.id.colorAzulClaro:
                color=v.getTag().toString();
                lienz.setColor(color);
                break;
            case R.id.colorVerde:
                color=v.getTag().toString();
                lienz.setColor(color);
                break;

            case R.id.colorRojo:
                color=v.getTag().toString();
                lienz.setColor(color);
                break;

        }

    }

}
