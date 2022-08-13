package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        int[] imagenes={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};
        String nombres[]={"BAKUGO","KIRISHIMA","TOGA","SHOTO","IZUKU"};
        list1.setAdapter(new Adaptador(this,nombres,imagenes));
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "Usted dió click en "+nombres[position], Toast.LENGTH_SHORT).show();
                /*String it=(String) list1.get(i);

                String text="se seleccionó "+it;
                Toast anun= Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
                anun.show();*/
            }
        });
    }
}