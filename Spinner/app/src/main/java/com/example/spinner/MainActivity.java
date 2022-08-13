package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nu1,nu2;
    Button btn;
    TextView res;
    Spinner op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nu1=(EditText) findViewById(R.id.nu1);
        nu2=(EditText) findViewById(R.id.nu2);
        res=(TextView) findViewById(R.id.res);
        op=(Spinner)findViewById(R.id.op); //vincular la parte logica con la interfaz
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        String[] opciones= {"suma","resta","multiplicacion","division"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        op.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        float v1,v2,r;
        String seleccion;
        seleccion=op.getSelectedItem().toString();
        v1=Float.parseFloat(nu1.getText().toString());
        v2=Float.parseFloat(nu2.getText().toString());
        if(seleccion.equals("suma")){
            r=v1+v2;
            res.setText(" Suma: "+r);
        }
        else if(seleccion.equals("resta")){
            r=v1-v2;
            res.setText(" Resta: "+r);
        }
        else if(seleccion.equals("multiplicacion")){
            r=v1*v2;
            res.setText("Multiplicacion: "+r);
        }
        else if(seleccion.equals("division")){
            if(v2==0){
                Toast toast1 = Toast.makeText(getApplicationContext(), "EL valor debe ser diferente de cero", Toast.LENGTH_SHORT);
                toast1.show();
            }
            else{
                r=v1/v2;
                res.setText("Division: "+r);
            }
        }
    }
}