package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class registrar extends AppCompatActivity {
    ImageView img2;
    EditText nom2,con2;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        img2=(ImageView) findViewById(R.id.imageView2);
        nom2=(EditText)findViewById(R.id.nom2);
        con2=(EditText)findViewById(R.id.con2);
        reg=(Button)findViewById(R.id.re2);
        img2.setImageResource(R.drawable.foto2);
    }
    public void REGISTRAR(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String nombre=nom2.getText().toString();
        String contrase=con2.getText().toString();
        if(!nombre.isEmpty() && !contrase.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put("nombre",nombre);
            registro.put("contrasena",contrase);
            BaseDatos.insert("usuarios",null,registro);
            BaseDatos.close();
            nom2.setText("");
            con2.setText("");
            Toast anun=Toast.makeText(getApplicationContext(),"ESTAS REGISTRADO",Toast.LENGTH_SHORT);
            anun.show();
            Intent ant=new Intent(this,MainActivity.class);
            startActivity(ant);
        }
        else{
            Toast anun=Toast.makeText(getApplicationContext(),"Debe rellenar todos los campos",Toast.LENGTH_SHORT);
            anun.show();
        }
    }
}