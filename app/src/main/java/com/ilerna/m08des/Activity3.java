package com.ilerna.m08des;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    Servicio ser;
    RadioGroup grupo;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


    }

    public void servicio(View view) {


        grupo = findViewById(R.id.grupo);
        radio1 = findViewById(R.id.rad1);
        radio2 = findViewById(R.id.rad2);
        radio3 = findViewById(R.id.rad3);

        int idGrupo = grupo.getCheckedRadioButtonId();
        if(idGrupo  == radio1.getId()){

            Intent intent = new Intent(this,Servicio.class);
            startService(intent);


        }else if (idGrupo == radio2.getId()){

            Intent intent = new Intent(this,Servicio.class);
            stopService(intent);
        }else if (idGrupo == radio3.getId()){

            try {
                //Bloqueamos la app 6 segundos
                Toast.makeText(this,"Aplicación bloqueada",Toast.LENGTH_SHORT).show();
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void volver(View view) {
        //Volver a la actividad 1
        Intent intent = new Intent(Activity3.this,MainActivity.class);
        startActivity(intent);
    }

    public void stopService(View view) {

        try {
            Toast.makeText(this,"App bloqueada",Toast.LENGTH_SHORT).show();

            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
