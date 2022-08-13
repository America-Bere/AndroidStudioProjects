package com.example.promedio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ma1,ma2,ma3,ma4;
    Button btn;
    TextView pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ma1=(EditText) findViewById(R.id.ma1);
        ma2=(EditText) findViewById(R.id.ma2);
        ma3=(EditText) findViewById(R.id.ma3);
        ma4=(EditText) findViewById(R.id.ma4);
        pro=(TextView) findViewById(R.id.pro);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float mate1,mate2,mate3,mate4,res;
        ImageView i=new ImageView(getApplicationContext()), j=new ImageView(getApplicationContext());
        i.setImageResource(R.drawable.aprobado);
        j.setImageResource(R.drawable.reprobado);
        Toast toast1=new Toast(getApplicationContext()),toast2=new Toast(getApplicationContext());
        //Toast toast1 = Toast.makeText(getApplicationContext(), "La calificacion es reprobatoria", Toast.LENGTH_SHORT),toast2 = Toast.makeText(getApplicationContext(), "La calificacion es aprobatoria", Toast.LENGTH_SHORT);;
        mate1=Float.parseFloat(ma1.getText().toString());
        mate2=Float.parseFloat(ma2.getText().toString());
        mate3=Float.parseFloat(ma3.getText().toString());
        mate4=Float.parseFloat(ma4.getText().toString());
        res=(mate1+mate2+mate3+mate4)/4;
        pro.setText("Promedio: "+res);
        if(res < 6){
            toast1.setDuration(Toast.LENGTH_LONG);
            toast1.setView(j);
            toast1.show();
        }
        else{
            toast2.setDuration(Toast.LENGTH_LONG);
            toast2.setView(i);
            toast2.show();
        }
    }
}