package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ListView lt1;

  int [] images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lt1=(ListView) findViewById(R.id.lista);
        List<String> nombre;
        nombre = new  ArrayList<String>();
        nombre.add("Juan");
        nombre.add("Pedro");
        nombre.add("Lupe");

        int [] images={R.drawable.imagen1,
                R.drawable.imagen2,
                R.drawable.imagen3
        };

       // ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombre);


        Adaptador adaptador = new  Adaptador(this, R.layout.activity2, nombre, images);
        lt1.setAdapter(adaptador);

        lt1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Usted dió click en "+ nombre.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}