package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class PreguntaOcho extends AppCompatActivity implements View.OnClickListener{
    Button sig,sal;
    CheckBox rp1,rp2,rp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_ocho);
        sig=(Button) findViewById(R.id.s8);
        sal=(Button)findViewById(R.id.sig8);
        rp1=(CheckBox) findViewById(R.id.rp22);
        rp2=(CheckBox) findViewById(R.id.rp23);
        rp3=(CheckBox) findViewById(R.id.rp24);
        sig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView bien=new ImageView(getApplicationContext()),mal=new ImageView(getApplicationContext());
        bien.setImageResource(R.drawable.bien);
        mal.setImageResource(R.drawable.equis);
        Toast co=new Toast(getApplicationContext()),in=new Toast(getApplicationContext());;
        if(rp1.isChecked() && rp3.isChecked()){
            co.setDuration(Toast.LENGTH_LONG);
            co.setView(bien);
            co.show();
            Intent siguiente=new Intent(this,PreguntaNueve.class);
            startActivity(siguiente);
        }
        else{
            in.setDuration(Toast.LENGTH_LONG);
            in.setView(mal);
            in.show();
        }/*
        Intent siguiente=new Intent(this,PreguntaNueve.class);
        startActivity(siguiente);*/
    }
    public void Saltar(View W){
        Intent siguiente=new Intent(this,PreguntaNueve.class);
        startActivity(siguiente);
    }
}