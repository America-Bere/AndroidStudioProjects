package com.example.spinnerbe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1=(Spinner) findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        String[] opciones={"Lunes","Martes","Miercoles","Jueves","Viernes"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        String[] opciones2={"Mexico","Japon","Canada","USA","Corea"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones2);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter2);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String seleccion;
                seleccion=sp1.getSelectedItem().toString();
                Toast toast=Toast.makeText(getApplicationContext(),"El dia seleccionado es :"+seleccion,Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {


            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String seleccion;
                seleccion=sp2.getSelectedItem().toString();
                Toast toast=Toast.makeText(getApplicationContext(),"El pais seleccionado es :"+seleccion,Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}