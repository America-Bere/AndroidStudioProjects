import static com.example.list2.R.layout.activity2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.list2.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contexto;
    String nombres[];
    int [] imagenes;

    public Adapter (Context contexto,String nombres[],int [] imagenes){
        this.contexto=contexto;
        this.nombres=nombres;
        this.imagenes=imagenes;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista=inflater.inflate(R.layout.activity2,null);
        TextView nombre = (TextView) vista.findViewById(R.id.t1);
        ImageView imagen=(ImageView) vista.findViewById(R.id.img1);

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
