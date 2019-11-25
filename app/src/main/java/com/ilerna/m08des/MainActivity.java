package com.ilerna.m08des;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void irActivity2(View view) {

        Intent intent = new Intent(MainActivity.this,Activity2.class);
        //Toast.makeText(this,"ir a actividad 2",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void irActivity3(View view) {

        Intent intent = new Intent(MainActivity.this,Activity3.class);
        //Toast.makeText(this,"ir a actividad 3",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
