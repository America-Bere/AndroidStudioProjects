package com.example.crud;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

//import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nombre, puesto, edad, genero;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText)findViewById(R.id.nombre);
        puesto=(EditText)findViewById(R.id.puesto);
        edad=(EditText)findViewById(R.id.edad);
        genero=(EditText)findViewById(R.id.genero);
        insert=(Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REGISTRAR( "http://192.168.67.254/ambiencce/insertar.php");
                //REGISTRAR( "http://192.168.1.75/ambiencce/insertar.php");
            }
        });
    }
    public void siguiente(View W){
        Intent siguiente=new Intent(this,MainActivity2.class);
        startActivity(siguiente);
    }
    public void REGISTRAR(String URL) {
        StringRequest stringRequest =new StringRequest(
                Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Cliente registrado", Toast.LENGTH_SHORT).show();
                        nombre.setText("");
                        puesto.setText("");
                        genero.setText("");
                        edad.setText("");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params=new HashMap<>();
                params.put("nombre",nombre.getText().toString());
                params.put("puesto",puesto.getText().toString());
                params.put("genero",genero.getText().toString());
                params.put("edad",edad.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
/* private static final String urlservidor="http://192.168.1.75/ambiencce/insertar.php";*/