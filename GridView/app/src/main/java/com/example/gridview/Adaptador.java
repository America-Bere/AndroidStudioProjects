package com.example.gridview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridview.R;

import java.util.List;

public class Adaptador extends BaseAdapter {

  private Context context;
  private int layout;
  private List<String> nombre;
  private int [] imagenes;

  public Adaptador(Context context, int layout, List<String>nombre, int[] imagenes){

      this.context=context;
      this.layout=layout;
      this.nombre=nombre;
      this.imagenes=imagenes;
  }

    @Override
    public int getCount() {
        return nombre.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
        LayoutInflater layautinflater = LayoutInflater.from(context);
        v =  layautinflater.inflate(R.layout.activity2,null);

        TextView tvnombre = v.findViewById(R.id.tv1);
        tvnombre.setText(nombre.get(position));

        ImageView imagen = v.findViewById(R.id.imageview);
        imagen.setImageResource(imagenes [position]);
        return v;

    }
}
