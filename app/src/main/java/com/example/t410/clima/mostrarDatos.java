package com.example.t410.clima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android .widget.ImageView;
import android.graphics.drawable.Drawable;

public class mostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        ImageView img = (ImageView) findViewById(R.id.fondo);

        Bundle datos = this.getIntent().getExtras();
        //String ciudad = (String)datos.getString("city");
        String ciudad = getIntent().getStringExtra("city");
        int temp = datos.getInt("temp");
        String des = getIntent().getStringExtra("description");

        if (des.equals("Clouds")){
            img.setBackgroundResource(R.drawable.clouds);
        } else if (des.equals("Clear")){
            img.setBackgroundResource(R.drawable.clear);
        } else if (des.equals("Rain")){
            img.setBackgroundResource(R.drawable.rain);
        } else if (des.equals("Thunderstorm")){
            img.setBackgroundResource(R.drawable.thunder);
        } else if (des.equals("Drizzle")){
            img.setBackgroundResource(R.drawable.drizzle);
        } else if (des.equals("Atmosphere")){
            img.setBackgroundResource(R.drawable.atm);
        } else if (des.equals("Extreme")){
            img.setBackgroundResource(R.drawable.extreme);
        }
        //int id = getResources().getIdentifier("Clouds.jpg", "drawable", getPackageName());
        //img.setImageResource(id);

        TextView tv1 = (TextView) findViewById(R.id.tvCiudad);
        tv1.setText(ciudad);
        TextView tv2 = (TextView) findViewById(R.id.tvTemp);
        tv2.setText(Integer.toString(temp)+"°C");
        TextView tv3 = (TextView) findViewById(R.id.tvDescription);
        tv3.setText(des);
    }
}
