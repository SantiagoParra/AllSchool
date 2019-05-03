package com.example.allschool;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

 //  private ImageView iv_materias;
   //private ImageView iv_tareas;
    //private ImageView iv_horario;
    //private ImageView iv_gps;
    private ImageView iv_calculoNota;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_calculoNota = (ImageView)findViewById(R.id.img_view_nota);

        iv_calculoNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView =getLayoutInflater().inflate(R.layout.dialog_nota, null);
                TextView tv_periodo1 = (TextView) findViewById(R.id.tv_periodo1);
                TextView tv_periodo2 = (TextView) findViewById(R.id.tv_periodo2);
               // TextView tv_periodo3 = (TextView) findViewById(R.id.tv_periodo3);

            mBuilder.setView(mView);
            AlertDialog alert = mBuilder.create();
            alert.show();
            }
        });
        //boton ajustes en el action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.btn_ajustes);


    }



    //método para ir a la configuracion de la aplicacion
    public void configuracion(View view)
    {

        Intent conf = new Intent(this, Configuracion.class);
        startActivity(conf);
    }
}



