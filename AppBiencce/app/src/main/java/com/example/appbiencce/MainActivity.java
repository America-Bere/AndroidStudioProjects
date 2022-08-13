package com.example.appbiencce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

public class MainActivity extends AppCompatActivity {
    Button pb_registrar,pb_ingresar;
    EditText edt_usuario,edt_contraseña;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb_ingresar=findViewById(R.id.pb_ingresar);
        pb_ingresar=findViewById(R.id.pb_registrar);
        edt_usuario=findViewById(R.id.edt_usuario);
        edt_contraseña=findViewById(R.id.edt_contraseña);
    }
    public void iniciar(View V){
        String nombre=edt_usuario.getText().toString();
        String contrase=edt_contraseña.getText().toString();
        if(!nombre.isEmpty() && !contrase.isEmpty()){
            requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
            /*Toast anun=Toast.makeText(getApplicationContext(),"datos llenos",Toast.LENGTH_SHORT);
            anun.show();*/
            Cursor fila=BaseDatos.rawQuery("Select * from usuarios where nombre=? and contrasena=?",new String[]{nombre,contrase},null);
            if(fila.moveToFirst()){
                Toast anun=Toast.makeText(getApplicationContext(),"Iniciaste sesion :D",Toast.LENGTH_SHORT);
                anun.show()
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
}