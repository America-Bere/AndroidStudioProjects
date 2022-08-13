package com.example.cuestionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class PreguntaCuatro extends AppCompatActivity implements View.OnClickListener {
    Button sig,sal;
    RadioButton rp1,rp2,rp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_cuatro);
        sig=(Button) findViewById(R.id.s4);
        sal=(Button)findViewById(R.id.sig14);
        rp1=(RadioButton) findViewById(R.id.rp10);
        rp2=(RadioButton) findViewById(R.id.rp11);
        rp3=(RadioButton) findViewById(R.id.rp12);
        sig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView bien=new ImageView(getApplicationContext()),mal=new ImageView(getApplicationContext());
        bien.setImageResource(R.drawable.bien);
        mal.setImageResource(R.drawable.equis);
        Toast co=new Toast(getApplicationContext()),in=new Toast(getApplicationContext());;
        if(rp3.isChecked()){
            co.setDuration(Toast.LENGTH_LONG);
            co.setView(bien);
            co.show();
            Intent siguiente=new Intent(this,PreguntaCinco.class);
            startActivity(siguiente);
        }
        else{
            in.setDuration(Toast.LENGTH_LONG);
            in.setView(mal);
            in.show();
        }
        /*Intent siguiente=new Intent(this,PreguntaCinco.class);
        startActivity(siguiente);*/
    }
    public void Saltar(View W){
        Intent siguiente=new Intent(this,PreguntaCinco.class);
        startActivity(siguiente);
    }
}