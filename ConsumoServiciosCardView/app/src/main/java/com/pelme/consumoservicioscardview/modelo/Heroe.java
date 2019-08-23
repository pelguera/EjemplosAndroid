package com.pelme.consumoservicioscardview.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Heroe {

    private String id;
    private String name;
    @SerializedName("biography")
    private HeroeBiografia biografia;
    @SerializedName("image")
    private HeroeImagen imagen;


    public Heroe(String id, String name, HeroeBiografia biografia, HeroeImagen imagen) {
        this.id = id;
        this.name = name;
        this.biografia = biografia;
        this.imagen = imagen;
    }

    public HeroeBiografia getBiografia() {
        return biografia;
    }

    public void setBiografia(HeroeBiografia biografia) {
        this.biografia = biografia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroeImagen getImagen() {
        return imagen;
    }

    public void setImagen(HeroeImagen imagen) {
        this.imagen = imagen;
    }

    public static HeroeBiografia parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        HeroeBiografia bio = gson.fromJson(response, HeroeBiografia.class);
        return bio;
    }

    public static HeroeImagen parseJSONImagen(String response){
        Gson gson = new GsonBuilder().create();
        HeroeImagen imagen = gson.fromJson(response, HeroeImagen.class);
        return imagen;
    }
}
