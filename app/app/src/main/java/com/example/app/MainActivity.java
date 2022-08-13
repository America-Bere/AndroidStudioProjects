package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3=(EditText) findViewById(R.id.ed3);
        ed4=(EditText) findViewById(R.id.ed4);
    }

    public void guardar(View view) {
        String nombre = ed1.getText().toString();
        String datos = ed2.getText().toString();
        String celular = ed3.getText().toString();
        String direccion = ed4.getText().toString();

        SharedPreferences almacenar = getSharedPreferences("contactos", Context.MODE_PRIVATE);
        SharedPreferences.Editor objeditor = almacenar.edit();

        objeditor.putString(nombre, datos);
        objeditor.commit();
        objeditor.putString(celular,direccion);
        objeditor.commit();

        Toast.makeText(this, "El contacto se ha guardado satisfactoriamente", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View view) {
        String nombre = ed1.getText().toString();
        SharedPreferences almacenar = getSharedPreferences("contactos", Context.MODE_PRIVATE);
        String datos = almacenar.getString(nombre, "");
        String cel = almacenar.getString(nombre, "");
        String di = almacenar.getString(nombre, "");

        if (datos.length() == 0) {
            Toast.makeText(this, "No se encontró ningún registro", Toast.LENGTH_SHORT).show();
        }
        else {
            ed2.setText(datos);
            ed3.setText(cel);
            ed4.setText(di);
        }
    }
}