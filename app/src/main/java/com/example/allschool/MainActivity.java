package com.example.allschool;

import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton ajustes en el action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.btn_ajustes);

        final Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switch1.setText("Nocturno");
                }
                else
                {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switch1.setText("Diurno");


                }
            }
        });
    }

public boolean opcionesMenu(MenuItem item)
{
    switch (item.getItemId())
    {
        case R.id.switch1:
            return true;

        case R.id.imageView:
            return true;
    }
    return false;
}

    //método para ir a la configuracion de la aplicacion
    public void configuracion(View view)
    {

        Intent conf = new Intent(this, Configuracion.class);
        startActivity(conf);
    }
}



