package com.example.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {
    EditText codigo, descripcion, precio;
    Button insert, actu, eli, con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigo=(EditText) findViewById(R.id.codigo);
        descripcion=(EditText) findViewById(R.id.descripcion);
        precio=(EditText) findViewById(R.id.precio);
        insert=(Button) findViewById(R.id.insert);
        actu=(Button) findViewById(R.id.actu);
        eli=(Button) findViewById(R.id.eli);
        con=(Button) findViewById(R.id.con);
    }
    public void REGISTRAR(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String cod=codigo.getText().toString();
        String des=descripcion.getText().toString();
        String pre=precio.getText().toString();
        if(!cod.isEmpty() && !des.isEmpty() && !pre.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put("codigo", cod);
            registro.put("descripcion", des);
            registro.put("precio",pre);
            BaseDatos.insert("articulos",null,registro);
            BaseDatos.close();
            codigo.setText("");
            descripcion.setText("");
            precio.setText("");
            Toast anun=Toast.makeText(getApplicationContext(),"Articulo guardado",Toast.LENGTH_SHORT);
            anun.show();
        }
        else{
            Toast anun=Toast.makeText(getApplicationContext(),"Debe rellenar todos los campos",Toast.LENGTH_SHORT);
            anun.show();
        }
    }
    public void CONSULTAR(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getReadableDatabase();
        String cod=codigo.getText().toString();
        if(!cod.isEmpty()){
            Cursor fila=BaseDatos.rawQuery("Select descripcion,precio from articulos where codigo="+cod,null);
            if(fila.moveToFirst()){
                descripcion.setText(fila.getString(0));
                precio.setText(fila.getString(1));
                BaseDatos.close();
            }
            else{
                Toast anun=Toast.makeText(getApplicationContext(),"Datos no encontrados",Toast.LENGTH_SHORT);
                anun.show();
            }
        }
        else{
            Toast anun=Toast.makeText(getApplicationContext(),"Coloca el codigo",Toast.LENGTH_SHORT);
            anun.show();
        }
    }
    public void ELIMINAR(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getReadableDatabase();
        String cod=codigo.getText().toString();
        if(!cod.isEmpty()){
            Cursor fila=BaseDatos.rawQuery("Delete from articulos where codigo="+cod,null);
            if(fila.moveToFirst()){
                Toast anun=Toast.makeText(getApplicationContext(),"Datos no encontrados",Toast.LENGTH_SHORT);
                anun.show();
            }
            else{
                codigo.setText("");
                descripcion.setText("");
                precio.setText("");
                Toast anun=Toast.makeText(getApplicationContext(),"Datos eliminados",Toast.LENGTH_SHORT);
                anun.show();
                BaseDatos.close();
            }
        }
        else{
            Toast anun=Toast.makeText(getApplicationContext(),"Coloca el codigo",Toast.LENGTH_SHORT);
            anun.show();
        }
    }
    public void ACTUALIZAR(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String cod=codigo.getText().toString();
        String des=descripcion.getText().toString();
        String pre=precio.getText().toString();
        ContentValues values = new ContentValues();
        values.put("descripcion", des);
        values.put("precio",pre);
        BaseDatos.update("articulos",values,"codigo="+cod,null);
        codigo.setText("");
        descripcion.setText("");
        precio.setText("");
        Toast anun=Toast.makeText(getApplicationContext(),"Datos actualizados",Toast.LENGTH_SHORT);
        anun.show();
        BaseDatos.close();
    }
}