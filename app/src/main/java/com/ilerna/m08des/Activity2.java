package com.ilerna.m08des;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    BD bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

    }


    //Al crear mostrar toast con el nombre de la actividad
    protected void onStart(){
        super.onStart();

        //salvamos el nombre de la actividad
        String nombreActivity = this.getClass().getSimpleName();
        //Mostramos en TOAST
        Toast.makeText(this,nombreActivity,Toast.LENGTH_SHORT).show();
    }


    public void volverAct1(View view) {

        Intent intent = new Intent(Activity2.this,MainActivity.class);

        startActivity(intent);
    }

    public void crearTabla(View view) {

        bd = new BD(this,"pac",null,1);
        Toast.makeText(this,"Tabla Creada",Toast.LENGTH_SHORT).show();

    }

    public void insertar(View view) {

        //Sacamos lo escrito de los 3 EditText
        EditText tNombre = findViewById(R.id.editNombre);
        String nombre = tNombre.getText().toString();


        EditText tColor = findViewById(R.id.editColor);
        String color = tColor.getText().toString();

        EditText tPeso = findViewById(R.id.editPeso);
        String puente= tPeso.getText().toString();
        int peso=Integer.parseInt(puente);

        //Insertamos datos
        bd.insertData(nombre,color,peso,this);


    }

    public void consultarDatos(View view) {

        //he intentado hacerlo mediante un método que devolviera un Cursor
        // en la clase BD pero no me salía, así que lo hago directamente aquí
        TextView tv = findViewById(R.id.textConsulta);
        tv.setMovementMethod(new ScrollingMovementMethod());
        Cursor c = bd.getReadableDatabase().rawQuery(
                "SELECT * FROM prueba",null);
        if (c.moveToFirst()){
            //Comprobamos que hay registro

            do{
                //si los hay los guardamos
                String num = c.getString(0);
                String nombre = c.getString(1);
                String color = c.getString(2);
                int peso = c.getInt(3);

                //y pasamos al textview
                tv.append("\n"+num+" " + nombre +" " + color+ " " + peso);


            }while(c.moveToNext());
        }
        c.close();


    }
}
