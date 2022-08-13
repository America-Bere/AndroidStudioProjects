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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity{
    Button regresar,consultar, actualizar, eliminar;
    EditText nombre2, puesto2, edad2, genero2,idempleado;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        regresar=(Button) findViewById(R.id.regresar);
        actualizar=(Button) findViewById(R.id.actualizar);
        eliminar=(Button) findViewById(R.id.eliminar);
        nombre2=(EditText) findViewById(R.id.nombre2);
        puesto2=(EditText) findViewById(R.id.puesto2);
        edad2=(EditText) findViewById(R.id.edad2);
        genero2=(EditText) findViewById(R.id.genero2);
        idempleado=(EditText) findViewById(R.id.idempleado);
        consultar=(Button) findViewById(R.id.consultar);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String idemp=idempleado.getText().toString().trim();
                buscar( "http://192.168.67.254/ambiencce/buscar.php?id_empleado="+idempleado.getText()+"");
                //buscar( "http://192.168.1.75/ambiencce/buscar.php?id_empleado="+idempleado.getText()+"");
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //elim("http://192.168.1.75/ambiencce/eliminar.php");
                elim("http://192.168.67.254/ambiencce/eliminar.php");
        }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actu("http://192.168.67.254/ambiencce/actualizar.php");
                //actu("http://192.168.1.75/ambiencce/actualizar.php");
            }
        });
    }
    private void buscar(String URL)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nombre2.setText(jsonObject.getString("nombre"));
                        puesto2.setText(jsonObject.getString("puesto"));
                        genero2.setText(jsonObject.getString("genero"));
                        edad2.setText(jsonObject.getString("edad"));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
    /*private void buscar(String URL){
        Toast.makeText(MainActivity2.this, URL, Toast.LENGTH_SHORT).show();
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nombre2.setText(jsonObject.getString("nombre"));
                        puesto2.setText(jsonObject.getString("puesto"));
                        genero2.setText(jsonObject.getString("genero"));
                        edad2.setText(jsonObject.getString("edad"));
                    }
                    catch (JSONException e) {
                        Toast.makeText(MainActivity2.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity2.this, error.toString().toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }*/
    private void elim(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Eliminación exitosa", Toast.LENGTH_SHORT).show();
                idempleado.setText("");
                nombre2.setText("");
                puesto2.setText("");
                genero2.setText("");
                edad2.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("id_empleado", idempleado.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void actu(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Actualización exitosa", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros  = new HashMap<String, String>();
                parametros.put("id_empleado", idempleado.getText().toString());
                parametros.put("nombre", nombre2.getText().toString());
                parametros.put("puesto", puesto2.getText().toString());
                parametros.put("genero", genero2.getText().toString());
                parametros.put("edad",edad2.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void regresar(View W){
        Intent siguiente=new Intent(this,MainActivity.class);
        startActivity(siguiente);
    }
    /*private void buscar(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, (response) -> {
            JSONObject jsonObject = null;
            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = response.getJSONObject(i);
                    nombre2.setText(jsonObject.getString("nombre"));
                    puesto2.setText(jsonObject.getString("puesto"));
                    genero2.setText(jsonObject.getString("genero"));
                    edad2.setText(jsonObject.getString("edad"));
                } catch (JSONException e) {
                    Toast.makeText(MainActivity2.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
                requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }*/
}