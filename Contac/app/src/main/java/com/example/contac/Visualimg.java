package com.example.contac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Visualimg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualimg);
        ImageView img =(ImageView) findViewById(R.id.imgview);
        Intent intent = getIntent();
        Bundle b =intent.getExtras();
        if(b!=null){
            img.setImageResource(b.getInt("IMG"));
        }
    }
}