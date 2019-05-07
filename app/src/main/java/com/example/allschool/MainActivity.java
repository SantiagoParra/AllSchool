package com.example.allschool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 //  private ImageView iv_materias;
   //private ImageView iv_tareas;
    //private ImageView iv_horario;
    //private ImageView iv_gps;
    private ImageView iv_calculoNota, iv_horario;
    @Required
    private EditText txt_nota1;
    private EditText txt_nota2;
    private EditText txt_nota3;
    private EditText txt_porc1;
    private EditText txt_porc2;
    private EditText txt_porc3;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        iv_calculoNota = (ImageView)findViewById(R.id.img_view_nota);
        iv_horario = (ImageView)findViewById(R.id.img_view_horario) ;

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

           //     AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
             //   View mView =getLayoutInflater().inflate(R.layout.dialog_nota, null);
               // TextView tv_periodo1 = (TextView) findViewById(R.id.tv_periodo1);
                //TextView tv_periodo2 = (TextView) findViewById(R.id.tv_periodo2);
               // TextView tv_periodo3 = (TextView) findViewById(R.id.tv_periodo3);


         //   mBuilder.setView(mView);
           // AlertDialog alert = mBuilder.create();
            //alert.show();
           // }
      //  });
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



