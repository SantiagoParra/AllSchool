package com.example.allschool;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class dibujo extends AppCompatActivity implements  View.OnClickListener{

    private ImageButton colornegro;
    private ImageButton colorazul;
    private ImageButton colorazulClaro;
    private ImageButton colorrojo;
    private ImageButton colorverde;
    private lienzo lienz;
    private float pDefecto, pincelpequeño, pincelMediano, pincelGrande;
    private ImageButton agregar, editar, borrar, guardar;
    private float borrarMediano, borrarGrande;

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
        agregar=(ImageButton)findViewById(R.id.añadir);
        editar=(ImageButton)findViewById(R.id.editar);
        borrar=(ImageButton)findViewById(R.id.borrar);
        guardar=(ImageButton)findViewById(R.id.guardar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Realizar dibujo");




        colornegro.setOnClickListener(this);
        colorazul.setOnClickListener(this);
        colorazulClaro.setOnClickListener(this);
        colorverde.setOnClickListener(this);
        colorrojo.setOnClickListener(this);
        lienz =(lienzo) findViewById(R.id.Lienzo);

        pincelpequeño=10;
        pincelMediano=20;
        pincelGrande=30;
        borrarMediano=50;
        borrarGrande=70;
        pDefecto=pincelpequeño;





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

            case R.id.añadir:

                break;
            case R.id.editar:

            case R.id.borrar:

            break;

            case R.id.guardar:

            break;


        }

    }

    public void editar(View v)
    {
        final Dialog tamañoPunto = new Dialog(this);
        tamañoPunto.setTitle("Tamaño del punto");
        tamañoPunto.setContentView(R.layout.tamano_punto);
        TextView smallBtn=(TextView)tamañoPunto.findViewById(R.id.tpequeño);
        smallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(false);

                lienz.setTamañoPunto(pincelpequeño);
                tamañoPunto.dismiss();
            }
        });
        TextView mediumBtn = (TextView)tamañoPunto.findViewById(R.id.tmediano);
        mediumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(false);

                lienz.setTamañoPunto(pincelMediano);
                tamañoPunto.dismiss();
            }
        });
        TextView grandeBtn = (TextView)tamañoPunto.findViewById(R.id.tgrande);
        grandeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(false);

                lienz.setTamañoPunto(pincelGrande);
                tamañoPunto.dismiss();
            }
        });

        tamañoPunto.show();

    }

    public void borrar(View v)
    {
        final Dialog tamañoPunto = new Dialog(this);
        tamañoPunto.setTitle("Borrar ");
        tamañoPunto.setContentView(R.layout.tamano_punto);
        TextView smallBtn=(TextView)tamañoPunto.findViewById(R.id.tpequeño);
        smallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(true);
                lienz.setTamañoPunto(pincelMediano);
                tamañoPunto.dismiss();
            }
        });
        TextView mediumBtn = (TextView)tamañoPunto.findViewById(R.id.tmediano);
        mediumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(true);

                lienz.setTamañoPunto(borrarMediano);
                tamañoPunto.dismiss();
            }
        });
        TextView grandeBtn = (TextView)tamañoPunto.findViewById(R.id.tgrande);
        grandeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                lienz.setBorrar(true);

                lienz.setTamañoPunto(borrarGrande);
                tamañoPunto.dismiss();
            }
        });

        tamañoPunto.show();
    }

    public void añadir(View v)
    {
        AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
        newDialog.setTitle("Nuevo dibujo");
        newDialog.setMessage("¿Desea realizar un nuevo dibujo? perderá el dibujo actual.");
        newDialog.setPositiveButton("Aceptar",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lienz.nuevoDibujo();
                dialog.dismiss();

            }
        });

        newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        newDialog.create().show();

    }

    public void guardar(View v)
    {
        AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
        newDialog.setTitle("Guardar dibujo");
        newDialog.setMessage("¿Guardar dibujo?");
        newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //guardael dibujo
                        lienz.setDrawingCacheEnabled(true);
                        String imgSaved= MediaStore.Images.Media.insertImage(getContentResolver(), lienz.getDrawingCache(),
                                UUID.randomUUID().toString()+".jpg", "drawing");
                        Toast guardard = Toast.makeText(getApplicationContext(),"Dibujo guardado en la galeria",Toast.LENGTH_SHORT);
                        guardard.show();
                        //mensaje de guardado correcto
                        if(imgSaved!=null)
                        {
                            Toast guardar = Toast.makeText(getApplicationContext(),"Dibujo guardado en la galeria",Toast.LENGTH_SHORT);
                            guardar.show();
                        }
                        else
                        {
                            Toast noguardado = Toast.makeText(getApplicationContext(),"Error! La imagen no se ha guardado" ,Toast.LENGTH_SHORT);
                            noguardado.show();
                        }
                        lienz.destroyDrawingCache();
                    }
                });

        newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });
        newDialog.create().show();

    }
}
