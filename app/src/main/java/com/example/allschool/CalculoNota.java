package com.example.allschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class CalculoNota extends AppCompatActivity {

//validar si necesita pasar con 3 u otro valor
    private EditText txt_nota1;
    private EditText txt_nota2;
    private TextView tv_nota3;
    private EditText txt_porc1;
    private EditText txt_porc2;
    private TextView tv_porc3;
    private TextView tv1;
    private Spinner s1;
    private TextView tv_periodo2;
    private TextView tv_periodo3;

    private Button btn_calcular3;
    private Button btn_calcular2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_nota);

        txt_nota1 = (EditText) findViewById(R.id.txt_nota1);
        txt_nota2 = (EditText) findViewById(R.id.txt_nota2);
        tv_nota3 = (TextView) findViewById(R.id.tv_nota3);
        txt_porc1 = (EditText) findViewById(R.id.txt_porc1);
        txt_porc2 = (EditText) findViewById(R.id.txt_porc2);
        tv_porc3 = (TextView) findViewById(R.id.tv_porc3);
        tv1 = (TextView) findViewById(R.id.resultado);
        btn_calcular2 = (Button) findViewById(R.id.calcular2);
        btn_calcular3 = (Button) findViewById(R.id.btn_calcular);
        tv_periodo2 = (TextView) findViewById(R.id.tv_periodo2);
        tv_periodo3 = (TextView) findViewById(R.id.tv_periodo3);



        s1 = (Spinner)findViewById(R.id.spinner_cortes);
        String [] opciones = {"3 cortes", "2 cortes", "4 cortes", "5 cortes"};
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, opciones);
        s1.setAdapter(adapter);
    }

    public void calcular3Cortes(View view) {
        String nota1 = txt_nota1.getText().toString();
        String nota2 = txt_nota2.getText().toString();
        String porc1 = txt_porc1.getText().toString();
        String porc2= txt_porc2.getText().toString();


        //pasar a porcentaje

        if (nota1.length() == 0 && nota2.length() == 0 && porc1.length() == 0 && porc2.length() == 0) {
            Toast.makeText(this, R.string.validacion, Toast.LENGTH_LONG).show();
        } else {
            try {


                double d_nota1 = Double.parseDouble(nota1);
                double d_nota2 = Double.parseDouble(nota2);
                double d_porc1 = Double.parseDouble(porc1);
                double d_porc2 = Double.parseDouble(porc2);

                    int porcentaj3 = (int) (100 - (d_porc1 + d_porc2));
                double porcentaje = (double) porcentaj3 / 100;

                if(porcentaj3>0&&(d_porc1+d_porc2+porcentaj3==100)){

                    String porc = String.valueOf(porcentaj3);
                    tv_porc3.setText(porc);

                if((d_nota1 <=5.0&&d_nota1>=0.0)&&(d_nota2<=5.0&&d_nota2>=0.0)) {

                    double respuesta =  (3.0 - ((d_nota1 * d_porc1 / 100)+ (d_nota2 * d_porc2 / 100)));
                    double rta = respuesta /porcentaje;
                    if(rta<=5 && rta >0) {
                        DecimalFormat df = new DecimalFormat("#.00");
                        String numberAsString = new Double(df.format(rta)).toString();

                        tv_nota3.setText(numberAsString);
                        tv1.setText("Para pasar con 3.0 usted necesita "+numberAsString + " en su último corte");
                        Toast.makeText(this, numberAsString, Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this, "no se puede obtener una nota mayor a 5 ni valores negativos ", Toast.LENGTH_SHORT).show();
                    }
                }
                    else
                    {
                        Toast.makeText(this, "" +
                                "Advertencia! Valores fuera de rango (0.0 y 5.0)", Toast.LENGTH_SHORT).show();

                    }
                }
                else{

                Toast.makeText(this, "La suma de porcentajes no debe ser mayor a 100", Toast.LENGTH_SHORT).show();
                }
            }catch(NumberFormatException e){
                    System.out.println("not a number");
                }


        }

    }


    public void calcular2Cortes(View view)
    {

        String nota1 = txt_nota1.getText().toString();
        String porc1 = txt_porc1.getText().toString();

        //pasar a porcentaje

        if (nota1.length() == 0  && porc1.length() == 0) {
            Toast.makeText(this, R.string.validacion2, Toast.LENGTH_LONG).show();
        } else {
            try {


                double d_nota1 = Double.parseDouble(nota1);
                double d_porc1 = Double.parseDouble(porc1);

                int porcentaj2 = (int) (100 - (d_porc1));
                double porcentaje = (double) porcentaj2 / 100;
                if (porcentaj2 > 0 && (d_porc1 + porcentaj2 == 100)) {

                    String porc = String.valueOf(porcentaj2);
                    tv_porc3.setText(porc);
                    if (d_nota1 <= 5.0 && d_nota1 >= 0.0) {

                        //double resultado = ((d_nota1 * (d_porc1 / 100) + d_nota2 * (d_porc2 / 100)));
                        //double resta = (3 - resultado);
                        //double res = (resta * 2.5);

                        double respuesta =  (3.0 - (d_nota1 * d_porc1 / 100));
                        double rta = respuesta /porcentaje;
                        if (rta <= 5 && rta > 0) {
                            DecimalFormat df = new DecimalFormat("#.00");
                            String numberAsString = new Double(df.format(rta)).toString();

                            tv_nota3.setText(numberAsString);
                            tv1.setText(numberAsString);
                            tv1.setText("Para pasar con 3.0 usted necesita "+numberAsString + " en su último corte");
                        } else {
                            Toast.makeText(this, "no se puede obtener una nota mayor a 5 ni valores negativos ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "" +
                                "Advertencia! Valores fuera de rango (0.0 y 5.0)", Toast.LENGTH_SHORT).show();

                    }
                } else {

                    Toast.makeText(this, "La suma de porcentajes no debe ser mayor a 100", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                System.out.println("not a number");
            }
        }

    }
    public void spinner(final View view)
    {

        String seleccion = s1.getSelectedItem().toString();
        if(seleccion.equals("2 cortes"))
        {
            txt_nota2.setVisibility(View.INVISIBLE);
            txt_porc2.setVisibility(View.INVISIBLE);
           // btn_calcular3.setVisibility(View.INVISIBLE);
            tv_periodo2.setVisibility(View.INVISIBLE);
            tv_periodo3.setText("Periodo 2");
           // btn_calcular2.setVisibility(View.VISIBLE);
            txt_porc1.setText("");
            txt_nota1.setText("");
            tv_nota3.setText("Nota");
            tv_porc3.setText("%");
            btn_calcular3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcular2Cortes(v);
                }
            });


        }
        else if(seleccion.equals("3 cortes"))
        {
            txt_nota2.setVisibility(View.VISIBLE);
            txt_porc2.setVisibility(View.VISIBLE);
            tv_periodo2.setVisibility(View.VISIBLE);
            tv_periodo3.setText("Periodo 3");
            btn_calcular3.setVisibility(View.VISIBLE);
            btn_calcular2.setVisibility(View.INVISIBLE);
            txt_porc1.setText("");
            txt_porc2.setText("");
            txt_nota1.setText("");
            txt_nota2.setText("");
            tv_nota3.setText("Nota");
            tv_porc3.setText("%");
            btn_calcular3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcular3Cortes(v);
                }
            });
        }
    }

}
