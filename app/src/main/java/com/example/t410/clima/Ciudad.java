package com.example.t410.clima;

/**
 * Created by T410 on 21/08/2017.
 */

public class Ciudad {
    String nombre, id;

    public Ciudad(){
        nombre="";
        id="";
    }

    public Ciudad(String n, String i){
        nombre=n;
        id=i;
    }
    public String getNombre(){
        return nombre;
    }

    public String getId(){
        return id;
    }


    public void setNombre(String n){
        nombre=n;
    }

    public void setId(String i){
        id=i;
    }

}
