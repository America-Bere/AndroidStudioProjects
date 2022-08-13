package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num1, num2;
    Button suma;
    TextView resul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        resul=(TextView)findViewById(R.id.resultado);
        suma=(Button)findViewById(R.id.suma);
        suma.setOnClickListener(this);
    }
        @Override
        public void onClick(View V){
            int n1=Integer.parseInt(num1.getText().toString());
            int n2=Integer.parseInt(num2.getText().toString());
            int res=n1 + n2;
            resul.setText("Resultado:"+res);
        }
}