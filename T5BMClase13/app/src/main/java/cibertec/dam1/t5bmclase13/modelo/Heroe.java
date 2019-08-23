package cibertec.dam1.t5bmclase13.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Heroe {

    private String id;
    private String name;

    @SerializedName("powerstats")
    private HeroePoderes poderes;

    public Heroe(String id, String name, HeroePoderes poderes) {
        this.id = id;
        this.name = name;
        this.poderes = poderes;
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

    public HeroePoderes getPoderes() {
        return poderes;
    }

    public void setPoderes(HeroePoderes poderes) {
        this.poderes = poderes;
    }


    public static HeroePoderes parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        HeroePoderes poder = gson.fromJson(response, HeroePoderes.class);
        return poder;
    }

}
