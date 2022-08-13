package com.example.contac;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contexto;
    String nombres[];
    int[] imagenes;
    public Adaptador(Context contexto, String nombres[], int[] imagenes){
        this.contexto=contexto;
        this.imagenes=imagenes;
        this.nombres=nombres;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vista = inflater.inflate(R.layout.activity2, null);
        TextView nombre = (TextView) vista.findViewById(R.id.t1);
        ImageView imagen = (ImageView) vista.findViewById(R.id.img);
        nombre.setText(nombres[i]);
        imagen.setImageResource(imagenes[i]);
        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorimagen=new Intent(contexto,Visualimg.class);
                visorimagen.putExtra("IMG",imagenes[(Integer)v.getTag()]);
                contexto.startActivity(visorimagen);
            }
        });
        return vista;
    }
    @Override
    public int getCount() {return imagenes.length;}

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}
}
