package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num1,num2;
    RadioButton rb1,rb2,rb3,rb4;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        btn=(Button) findViewById(R.id.btn);
        tv=(TextView) findViewById(R.id.tv1);
        rb1=(RadioButton) findViewById(R.id.rb1);
        rb2=(RadioButton) findViewById(R.id.rb2);
        rb3=(RadioButton) findViewById(R.id.rb3);
        rb4=(RadioButton) findViewById(R.id.rb4);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        float v1,v2,res;
        v1=Float.parseFloat(num1.getText().toString());
        v2=Float.parseFloat(num2.getText().toString());
        if(rb1.isChecked()){
            res=v1+v2;
            tv.setText("Resultado: "+res);
        }
        else if(rb2.isChecked()){
            res=v1-v2;
            tv.setText("Resultado: "+res);
        }
        else if(rb3.isChecked()){
            res=v1*v2;
            tv.setText("Resultado: "+res);
        }
        else if(rb4.isChecked()){
            if(v2==0){
                Toast toast1 = Toast.makeText(getApplicationContext(), "EL valor debe ser diferente de cero", Toast.LENGTH_SHORT);
                toast1.show();
            }
            else{
                res=v1/v2;
                tv.setText("Resultado: "+res);
            }
        }
    }
}