package com.example.allschool;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CuadroDialogoMat {

    public interface FinalizoCuadroDialogo{
        void ResultadoCuadroDialogo(String materia, String descripcion);
    }

    private FinalizoCuadroDialogo interfaz;

    public CuadroDialogoMat(Context contexto, FinalizoCuadroDialogo actividad){

        interfaz = actividad;
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(true);
        dialogo.setContentView(R.layout.cuadro_dialogomat);

        final EditText materia = (EditText)dialogo.findViewById(R.id.et_materia);
        final EditText descrpcion = (EditText)dialogo.findViewById(R.id.et_descripcion);
        Button btn = (Button)dialogo.findViewById(R.id.btn);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.ResultadoCuadroDialogo(materia.getText().toString(), descrpcion.getText().toString());
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }


}
