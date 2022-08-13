package com.example.dias;

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
        sp1 = (Spinner) findViewById(R.id.spinner1);
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Sabado", "Domingo"};
        ArrayAdapter<String> dia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias);
        sp1.setAdapter(dia);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String seleccion;
                seleccion=sp1.getSelectedItem().toString();
                Toast toast=Toast.makeText(getApplicationContext(),"El dia de la semana es :"+seleccion,Toast.LENGTH_SHORT);
                toast.show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {


            }
        });
    }
}