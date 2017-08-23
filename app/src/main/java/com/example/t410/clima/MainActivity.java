package com.example.t410.clima;

import android.util.Log;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    static String city="";
    static int temp=0;
    static String description="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int SIMPLE_REQUEST = 1;
        final RequestQueue queue = Volley.newRequestQueue(this);  // this = context

        final ArrayList<Ciudad> cities = new ArrayList<Ciudad>();
        cities.add(new Ciudad("Mexico City", "3530597"));
        cities.add(new Ciudad("Toluca", "3515302"));
        cities.add(new Ciudad("New York", "5128581"));

        setContentView(R.layout.lista);

        ListView lista;
        ArrayAdapter<String> adaptador;
        String[] c = new String[]{"Mexico City", "Toluca", "New York"};
        lista = (ListView) findViewById(R.id.listView);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, c);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {

                String url =  "http://api.openweathermap.org/data/2.5/weather?id="+ cities.get(position).id+"&APPID=80a92ed554c38445b6a7d9b53651d814";
                JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            city = response.getString("name");
                            JSONObject main = response.getJSONObject("main");
                            temp = main.getInt("temp")-273;
                            description = response.getJSONArray("weather").getJSONObject(0).getString("main");
                            Intent act = new Intent(MainActivity.this, mostrarDatos.class);
                            act.putExtra("city", city);
                            act.putExtra("temp", temp);
                            act.putExtra("description", description);
                            startActivity(act);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Log.d("Response", response.toString());
                        //Toast.makeText(getApplicationContext(), "CITY  " + city + "\n TEMP: " + temp + "\n" + "DESCRIPTION: " + description, Toast.LENGTH_SHORT).show();
                    }
                } , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Procesar VolleyError
                    }
                });

                request.setTag(SIMPLE_REQUEST);
                queue.add(request);
            }

        });
    }
}

