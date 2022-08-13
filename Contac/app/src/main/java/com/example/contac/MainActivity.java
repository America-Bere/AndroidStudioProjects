package com.example.contac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView g1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1=(GridView) findViewById(R.id.g1);
        int[] imagenes={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
        String nombres[]={"BAKUGO","KIRISHIMA","TOGA","SHOTO","IZUKU"};
        g1.setAdapter(new Adaptador(this, nombres,imagenes));
    }
}