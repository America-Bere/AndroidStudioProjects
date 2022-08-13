package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inicio extends AppCompatActivity {
    Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        cerrar=(Button) findViewById(R.id.ce);
    }
    public void cerrar(View V){
        Toast anun=Toast.makeText(getApplicationContext(),"CERRASTE SESION",Toast.LENGTH_SHORT);
        anun.show();
        Intent ant=new Intent(this,MainActivity.class);
        startActivity(ant);
    }
}