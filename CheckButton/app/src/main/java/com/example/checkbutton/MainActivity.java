package com.example.checkbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num1,num2;
    CheckBox suma,resta,multiplicacion,division;
    Button btn;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        suma=(CheckBox) findViewById(R.id.suma);
        resta=(CheckBox) findViewById(R.id.resta);
        multiplicacion=(CheckBox)findViewById(R.id.multiplicacion);
        division=(CheckBox)findViewById(R.id.division);
        resultado=(TextView) findViewById(R.id.res);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float v1,v2,su,re;
        String res="";
        v1=Float.parseFloat(num1.getText().toString());
        v2=Float.parseFloat(num2.getText().toString());
        if(suma.isChecked()){
            su=v1+v2;
            res="suma: "+su+"   ";
        }
        if(resta.isChecked()){
            re=v1-v2;
            res=res+"resta: "+re+"   ";
        }
        if(multiplicacion.isChecked()){
            re=v1*v2;
            res=res+"Multiplicacion: "+re+"   ";
        }
        if(division.isChecked()){
            if(v2==0){
                Toast toast1 = Toast.makeText(getApplicationContext(), "EL valor debe ser diferente de cero", Toast.LENGTH_SHORT);
                toast1.show();
            }
            else{
                re=v1/v2;
                res=res+"Division: "+re;
            }
        }
        resultado.setText("Resultado: "+res);
    }
}