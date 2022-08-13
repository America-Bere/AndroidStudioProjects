package com.example.contactos;

import android.content.Context;
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
    int [] imagenes;
    public Adaptador(Context contexto, String nombres[], int [] imagenes){
        this.contexto=contexto;
        this.nombres=nombres;
        this.imagenes=imagenes;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista=inflater.inflate(R.layout.activity2,null);
        TextView nombre = (TextView) vista.findViewById(R.id.t1);
        ImageView imagen=(ImageView) vista.findViewById(R.id.img);

        nombre.setText(nombres[position]);
        imagen.setImageResource(imagenes[position]);
        return vista;
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
