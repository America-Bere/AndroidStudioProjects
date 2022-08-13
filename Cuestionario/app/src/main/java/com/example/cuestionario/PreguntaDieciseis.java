package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreguntaDieciseis extends AppCompatActivity implements View.OnClickListener {
    Button sig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_dieciseis);
        sig=(Button) findViewById(R.id.s16);
        sig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent siguiente=new Intent(this,PreguntaDiecisiete.class);
        startActivity(siguiente);
    }
}