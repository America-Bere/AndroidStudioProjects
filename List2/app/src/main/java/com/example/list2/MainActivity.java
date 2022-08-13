package com.example.list2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list1;
    int[] imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1=(ListView)findViewById(R.id.list1);
        int[] imagenes={R.drawable.img1,R.drawable.img2,R.drawable.img3};
        String nombres[]={"Juan","Pedro","Gabi"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);
        list1.setAdapter(adaptador);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String it=(String) list1.getItemAtPosition(i);

                String text="se seleccionó "+it;
                Toast anun=Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
                anun.show();
            }
        });
    }
}