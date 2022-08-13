package com.example.formulario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nom, co;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=(EditText)findViewById(R.id.nom);
        co=(EditText)findViewById(R.id.co);
        guardar=(Button)findViewById(R.id.guardar);
        guardar.setOnClickListener(this);
    }
    @Override
    public void onClick(View V){
        String nombre="",correo="";
        nombre=nom.getText().toString();
        correo=co.getText().toString();
        Toast toast1 = Toast.makeText(getApplicationContext(), "Nombre: "+nombre+" Correo: "+correo, Toast.LENGTH_SHORT);
        toast1.show();
    }
}