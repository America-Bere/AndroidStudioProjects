package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    EditText nom, con;
    Button ingre, regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView) findViewById(R.id.imageView);
        nom=(EditText) findViewById(R.id.nom);
        con=(EditText) findViewById(R.id.con);
        ingre=(Button) findViewById(R.id.ini);
        regis=(Button) findViewById(R.id.re);
        img.setImageResource(R.drawable.foto1);
    }
    public void iniciar(View V){
        DBHELPER admin=new DBHELPER(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos=admin.getWritableDatabase();
        String nombre=nom.getText().toString();
        String contrase=con.getText().toString();
        if(!nombre.isEmpty() && !contrase.isEmpty()){
            Cursor fila=BaseDatos.rawQuery("Select * from usuarios where nombre=? and contrasena=?",new String[]{nombre,contrase},null);
            if(fila.moveToFirst()){
                Intent sigu=new Intent(this,inicio.class);
                startActivity(sigu);
                BaseDatos.close();
            }
            else{
                Toast anun=Toast.makeText(getApplicationContext(),"Nombre o Contraseña incorrecto",Toast.LENGTH_SHORT);
                anun.show();
            }
        }
        else{
            Toast anun=Toast.makeText(getApplicationContext(),"Llena los campos",Toast.LENGTH_SHORT);
            anun.show();
        }
    }
    public void registrarse(View V){
        Intent sig=new Intent(this,registrar.class);
        startActivity(sig);
    }
}