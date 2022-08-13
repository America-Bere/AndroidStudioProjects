package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    Button suma,resta,div,mul;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        resultado=(TextView) findViewById(R.id.res);
        suma=(Button) findViewById(R.id.suma);
        resta=(Button) findViewById(R.id.resta);
        div=(Button) findViewById(R.id.division);
        mul=(Button) findViewById(R.id.multiplicacion);
    }
    public void suma(View V){
        int n1=Integer.parseInt(num1.getText().toString());
        int n2=Integer.parseInt(num2.getText().toString());
        int res=n1 + n2;
        resultado.setText("Resultado:"+res);
    }
    public void resta(View V){
        int n1=Integer.parseInt(num1.getText().toString());
        int n2=Integer.parseInt(num2.getText().toString());
        int res=n1 - n2;
        resultado.setText("Resultado:"+res);
    }
    public void multiplicacion(View V){
        int n1=Integer.parseInt(num1.getText().toString());
        int n2=Integer.parseInt(num2.getText().toString());
        int res=n1 * n2;
        resultado.setText("Resultado:"+res);
    }
    public void division(View V){
        int n1=Integer.parseInt(num1.getText().toString());
        int n2=Integer.parseInt(num2.getText().toString());
        int res=n1 / n2;
        resultado.setText("Resultado:"+res);
    }
}