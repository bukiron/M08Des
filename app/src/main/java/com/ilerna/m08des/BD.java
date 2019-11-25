package com.ilerna.m08des;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {

    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Crear/abrir tabla
        String table = "CREATE TABLE prueba" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "color TEXT, " +
                "peso INTEGER)";
        //ejecutar
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String nombre,String color,int peso,Context context){
        //conseguir DB para escribir
        SQLiteDatabase escritura = getWritableDatabase();

        String insert = "INSERT INTO prueba (nombre,color,peso) VALUES(\""+nombre+"\",\""+color+"\","+peso+")";
        escritura.execSQL(insert);
        Toast.makeText(context,"Insert correcto",Toast.LENGTH_SHORT).show();
        escritura.close();


    }

    public Cursor readData(Context context){

        SQLiteDatabase lectura = getReadableDatabase();

        String select = "SELECT * FROM prueba";
        Cursor cur = lectura.rawQuery(select,null);
        Toast.makeText(context,"Consulta correcta",Toast.LENGTH_SHORT).show();
        lectura.close();


        return cur;
    }
}
