package com.example.allschool;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

 //  private ImageView iv_materias;
   //private ImageView iv_tareas;
    //private ImageView iv_horario;
    private ImageView iv_gps;
    private ImageView iv_calculoNota, iv_horario, iv_tareas, iv_materias;
    @Required
   private Spinner s1;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        iv_calculoNota = (ImageView)findViewById(R.id.img_view_nota);
        iv_horario = (ImageView)findViewById(R.id.img_view_horario) ;
        iv_gps = (ImageView)findViewById(R.id.img_view_gps) ;
        iv_tareas = (ImageView)findViewById(R.id.img_view_tarea) ;
        iv_materias = (ImageView)findViewById(R.id.img_view_materias) ;



        iv_calculoNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nota = new Intent(MainActivity.this, CalculoNota.class);
                startActivity(nota);
            }
        });

        iv_horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent horario = new Intent(MainActivity.this, Horario.class);
                startActivity(horario);
            }
        });

        iv_tareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tarea = new Intent(MainActivity.this, Tareas.class);
                startActivity(tarea);
            }
        });
        iv_materias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materia = new Intent(MainActivity.this, Asignaturas.class);
                startActivity(materia);
            }
        });

        iv_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:4.59021, -74.042583?z=10&q=Universidad"); //latitud y longitud de Bogota, filtrado por universidades
                Intent mapa = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapa.setPackage("com.google.android.apps.maps");
                if(mapa.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(mapa);

                }
            }
        });
           //   AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
               // View mView =getLayoutInflater().inflate(R.layout.dialog_nota, null);
        //String [] opciones = {"2 cortes","", "3 cortes", "4 cortes", "5 cortes"};
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.dialog_nota, opciones);
        //s1.setAdapter(adapter);

          //  mBuilder.setView(mView);
            //AlertDialog alert = mBuilder.create();
            //alert.show();



    }





}



